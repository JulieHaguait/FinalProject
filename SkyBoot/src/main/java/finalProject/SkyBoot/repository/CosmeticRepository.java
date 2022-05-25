package finalProject.SkyBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import finalProject.SkyBoot.entity.Cape;
import finalProject.SkyBoot.entity.Cheveux;
import finalProject.SkyBoot.entity.Cosmetic;
import finalProject.SkyBoot.entity.Masque;
import finalProject.SkyBoot.entity.Pant;

public interface CosmeticRepository extends JpaRepository<Cosmetic, Long>{

	@Query("Select c from Cosmetic c where type=C")
	List<Cape> findAllCapes();
	
	@Query("Select c from Cosmetic c where type=H")
	List<Cheveux> findAllCheveux();
	
	@Query("Select c from Cosmetic c where type=M")
	List<Masque> findAllMasques();
	
	@Query("Select c from Cosmetic c where type=P")
	List<Pant> findAllPants();

	
	
}