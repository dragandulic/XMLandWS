package com.travel.controller.RegUserController.response;

public class LoginResponseDTO {

	private String idToken;
    private String role;
    private String username;
	
    public LoginResponseDTO(String idToken, String role, String username) {
		super();
		this.idToken = idToken;
		this.role = role;
		this.username = username;
	}
    
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
  
}

