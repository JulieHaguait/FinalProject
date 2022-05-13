package SkyMaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SkyMaven.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
