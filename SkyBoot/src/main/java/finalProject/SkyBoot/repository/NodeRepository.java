package finalProject.SkyBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import finalProject.SkyBoot.entity.Arbre;
import finalProject.SkyBoot.entity.ArbreInProgress;
import finalProject.SkyBoot.entity.Node;

public interface NodeRepository extends JpaRepository<Node, Long> {

	@Query("select n from Node n left join fetch n.nodeParent np where np=:nodeParent")
	List<Node> findAllNodeEnfants(@Param("nodeParent") Node nodeParent);

	List<Node> findByTref(Arbre arbre);
	
	List<Node> findByTripRef(ArbreInProgress arbre);
	
	List<Node> findByTripProgress(ArbreInProgress arbreInProgress);
}