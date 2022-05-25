package finalProject.SkyBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import finalProject.SkyBoot.entity.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {

	@Query("select n from Node n left join fetch n.nodeEnfants ne where ne=:nodeEnfant")
	List<Node> findAllNodeEnfants(@Param("nodeEnfant") Node nodeEnfant);

	List<Node> findAllByArbreId(Long arbre);
	
	List<Node> findAllByArbreInProgressId(Long arbreInProgress);
}