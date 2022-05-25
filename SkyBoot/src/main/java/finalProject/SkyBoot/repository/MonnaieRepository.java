package finalProject.SkyBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import finalProject.SkyBoot.entity.BougieBlanche;
import finalProject.SkyBoot.entity.BougieRouge;
import finalProject.SkyBoot.entity.Coeur;
import finalProject.SkyBoot.entity.Monnaie;

public interface MonnaieRepository extends JpaRepository<Monnaie, Long> {

	@Query("Select bb from BougieBlanche bb")
	List<BougieBlanche> findAllBougieBlanche();

	@Query("Select br from BougieRouge br")
	List<BougieRouge> findAllBougieRouge();

	@Query("Select e from Emote e")
	List<Coeur> findAllCoeur();
	
	
}
