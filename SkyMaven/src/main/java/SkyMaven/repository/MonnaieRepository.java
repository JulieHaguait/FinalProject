package SkyMaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import SkyMaven.entity.Monnaie;

public interface MonnaieRepository extends JpaRepository<Monnaie, Long> {

}
