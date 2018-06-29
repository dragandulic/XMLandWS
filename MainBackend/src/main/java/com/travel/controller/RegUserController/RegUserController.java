package com.travel.controller.RegUserController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;
import com.travel.controller.AgentController.response.MessageResponse;
import com.travel.controller.RegUserController.dto.LoginDTO;
import com.travel.controller.RegUserController.dto.RegistrationDTO;
import com.travel.controller.RegUserController.response.LoginTokenResponseDTO;
import com.travel.controller.RegUserController.response.RegUserResponse;
import com.travel.model.Admin;
import com.travel.model.RegUser;
import com.travel.model.Reservation;
import com.travel.repositories.RegUserRepository;
import com.travel.security.TokenProvider;
import com.travel.security.UserDetailsServiceImpl;
import com.travel.services.AdminService;
import com.travel.services.RegUserService;
import com.travel.services.ReservationService;
import com.travel.validation.PasswordMatchesValidator;

@CrossOrigin
@RestController
@RequestMapping("/reguser")
public class RegUserController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private RegUserService reguserService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private ReservationService rService;

	@Autowired
	private JavaMailSender sender;

	@Autowired
	RegUserRepository reguserRepository;

	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */

	@Autowired
	private HttpSession httpSession;

	@JsonValue
	// @PreAuthorize("hasAnyRole('USER')")
	@GetMapping("/getUsers")
	public RegUserResponse getUsers() {

		List<RegUser> listus = reguserService.getAllUsers();
		return new RegUserResponse(listus);
		// return "USPEO SAM";

	}

	@GetMapping("/getUser/{userId}")
	public RegUser getUser(@PathVariable Long userId) {
		RegUser user = reguserService.getRegUserById(userId);

		return user;
	}

	@PostMapping("/blockUser/{userId}")
	public MessageResponse blockUser(@PathVariable Long userId) {
		RegUser user = reguserService.getRegUserById(userId);

		user.setBlocked(true);
		RegUser blocked = reguserService.saveRegUser(user);
		if (blocked != null) {
			return new MessageResponse("Successfully blocked selected user");
		} else {

			return new MessageResponse("Failed to block selected user");
		}
	}

	@PostMapping("/unblockUser/{userId}")
	public MessageResponse unblockUser(@PathVariable Long userId) {
		RegUser user = reguserService.getRegUserById(userId);

		user.setBlocked(false);
		RegUser unblocked = reguserService.saveRegUser(user);
		if (unblocked != null) {
			return new MessageResponse("Successfully unblocked selected user");
		} else {

			return new MessageResponse("Failed to unblock selected user");
		}
	}

	@DeleteMapping("deleteUser/{userId}")
	public MessageResponse deleteUser(@PathVariable Long userId) {

		reguserService.deleteRegUser(reguserRepository.findByIdEquals(userId));

		return new MessageResponse("Successfully deleted selected user");

	}

	@JsonValue
	@PostMapping("/registration")
	public MessageResponse registration(@RequestBody @Valid RegistrationDTO registrationDTO) {

		if (reguserService.checkUniqueEmail(registrationDTO.getEmail()) == false) {

			return new MessageResponse("There is already user with the same email");
		}

		PasswordMatchesValidator pass = new PasswordMatchesValidator();
		if (pass.isValid(registrationDTO) == false) {
			return new MessageResponse("You must retype the same password again");
		}

		RegUser user = reguserService.registerNewUserAccount(registrationDTO);

		return new MessageResponse("User is registrated");
	}

	@JsonValue
	@PostMapping("/login")
	public LoginTokenResponseDTO loginUser(@RequestBody LoginDTO loginDTO) {
		
		RegUser temp = reguserService.findOneUserByEmail(loginDTO.getEmail());
		System.out.println(temp);
		
		if (temp.isBlocked() == true) {
			return null;
		}

		if (temp == null) {
			System.out.println("privi");
			return null;
		}
		
		if(!passwordEncoder.matches(loginDTO.getPassword(), temp.getPassword())) {
			return null;
		}
		
		List<Reservation> listr = rService.getAllReserOfRegUser(temp.getId());

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);

		LocalDate localdate = LocalDate.now();

		for (int i = 0; i < listr.size(); i++) {

			LocalDate reservedfrom = LocalDate.parse(listr.get(i).getEnddate(), formatter);

			if (!reservedfrom.isAfter(localdate)) {

				String appUrl = "http://localhost:4201/review/" + listr.get(i).getAccommodation().getId();
				SimpleMailMessage messageEmail = new SimpleMailMessage();
				messageEmail.setTo(temp.getEmail());
				messageEmail.setSubject("Please rate " + listr.get(i).getAccommodation().getName());
				messageEmail.setText("Please rate on this link below:\n" + appUrl);

				sender.send(messageEmail);

			}

		}

		// SECURITY
		UserDetails details = userDetailsServiceImpl.loadUserByUsername(loginDTO.getEmail());
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginDTO.getEmail(), loginDTO.getPassword());

		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(details);

		String role = details.getAuthorities().stream().findFirst().get().getAuthority();

		return new LoginTokenResponseDTO(temp, jwt);

	}

	@JsonValue
	@PostMapping("/loginAdmin")
	public MessageResponse loginAdmin(@RequestBody @Valid LoginDTO loginDTO) {

		Admin temp = adminService.findOneAdminByEmail(loginDTO.getEmail());

		if (temp == null) {
			return new MessageResponse("Invalid email");

		}

		if (!(loginDTO.getPassword().equals(temp.getPassword()))) {
			return new MessageResponse("Invalid password");

		}

		return new MessageResponse("Admin is logged in");
	}

	@PostMapping("/logout")
	public MessageResponse logout(HttpServletRequest request, HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SecurityContextHolder.getContext().setAuthentication(null);
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return new MessageResponse("User is logged out");
	}

	@PostMapping("/confirm")
	public MessageResponse emailConfirm(@RequestParam("token") String token) {

		RegUser user = reguserService.findByConfirmationToken(token);

		if (user == null) {
			return new MessageResponse("Oops! This token is invalid!");
		}
		user.setActive(true);
		reguserService.saveRegUser(user);
		return new MessageResponse("User is activated");
	}

	@GetMapping("/getActiveUser")
	@ResponseBody
	public String getActiveUser() {

		// CustomUserDetails customUser = (CustomUserDetails)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// return customUser.getEmail();
		return "Obrisi ovo";

	}

}
