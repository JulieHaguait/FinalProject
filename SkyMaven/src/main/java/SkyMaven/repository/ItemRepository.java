package SkyMaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SkyMaven.entity.Item;


public interface ItemRepository extends JpaRepository<Item, Long> {

}
