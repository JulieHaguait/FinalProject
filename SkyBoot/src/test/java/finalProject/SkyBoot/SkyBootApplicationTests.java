package finalProject.SkyBoot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import finalProject.SkyBoot.entity.Admin;
import finalProject.SkyBoot.entity.BougieBlanche;
import finalProject.SkyBoot.entity.BougieRouge;
import finalProject.SkyBoot.entity.Cape;
import finalProject.SkyBoot.entity.Cheveux;
import finalProject.SkyBoot.entity.Coeur;
import finalProject.SkyBoot.entity.Devise;
import finalProject.SkyBoot.entity.Emote;
import finalProject.SkyBoot.entity.Equipment;
import finalProject.SkyBoot.entity.HeartBuying;
import finalProject.SkyBoot.entity.Masque;
import finalProject.SkyBoot.entity.MusicSheet;
import finalProject.SkyBoot.entity.NodeRef;
import finalProject.SkyBoot.entity.Node;
import finalProject.SkyBoot.entity.Pant;
import finalProject.SkyBoot.entity.Prop;
import finalProject.SkyBoot.entity.Realm;
import finalProject.SkyBoot.entity.SkyKid;
import finalProject.SkyBoot.entity.Spell;
import finalProject.SkyBoot.entity.SpellSlot;
import finalProject.SkyBoot.entity.WingBuff;

import finalProject.SkyBoot.repository.DeviseRepository;
import finalProject.SkyBoot.repository.HeartBuyingRepository;
import finalProject.SkyBoot.repository.WingBuffRepository;

import finalProject.SkyBoot.service.CosmeticService;
import finalProject.SkyBoot.service.DeviseService;
import finalProject.SkyBoot.service.EmoteService;
import finalProject.SkyBoot.service.EquipmentService;
import finalProject.SkyBoot.service.ItemService;
import finalProject.SkyBoot.service.MonnaieService;
import finalProject.SkyBoot.service.NodeService;
import finalProject.SkyBoot.service.NodeRefService;
import finalProject.SkyBoot.service.SpellService;
import finalProject.SkyBoot.service.SpellSlotService;
import finalProject.SkyBoot.service.UserService;

@SpringBootTest
class SkyBootApplicationTests {

	@Autowired
	private CosmeticService cosService;

	@Autowired
	private DeviseService devService;

	@Autowired
	private EmoteService emService;

	@Autowired
	private EquipmentService equService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private MonnaieService monnaieService;

	@Autowired
	private NodeRefService nrService;
	
	@Autowired
	private NodeService nodeService;

	@Autowired
	private SpellService spellService;

	@Autowired
	private SpellSlotService spellSlotService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private HeartBuyingRepository heartBuyingRepository;
	
	@Autowired
	private WingBuffRepository wingBuffRepository;
	

