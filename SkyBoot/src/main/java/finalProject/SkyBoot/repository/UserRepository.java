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

	
	@Query("Select u from User u where type=skykid")
	List<SkyKid> findAllSkyKid();

	@Query("Select u from User u where type=admin")
	List<Admin> findAllAdmin();
	
	@Query("Select u from User u left join fetch u.equipment left join fetch u.devise where u.id=:id")
	Optional<SkyKid> findAllInfos(@Param("id") Long id);
	
	Optional<User> findByLogin(String login);
}