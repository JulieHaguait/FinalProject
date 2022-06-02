package finalProject.SkyBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import finalProject.SkyBoot.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	@Query("Select u from Admin u")
	List<Admin> findAllAdmin();
}
