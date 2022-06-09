package finalProject.SkyBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import finalProject.SkyBoot.entity.LinkNode;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.Realm;

public interface LinkNodeRepository extends JpaRepository<LinkNode, Long>{

	
	// pour afficher l'inventaire du skykid
	@Query("Select ln from LinkNode ln "
			+ "left join fetch ln.allBought b "
			+ "left join fetch ln.skyKid s "
			+ "where s.id=:id")
	Optional<LinkNode> findBoughtBySkyKidId(@Param("id") Long id);
	
	@Query("Select ln from LinkNode ln "
			+ "left join fetch ln.allRefs r "
			+ "left join fetch ln.skyKid s "
			+ "where s.id=:id")
	Optional<LinkNode> findRefBySkyKidId(@Param("id") Long id);
	
	//pour la boutique d'un realm
	@Query("Select ln from LinkNode ln "
			+ "left join fetch ln.skyKid s "
			+ "left join fetch ln.allRefs ref "
			+ "where s.id=:id and ref.realm=:realm")
	Optional<LinkNode> findByRealmBySkyKidId(@Param("id") Long id, @Param("realm") Realm realm);
}
