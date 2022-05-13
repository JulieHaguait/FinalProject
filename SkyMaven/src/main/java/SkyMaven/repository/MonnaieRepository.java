package SkyMaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SkyMaven.entity.BougieBlanche;
import SkyMaven.entity.BougieRouge;
import SkyMaven.entity.Coeur;
import SkyMaven.entity.Monnaie;

public interface MonnaieRepository extends JpaRepository<Monnaie, Long> {

	@Query("Select bb from BougieBlanche bb")
	List<BougieBlanche> findAllBougieBlanche();

	@Query("Select br from BougieRouge br")
	List<BougieRouge> findAllBougieRouge();

	@Query("Select e from Emote e")
	List<Coeur> findAllCoeur();
	
	
}
