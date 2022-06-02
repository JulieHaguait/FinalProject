package finalProject.SkyBoot.repository;

import java.util.List;
import java.util.Optional;

import finalProject.SkyBoot.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import finalProject.SkyBoot.entity.User;

import finalProject.SkyBoot.entity.SkyKid;

public interface UserRepository extends JpaRepository<User, Long> {

	
	@Query("Select u from User u where u.login=:login and u.password=:password")
	Optional<User> seConnecter(@Param("login") String login, @Param("password") String password);

	
	

	
	
	
	
	Optional<User> findByLogin(String login);
}
