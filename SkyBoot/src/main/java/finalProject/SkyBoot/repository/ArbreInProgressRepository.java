package finalProject.SkyBoot.repository;

import java.util.List;
import java.util.Optional;
import finalProject.SkyBoot.entity.Realm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import finalProject.SkyBoot.entity.ArbreInProgress;


public interface ArbreInProgressRepository extends JpaRepository<ArbreInProgress, Long> {

	@Query("Select a from Arbre left join fetch a.nodeBought where a.id=:id")
	Optional<ArbreInProgress> findByIdWithNodes(@Param("id") Long id);
	
	@Query("Select a from ArbreInPreogress where a.realm=:realm")
	List<ArbreInProgress> findByRealm(@Param("realm") Realm realmEnum);

}