	@Test
	@Transactional
	@Commit
	void testBdd() {
		Admin admin1 = new Admin();
		admin1.setLogin("admin");
		admin1.setPassword("root");
		userService.create(admin1);
		
		Cape cape0 = new Cape("debut",0);
		Cape cape1 = new Cape("brune",0);
		Cape cape2 = new Cape("jaune",3);
		Cape cape3 = new Cape("rouge",10);
		Cape cape4 = new Cape("vert",15);
		Cape cape5 = new Cape("sarcelle",20);
		cosService.create(cape0);
		cosService.create(cape1);
		cosService.create(cape2);
		cosService.create(cape3);
		cosService.create(cape4);
		cosService.create(cape5);
		
		Cheveux cheveux0 = new Cheveux("debut",0);
		Cheveux cheveux1 = new Cheveux("base",0);
		Cheveux cheveux2 = new Cheveux("Cirier_Pointant",0);
		Cheveux cheveux3 = new Cheveux("Voyageur_Refusant",1);
		Cheveux cheveux4 = new Cheveux("Fabricant_De_Cloche",2);
		Cheveux cheveux5 = new Cheveux("Fabriquant_De_Bateaux",3);
		cosService.create(cheveux0);
		cosService.create(cheveux1);
		cosService.create(cheveux2);
		cosService.create(cheveux3);
		cosService.create(cheveux4);
		cosService.create(cheveux5);
		
		Masque m0 = new Masque("debut",0);
		Masque m1 = new Masque();
		Masque m2 = new Masque();
		Masque m3 = new Masque();
		cosService.create(m0);
		cosService.create(m1);
		cosService.create(m2);
		cosService.create(m3);
		
		Pant p0 = new Pant("debut", 0);
		Pant p1 = new Pant("first", 4);
		Pant p2 = new Pant("second", 4);
		cosService.create(p0);
		cosService.create(p1);
		cosService.create(p2);
		
		Prop prop1 = new Prop("harpe", 5, "instrument a cordes pincees");
		Prop prop2 = new Prop("djembe", 5, "instrument a percussions");		
		
		BougieBlanche bb = new BougieBlanche();
		bb.setLibelle("Bougie blanche");
		
		BougieRouge br = new BougieRouge();
		br.setLibelle("Bougie rouge");
		
		Coeur coeur = new Coeur();
		coeur.setLibelle("Coeur");
		
		Devise devise1 = new Devise();
		devise1.setQuantite(117);
		devise1.setMonnaie(bb);		
		
		Devise devise2 = new Devise();
		devise2.setQuantite(56);
		devise2.setMonnaie(br);	
		
		Devise devise3 = new Devise();
		devise3.setQuantite(38);
		devise3.setMonnaie(coeur);		
		
		Devise devise4 = new Devise();
		devise4.setQuantite(500);
		devise4.setMonnaie(bb);
	
		Devise devise5 = new Devise();
		devise5.setQuantite(0);
		devise5.setMonnaie(br);	

		Devise devise6 = new Devise();
		devise6.setQuantite(2);
		devise6.setMonnaie(coeur);	
		
		
		
		HeartBuying heartBuying1 = new HeartBuying("HeartBuyingArbre1",3);
		HeartBuying heartBuying2 = new HeartBuying("HeartBuyingArbre2",3);
		HeartBuying heartBuying3 = new HeartBuying("HeartBuyingArbre3",3);
		HeartBuying heartBuying4 = new HeartBuying("HeartBuyingArbre4",3);
		itemService.create(heartBuying1);
		itemService.create(heartBuying2);
		itemService.create(heartBuying3);
		itemService.create(heartBuying4);
		
		Spell s1 = new Spell("FullCharge", 1, "Recharge complete");		
		Spell s2 = new Spell("Shrink", 5, "Shrink 5 min");		
		Spell s3 = new Spell("Giant", 1, "Giant 5 min");		
		Spell s4 = new Spell("Trainee", 5, "Trainee noire 30 min");	
		spellService.create(s1);
		spellService.create(s2);
		spellService.create(s3);
		spellService.create(s4);

		SpellSlot ss1 = new SpellSlot(1);
		ss1.setSpell(s1);
		SpellSlot ss2 = new SpellSlot(2);
		ss2.setSpell(s2);
		SpellSlot ss3 = new SpellSlot(3);
		ss3.setSpell(s3);
		SpellSlot ss4 = new SpellSlot(4);
		ss4.setSpell(s4);
		spellSlotService.create(ss1);
		spellSlotService.create(ss2);
		spellSlotService.create(ss3);
		spellSlotService.create(ss4);
		
		WingBuff wb1 = new WingBuff();
		wb1.setPrix(1);	
		WingBuff wb2 = new WingBuff();
		wb2.setPrix(1);
		itemService.create(wb1);
		itemService.create(wb2);
		
		
		// --- Isle Emote
		Emote pointing1 = new Emote("Pointing", 0, 1);
		Emote pointing2 = new Emote("Pointing", 1, 2);
		Emote pointing3 = new Emote("Pointing", 2, 3);
		Emote pointing4 = new Emote("Pointing", 2, 4);
		emService.create(pointing1);
		emService.create(pointing2);
		emService.create(pointing3);
		emService.create(pointing4);
		
		Emote ushering1 = new Emote("Ushering", 0, 1);
		Emote ushering2 = new Emote("Ushering", 1, 2);
		Emote ushering3 = new Emote("Ushering", 2, 3);
		Emote ushering4 = new Emote("Ushering", 2, 4);
		emService.create(ushering1);
		emService.create(ushering2);
		emService.create(ushering3);
		emService.create(ushering4);
		
		Emote rejecting1 = new Emote("Rejecting", 0, 1);
		Emote rejecting2 = new Emote("Rejecting", 1, 2);
		Emote rejecting3 = new Emote("Rejecting", 2, 3);
		Emote rejecting4 = new Emote("Rejecting", 2, 4);
		emService.create(rejecting1);
		emService.create(rejecting2);
		emService.create(rejecting3);
		emService.create(rejecting4);
		
		
		// --- Prairie Emote
		Emote butterfly1 = new Emote("Butterfly", 0, 1);
		Emote butterfly2 = new Emote("Butterfly", 1, 2);		
		Emote butterfly3 = new Emote("Butterfly", 2, 3);	
		Emote butterfly4 = new Emote("Butterfly", 2, 4);
		emService.create(butterfly1);
		emService.create(butterfly2);
		emService.create(butterfly3);
		emService.create(butterfly4);
		
		
		Emote applauding1 = new Emote("Applauding", 0, 1);
		Emote applauding2 = new Emote("Applauding", 1, 2);
		Emote applauding3 = new Emote("Applauding", 3, 3);		
		Emote applauding4 = new Emote("Applauding", 3, 4);
		emService.create(applauding1);
		emService.create(applauding2);
		emService.create(applauding3);
		emService.create(applauding4);
		
		
		Emote waving1 = new Emote("Waving", 0, 1);
		Emote waving2 = new Emote("Waving", 1, 2);		
		Emote waving3 = new Emote("Waving", 2, 3);	
		Emote waving4 = new Emote("Waving", 2, 4);	
		Emote waving5 = new Emote("Waving", 3, 5);
		Emote waving6 = new Emote("Waving", 3, 6);
		emService.create(waving1);
		emService.create(waving2);
		emService.create(waving3);
		emService.create(waving4);
		emService.create(waving5);
		emService.create(waving6);
	
		
		Emote slumbering1 = new Emote("Slumbering", 0, 1);
		Emote slumbering2 = new Emote("Slumbering", 1, 2);
		Emote slumbering3 = new Emote("Slumbering", 2, 3);
		Emote slumbering4 = new Emote("Slumbering", 2, 4);
		emService.create(slumbering1);
		emService.create(slumbering2);
		emService.create(slumbering3);
		emService.create(slumbering4);
		
		Emote ceremonial = new Emote("Ceremonial", 0, 1);
		emService.create(ceremonial);
		
		Emote exhausted1 = new Emote("Exhausted", 0, 1);
		Emote exhausted2 = new Emote("Exhausted", 1, 2);
		Emote exhausted3 = new Emote("Exhausted", 5, 3);
		Emote exhausted4 = new Emote("Exhausted", 5, 4);	
		emService.create(exhausted1);
		emService.create(exhausted2);
		emService.create(exhausted3);
		emService.create(exhausted4);
		
		Emote birdWhisperer = new Emote("birdWhisperer", 0, 1);	
		emService.create(birdWhisperer);
		
		Emote laughing1 = new Emote("Laughing", 0, 1);
		Emote laughing2 = new Emote("Laughing", 1, 2);	
		Emote laughing3 = new Emote("Laughing", 5, 3);	
		Emote laughing4 = new Emote("Laughing", 5, 4);
		emService.create(laughing1);
		emService.create(laughing2);
		emService.create(laughing3);
		emService.create(laughing4);
		
		// --- music sheet
		MusicSheet ms1 = new MusicSheet();		
		MusicSheet ms2 = new MusicSheet();
		MusicSheet ms3 = new MusicSheet();
		itemService.create(ms1);
		itemService.create(ms2);
		itemService.create(ms3);
		
		// --- Stuff de base
		NodeRef nodeMasque = new NodeRef();
		nodeMasque.setItem(m0);
		NodeRef nodePant = new NodeRef();
		nodePant.setItem(p0);
		NodeRef nodeCape = new NodeRef();
		nodeCape.setItem(cape0);
		NodeRef nodeCheveux = new NodeRef();
		nodeCheveux.setItem(cheveux0);
		
		// --- Pointing Candlemaker
		NodeRef n1 = new NodeRef();
		n1.setRealm(Realm.Isle);
		n1.setSpiritName("Pointing_CandleMaker");
		n1.setItem(pointing1);
		
		NodeRef n2 = new NodeRef();
		n2.setRealm(Realm.Isle);
		n2.setSpiritName("Pointing_CandleMaker");
		n2.setItem(pointing2);
		n2.setNodeParent(n1);
		
		NodeRef n3 = new NodeRef();
		n3.setRealm(Realm.Isle);
		n3.setSpiritName("Pointing_CandleMaker");
		n3.setItem(cheveux1);
		n3.setNodeParent(n1);
		
		NodeRef n4 = new NodeRef();
		n4.setRealm(Realm.Isle);
		n4.setSpiritName("Pointing_CandleMaker");
		n4.setItem(s1);
		n4.setNodeParent(n1);
		
		NodeRef n5 = new NodeRef();
		n5.setRealm(Realm.Isle);
		n5.setSpiritName("Pointing_CandleMaker");
		n5.setItem(heartBuying1);
		n5.setNodeParent(n4);
		
		NodeRef n6 = new NodeRef();
		n6.setRealm(Realm.Isle);
		n6.setSpiritName("Pointing_CandleMaker");
		n6.setItem(wb1);
		n6.setNodeParent(n4);
		
		NodeRef n7 = new NodeRef();
		n7.setRealm(Realm.Isle);
		n7.setSpiritName("Pointing_CandleMaker");
		n7.setItem(pointing3);
		n7.setNodeParent(n6);
		
		NodeRef n8 = new NodeRef();
		n8.setRealm(Realm.Isle);
		n8.setSpiritName("Pointing_CandleMaker");
		n8.setItem(pointing4);
		n8.setNodeParent(n7);
		
		NodeRef n9 = new NodeRef();
		n9.setRealm(Realm.Isle);
		n9.setSpiritName("Pointing_CandleMaker");
		n9.setItem(s2);
		n9.setNodeParent(n7);
		
		NodeRef n10 = new NodeRef();
		n10.setRealm(Realm.Isle);
		n10.setSpiritName("Pointing_CandleMaker");
		n10.setItem(p1);
		n10.setNodeParent(n7);
		
		
		// --- Ushering Stargazer
		NodeRef n11 = new NodeRef();
		n11.setRealm(Realm.Isle);
		n11.setSpiritName("Ushering_Stargazer");
		n11.setItem(ushering1);
		
		NodeRef n12 = new NodeRef();
		n12.setRealm(Realm.Isle);
		n12.setSpiritName("Ushering_Stargazer");
		n12.setItem(ushering2);
		n12.setNodeParent(n11);
		
		NodeRef n13 = new NodeRef();
		n13.setRealm(Realm.Isle);
		n13.setSpiritName("Ushering_Stargazer");
		n13.setItem(cheveux2);
		n13.setNodeParent(n11);
		
		NodeRef n14 = new NodeRef();
		n14.setRealm(Realm.Isle);
		n14.setSpiritName("Ushering_Stargazer");
		n14.setItem(s4);
		n14.setNodeParent(n11);
		
		NodeRef n15 = new NodeRef();
		n15.setRealm(Realm.Isle);
		n15.setSpiritName("Ushering_Stargazer");
		n15.setItem(heartBuying2);
		n15.setNodeParent(n14);
		
		NodeRef n16 = new NodeRef();
		n16.setRealm(Realm.Isle);
		n16.setSpiritName("Ushering_Stargazer");
		n16.setItem(wb2);
		n16.setNodeParent(n14);
		
		NodeRef n17 = new NodeRef();
		n17.setRealm(Realm.Isle);
		n17.setSpiritName("Ushering_Stargazer");
		n17.setItem(ushering3);
		n17.setNodeParent(n16);
		
		NodeRef n18 = new NodeRef();
		n18.setRealm(Realm.Isle);
		n18.setSpiritName("Ushering_Stargazer");
		n18.setItem(ushering4);
		n18.setNodeParent(n17);	
		
		NodeRef n19 = new NodeRef();
		n19.setRealm(Realm.Isle);
		n19.setSpiritName("Ushering_Stargazer");
		n19.setItem(s3);
		n19.setNodeParent(n17);
		
		NodeRef n20 = new NodeRef();
		n20.setRealm(Realm.Isle);
		n20.setSpiritName("Ushering_Stargazer");
		n20.setItem(p2);
		n20.setNodeParent(n17);
		
		
		
		// --- Pointing Candlemaker
		nrService.create(n1);
		nrService.create(n2);
		nrService.create(n3);
		nrService.create(n4);
		nrService.create(n5);
		nrService.create(n6);
		nrService.create(n7);
		nrService.create(n8);
		nrService.create(n9);
		nrService.create(n10);
		
		// --- Ushering Stargazer
		nrService.create(n11);
		nrService.create(n12);
		nrService.create(n13);
		nrService.create(n14);
		nrService.create(n15);
		nrService.create(n16);
		nrService.create(n17);
		nrService.create(n18);
		nrService.create(n19);
		nrService.create(n20);
		
		pointing1.setNodeRef(n1);
		pointing2.setNodeRef(n2);
		pointing3.setNodeRef(n7);
		pointing4.setNodeRef(n8);
		emService.update(pointing1);
		emService.update(pointing2);
		emService.update(pointing3);
		emService.update(pointing4);
		
		ushering1.setNodeRef(n11);
		ushering2.setNodeRef(n12);
		ushering3.setNodeRef(n17);
		ushering4.setNodeRef(n18);
		emService.update(ushering1);
		emService.update(ushering2);
		emService.update(ushering3);
		emService.update(ushering4);
		
		cheveux1.setNodeRef(n3);
		cheveux2.setNodeRef(n13);
		cosService.update(cheveux1);
		cosService.update(cheveux2);
		
		p1.setNodeRef(n10);
		p2.setNodeRef(n20);
		cosService.update(p1);
		cosService.update(p2);
		
		wb1.setNodeRef(n6);
		wb2.setNodeRef(n16);
		wingBuffRepository.save(wb1);
		wingBuffRepository.save(wb2);
		
		heartBuying1.setNodeRef(n4);
		heartBuying2.setNodeRef(n15);
		heartBuyingRepository.save(heartBuying1);
		heartBuyingRepository.save(heartBuying2);
		
		s1.setNodeRef(n4);
		s2.setNodeRef(n9);
		s3.setNodeRef(n19);
		s4.setNodeRef(n14);
		spellService.update(s1);
		spellService.update(s2);
		spellService.update(s3);
		spellService.update(s4);
		
		
		// mise en base		
		itemService.create(prop1);
		itemService.create(prop2);
		
		monnaieService.create(bb);
		monnaieService.create(br);
		monnaieService.create(coeur);
		
		devService.create(devise1);
		devService.create(devise2);
		devService.create(devise3);
		
		devService.create(devise4);
		devService.create(devise5);
		devService.create(devise6);
		
		
		// --- Base
		nrService.create(nodeCape);
		nrService.create(nodeCheveux);
		nrService.create(nodePant);
		nrService.create(nodeMasque);
		
		// --- Pointing Candlemaker
		nrService.create(n1);
		nrService.create(n2);
		nrService.create(n3);
		nrService.create(n4);
		nrService.create(n5);
		nrService.create(n6);
		nrService.create(n7);
		nrService.create(n8);
		nrService.create(n9);
		nrService.create(n10);			
		
		// --- Ushering Stargazer
		nrService.update(n11);
		nrService.update(n12);
		nrService.update(n13);
		nrService.update(n14);
		nrService.update(n15);
		nrService.update(n16);
		nrService.update(n17);
		nrService.update(n18);
		nrService.update(n19);
		nrService.update(n20);
			
			
		// --- Creation SkyKid
		
		SkyKid Julie = new SkyKid();
		Julie.setLogin("Luna");
		Julie.setNbEnfant(106);
		Julie.setPassword("tik");
		Julie.setWingBuff(0);
		
				
		SkyKid Hamza = new SkyKid();
		Hamza.setLogin("Taif");
		Hamza.setNbEnfant(24);
		Hamza.setPassword("taif");
		Hamza.setWingBuff(0);
		
		
		Set<Devise> argent1 = new HashSet<Devise>();	
		Collections.addAll(argent1, devise1, devise2, devise3);
		Julie.setDevise(argent1);
		
		Set<Devise> argent2 = new HashSet<Devise>();
		Collections.addAll(argent2, devise4, devise5, devise6);
		Hamza.setDevise(argent2);
		
		userService.create(Julie);
		userService.create(Hamza);
		
		
	}

	@Test
	@Disabled
	void contextLoads() {
	}

}
