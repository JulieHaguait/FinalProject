package finalProject.SkyBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.Realm;

public interface NodeRefRepository extends JpaRepository<NodeRef, Long> {

	List<NodeRef> findByNodeParent(NodeRef nodeParent);

	//requete qui recupere tous les noeuds d'un meme royaume
	List<NodeRef> findByRealm(Realm realm);

	//requete qui recupere tous les noeuds d'un meme nom d'esprit
	List<NodeRef> findBySpiritName(String spiritName);
	
	@Query("Select nr from NodeRef nr where nr.nodeParent is null")
	List<NodeRef> findAllNodeRoot();
	
	
}