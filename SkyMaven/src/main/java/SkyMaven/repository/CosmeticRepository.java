package SkyMaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SkyMaven.entity.Cape;
import SkyMaven.entity.Cheveux;
import SkyMaven.entity.Cosmetic;
import SkyMaven.entity.Masque;
import SkyMaven.entity.Pant;

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
