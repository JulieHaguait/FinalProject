package finalProject.SkyBoot.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import finalProject.SkyBoot.entity.Prop;
import finalProject.SkyBoot.entity.Item;
import finalProject.SkyBoot.entity.Emote;
import finalProject.SkyBoot.entity.HeartBuying;
import finalProject.SkyBoot.entity.MusicSheet;
import finalProject.SkyBoot.entity.WingBuff;



public interface ItemRepository extends JpaRepository<Item, Long> {
	
	
	@Query("Select m from MusicSheet m")
	List<MusicSheet> findAllMusicSheet();

	@Query("Select p from Prop p")
	List<Prop> findAllProp();

	@Query("Select e from Emote e")
	List<Emote> findAllEmote();
	
	@Query("Select w from WingBuff w")
	List<WingBuff> findAllWingBuff();
	
	@Query("Select hb from HeartBuying hb")
	List<HeartBuying> findAllHeartBuying();
}
