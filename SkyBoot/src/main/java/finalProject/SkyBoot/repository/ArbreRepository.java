package finalProject.SkyBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import finalProject.SkyBoot.entity.Arbre;

public interface ArbreRepository extends JpaRepository<Arbre, Long> {

	@Query("Select a from Arbre left join fetch a.nodes where a.id=:id")
	Optional<Arbre> findByIdWithNodes(@Param("id") Long id);

}