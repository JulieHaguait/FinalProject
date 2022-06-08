package finalProject.SkyBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.Realm;

public interface NodeRepository extends JpaRepository<Node, Long> {


	

	//requete qui recupere tous les noeuds d'un meme royaume
	@Query("Select n from Node n left join fetch n.nodeRef nr where nr.realm=:realm")
	List<Node> findByRealm(@Param("realm") Realm realm);

	//requete qui recupere tous les noeuds d'un meme nom d'esprit
	@Query("Select n from Node n left join fetch n.nodeRef nr where nr.spiritName=:name")
	List<Node> findBySpirit(@Param("name") String name);
	
	@Query("Select n from Node n left join n.nodeRef nr where nr.id=:id")
	Optional<Node> findByNodeRefId(@Param("id") Long id);
	
	@Query("Select n from Node n left join n.skyKid s where s.id=:id")
	List<Node> findBySkyKidId(@Param("id") Long id);

}