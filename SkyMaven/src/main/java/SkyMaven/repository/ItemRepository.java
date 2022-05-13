package SkyMaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import SkyMaven.entity.Cosmetic;
import SkyMaven.entity.Emote;
import SkyMaven.entity.Item;
import SkyMaven.entity.MusicSheet;
import SkyMaven.entity.Prop;
import SkyMaven.entity.WingBuff;
import SkyMaven.entity.CoeurAchat;



public interface ItemRepository extends JpaRepository<Item, Long> {
	
	
	@Query("Select m from MusicSheet m")
	List<MusicSheet> findAllMusicSheet();

	@Query("Select p from Prop p")
	List<Prop> findAllProp();

	@Query("Select e from Emote e")
	List<Emote> findAllEmote();
	
	@Query("Select w from WingBuff w")
	List<WingBuff> findAllWingBuff();
	
	@Query("Select c from CoeurAchat")
	List<CoeurAchat> findAllCoeurAchat();
}
