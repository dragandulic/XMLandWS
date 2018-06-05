package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.admin.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	
	Admin findByIdEquals(Long id);
	
}
