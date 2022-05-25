package finalProject.SkyBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public interface PropRepository extends JpaRepository<Prop, Long>{

}
