package finalProject.SkyBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import finalProject.SkyBoot.entity.SkyKid;

public interface SkyKidRepository extends JpaRepository<SkyKid, Long>{
	@Query("Select u from SkyKid u")
	List<SkyKid> findAllSkyKid();
	
	@Query("Select u from SkyKid u left join fetch u.equipment left join fetch u.devise where u.id=:id")
	Optional<SkyKid> findAllInfos(@Param("id") Long id);
}
