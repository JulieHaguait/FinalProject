package SkyMaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import SkyMaven.entity.Node;


public interface NodeRepository extends JpaRepository<Node, Long> {

	@Query("select n from Node n left join fetch n.nodeEnfants ne where ne=:nodeEnfant")
	List<Node> findAllNodeEnfants(@Param("nodeEnfant") Node nodeEnfant);
}
