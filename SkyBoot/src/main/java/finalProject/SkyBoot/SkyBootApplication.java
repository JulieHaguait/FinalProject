package finalProject.SkyBoot;

//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import finalProject.SkyBoot.entity.Admin;
//import finalProject.SkyBoot.entity.Arbre;
//import finalProject.SkyBoot.entity.ArbreInProgress;
//import finalProject.SkyBoot.entity.BougieBlanche;
//import finalProject.SkyBoot.entity.BougieRouge;
//import finalProject.SkyBoot.entity.Cape;
//import finalProject.SkyBoot.entity.Cheveux;
//import finalProject.SkyBoot.entity.Coeur;
//import finalProject.SkyBoot.entity.Devise;
//import finalProject.SkyBoot.entity.Emote;
//import finalProject.SkyBoot.entity.Equipment;
//import finalProject.SkyBoot.entity.HeartBuying;
//import finalProject.SkyBoot.entity.Masque;
//import finalProject.SkyBoot.entity.Monnaie;
//import finalProject.SkyBoot.entity.MusicSheet;
//import finalProject.SkyBoot.entity.Node;
//import finalProject.SkyBoot.entity.Pant;
//import finalProject.SkyBoot.entity.Prop;
//import finalProject.SkyBoot.entity.Realm;
//import finalProject.SkyBoot.entity.SkyKid;
//import finalProject.SkyBoot.entity.Spell;
//import finalProject.SkyBoot.entity.SpellSlot;
//import finalProject.SkyBoot.entity.WingBuff;
//import finalProject.SkyBoot.service.ArbreInProgressService;
//import finalProject.SkyBoot.service.ArbreService;
//import finalProject.SkyBoot.service.CosmeticService;
//import finalProject.SkyBoot.service.DeviseService;
//import finalProject.SkyBoot.service.EmoteService;
//import finalProject.SkyBoot.service.EquipmentService;
//import finalProject.SkyBoot.service.ItemService;
//import finalProject.SkyBoot.service.MonnaieService;
//import finalProject.SkyBoot.service.NodeService;
//import finalProject.SkyBoot.service.SpellService;
//import finalProject.SkyBoot.service.SpellSlotService;
//import finalProject.SkyBoot.service.UserService;

@SpringBootApplication
public class SkyBootApplication {

//	@Autowired
//	private ArbreInProgressService tripService;
//
//	@Autowired
//	private ArbreService trefService;
//
//	@Autowired
//	private CosmeticService cosService;
//
//	@Autowired
//	private DeviseService devService;
//
//	@Autowired
//	private EmoteService emService;
//
//	@Autowired
//	private EquipmentService equService;
//
//	@Autowired
//	private ItemService itemService;
//
//	@Autowired
//	private MonnaieService monnaieService;
//
//	@Autowired
//	private NodeService nodeService;
//
//	@Autowired
//	private SpellService spellService;
//
//	@Autowired
//	private SpellSlotService spellSlotService;
//
//	@Autowired
//	private UserService userService;

//	public void run() {
//		Admin admin1 = new Admin();
//		admin1.setLogin("admin");
//		admin1.setPassword("root");
//		userService.create(admin1);
//
//		SkyKid Julie = new SkyKid();
//		Julie.setLogin("Luna");
//		Julie.setNbEnfant(106);
//		Julie.setPassword("tik");
//		Julie.setTrips(null);
//		Julie.setWingBuff(0);
//		userService.create(Julie);
//				
//		SkyKid Hamza = new SkyKid();
//		Hamza.setLogin("Taif");
//		Hamza.setNbEnfant(24);
//		Hamza.setPassword("taif");
//		Hamza.setTrips(null);
//		Hamza.setWingBuff(0);
//		userService.create(Hamza);
//		
//		Cape cape1 = new Cape("brune",0);
//		Cape cape2 = new Cape("jaune",3);
//		Cape cape3 = new Cape("rouge",10);
//		Cape cape4 = new Cape("vert",15);
//		Cape cape5 = new Cape("sarcelle",20);
//		cosService.create(cape1);
//		cosService.create(cape2);
//		cosService.create(cape3);
//		cosService.create(cape4);
//		cosService.create(cape5);
//		
//		Cheveux cheveux1 = new Cheveux("base",0);
//		Cheveux cheveux2 = new Cheveux("Cirier_Pointant",0);
//		Cheveux cheveux3 = new Cheveux("Voyageur_Refusant",1);
//		Cheveux cheveux4 = new Cheveux("Fabricant_De_Cloche",2);
//		Cheveux cheveux5 = new Cheveux("Fabriquant_De_Bateaux",3);
//		cosService.create(cheveux1);
//		cosService.create(cheveux2);
//		cosService.create(cheveux3);
//		cosService.create(cheveux4);
//		cosService.create(cheveux5);
//		
//		Masque m1 = new Masque("base",0);
//		Masque m2 = new Masque();
//		Masque m3 = new Masque();
//		cosService.create(m1);
//		cosService.create(m2);
//		cosService.create(m3);
//		
//		Pant pbase = new Pant("base", 0);
//		Pant p1 = new Pant("first", 4);
//		Pant p2 = new Pant("second", 4);
//		cosService.create(pbase);
//		cosService.create(p1);
//		cosService.create(p2);
//		
//		Prop prop1 = new Prop("harpe", 5, "instrument à cordes pincées");
//		Prop prop2 = new Prop("djembé", 5, "instrument à percussion");
//		itemService.create(prop1);
//		itemService.create(prop2);
//		
//		Equipment equipJulie = new Equipment();
//		equipJulie.setCape(cape5);
//		equipJulie.setHair(cheveux5);
//		equipJulie.setMasque(m3);
//		equipJulie.setPant(p2);
//		equipJulie.setProp(prop2);
//		equService.create(equipJulie);
//		Julie.setEquipement(equipJulie);
//		
//		Equipment equipHamza = new Equipment();
//		equipHamza.setCape(cape1);
//		equipHamza.setHair(cheveux1);
//		equipHamza.setMasque(m1);
//		equipHamza.setPant(pbase);
//		equipHamza.setProp(prop1);
//		equService.create(equipHamza);
//		Hamza.setEquipement(equipHamza);
//		
//		BougieBlanche bb = new BougieBlanche();
//		monnaieService.create(bb);
//		BougieRouge br = new BougieRouge();
//		monnaieService.create(br);
//		Coeur coeur = new Coeur();
//		monnaieService.create(coeur);
//		
//		Devise devise1 = new Devise();
//		devise1.setQuantite(117);
//		devise1.setMonnaie(bb);
//		devService.create(devise1);
//		Devise devise2 = new Devise();
//		devise1.setQuantite(56);
//		devise1.setMonnaie(br);
//		devService.create(devise2);
//		Devise devise3 = new Devise();
//		devise1.setQuantite(38);
//		devise1.setMonnaie(coeur);
//		devService.create(devise3);
//		
//		Devise devise4 = new Devise();
//		devise1.setQuantite(500);
//		devise1.setMonnaie(bb);
//		devService.create(devise4);
//		Devise devise5 = new Devise();
//		devise1.setQuantite(0);
//		devise1.setMonnaie(br);
//		devService.create(devise5);
//		Devise devise6 = new Devise();
//		devise1.setQuantite(2);
//		devise1.setMonnaie(coeur);
//		devService.create(devise6);
//		
//		Set<Devise> argent1 = new HashSet<Devise>();
//		Collections.addAll(argent1, devise1, devise2, devise3);
//		Julie.setDevise(argent1);
//		
//		Set<Devise> argent2 = new HashSet<Devise>();
//		Collections.addAll(argent2, devise4, devise5, devise6);
//		Hamza.setDevise(argent2);
//		
//		HeartBuying heartBuying1 = new HeartBuying("HeartBuyingArbre1",3);
//		itemService.create(heartBuying1);
//		HeartBuying heartBuying2 = new HeartBuying("HeartBuyingArbre2",3);
//		itemService.create(heartBuying2);
//		HeartBuying heartBuying3 = new HeartBuying("HeartBuyingArbre3",3);
//		itemService.create(heartBuying3);
//		HeartBuying heartBuying4 = new HeartBuying("HeartBuyingArbre4",3);
//		itemService.create(heartBuying4);
//		
//		Spell s1 = new Spell("FullCharge", 1, "Recharge complete");
//		spellService.create(s1);
//		Spell s2 = new Spell("Shrink", 5, "Shrink 5 min");
//		spellService.create(s2);
//		Spell s3 = new Spell("Giant", 1, "Giant 5 min");
//		spellService.create(s3);
//		Spell s4 = new Spell("Trainee", 5, "Trainee noire 30 min");
//		spellService.create(s4);
//
//		SpellSlot ss1 = new SpellSlot(1);
//		ss1.setSpell(s1);
//		spellSlotService.create(ss1);
//		SpellSlot ss2 = new SpellSlot(2);
//		ss2.setSpell(s2);
//		spellSlotService.create(ss2);
//		SpellSlot ss3 = new SpellSlot(3);
//		ss3.setSpell(s3);
//		spellSlotService.create(ss3);
//		SpellSlot ss4 = new SpellSlot(4);
//		ss2.setSpell(s4);
//		spellSlotService.create(ss4);
//
//		WingBuff wb1 = new WingBuff();
//		wb1.setPrix(1);
//		itemService.create(wb1);
//		WingBuff wb2 = new WingBuff();
//		wb2.setPrix(1);
//		itemService.create(wb2);
//		
//		// --- Isle Emote
//		Emote pointing1 = new Emote("Pointing", 0, 1);
//		emService.create(pointing1);
//		Emote pointing2 = new Emote("Pointing", 1, 2);
//		emService.create(pointing2);
//		Emote pointing3 = new Emote("Pointing", 2, 3);
//		emService.create(pointing3);
//		Emote pointing4 = new Emote("Pointing", 2, 4);
//		emService.create(pointing4);
//		
//		Emote ushering1 = new Emote("Ushering", 0, 1);
//		emService.create(ushering1);
//		Emote ushering2 = new Emote("Ushering", 1, 2);
//		emService.create(ushering2);
//		Emote ushering3 = new Emote("Ushering", 2, 3);
//		emService.create(ushering3);
//		Emote ushering4 = new Emote("Ushering", 2, 4);
//		emService.create(ushering4);
//		
//		Emote rejecting1 = new Emote("Rejecting", 0, 1);
//		emService.create(rejecting1);
//		Emote rejecting2 = new Emote("Rejecting", 1, 2);
//		emService.create(rejecting2);
//		Emote rejecting3 = new Emote("Rejecting", 2, 3);
//		emService.create(rejecting3);
//		Emote rejecting4 = new Emote("Rejecting", 2, 4);
//		emService.create(rejecting4);
//		
//		// --- Prairie Emote
//		Emote butterfly1 = new Emote("Butterfly", 0, 1);
//		emService.create(butterfly1);
//		Emote butterfly2 = new Emote("Butterfly", 1, 2);
//		emService.create(butterfly2);
//		Emote butterfly3 = new Emote("Butterfly", 2, 3);
//		emService.create(butterfly3);
//		Emote butterfly4 = new Emote("Butterfly", 2, 4);
//		emService.create(butterfly4);
//		
//		Emote applauding1 = new Emote("Applauding", 0, 1);
//		emService.create(applauding1);
//		Emote applauding2 = new Emote("Applauding", 1, 2);
//		emService.create(applauding2);
//		Emote applauding3 = new Emote("Applauding", 3, 3);
//		emService.create(applauding3);
//		Emote applauding4 = new Emote("Applauding", 3, 4);
//		emService.create(applauding4);
//		
//		Emote waving1 = new Emote("Waving", 0, 1);
//		emService.create(waving1);
//		Emote waving2 = new Emote("Waving", 1, 2);
//		emService.create(waving2);
//		Emote waving3 = new Emote("Waving", 2, 3);
//		emService.create(waving3);
//		Emote waving4 = new Emote("Waving", 2, 4);
//		emService.create(waving4);
//		Emote waving5 = new Emote("Waving", 3, 5);
//		emService.create(waving5);
//		Emote waving6 = new Emote("Waving", 3, 6);
//		emService.create(waving6);
//		
//		Emote slumbering1 = new Emote("Slumbering", 0, 1);
//		emService.create(slumbering1);
//		Emote slumbering2 = new Emote("Slumbering", 1, 2);
//		emService.create(slumbering2);
//		Emote slumbering3 = new Emote("Slumbering", 2, 3);
//		emService.create(slumbering3);
//		Emote slumbering4 = new Emote("Slumbering", 2, 4);
//		emService.create(slumbering4);
//		
//		Emote ceremonial = new Emote("Ceremonial", 0, 1);
//		emService.create(ceremonial);
//		
//		Emote exhausted1 = new Emote("Exhausted", 0, 1);
//		emService.create(exhausted1);
//		Emote exhausted2 = new Emote("Exhausted", 1, 2);
//		emService.create(exhausted2);
//		Emote exhausted3 = new Emote("Exhausted", 5, 3);
//		emService.create(exhausted3);
//		Emote exhausted4 = new Emote("Exhausted", 5, 4);
//		emService.create(exhausted4);
//		
//		Emote birdWhisperer = new Emote("birdWhisperer", 0, 1);
//		emService.create(birdWhisperer);
//		
//		Emote laughing1 = new Emote("Laughing", 0, 1);
//		emService.create(laughing1);
//		Emote laughing2 = new Emote("Laughing", 1, 2);
//		emService.create(laughing2);
//		Emote laughing3 = new Emote("Laughing", 5, 3);
//		emService.create(laughing3);
//		Emote laughing4 = new Emote("Laughing", 5, 4);
//		emService.create(laughing4);
//		
//		
//		
//		// --- music sheet
//		MusicSheet ms1 = new MusicSheet();
//		itemService.create(ms1);
//		MusicSheet ms2 = new MusicSheet();
//		itemService.create(ms2);
//		MusicSheet ms3 = new MusicSheet();
//		itemService.create(ms3);
//		
//		// --- Pointing Candlemaker
//		Node n1 = new Node();
//		n1.setEmote(pointing1);
//		nodeService.create(n1);
//		
//		Node n2 = new Node();
//		n2.setEmote(pointing2);
//		n2.setNodeParent(n1);
//		nodeService.create(n2);
//		
//		Node n3 = new Node();
//		n3.setCosmetic(cheveux1);
//		n3.setNodeParent(n1);
//		nodeService.create(n3);
//		
//		Node n4 = new Node();
//		n4.setSpell(s1);
//		n4.setNodeParent(n1);
//		nodeService.create(n4);
//		
//		Node n5 = new Node();
//		n5.setCoeurAchat(heartBuying1);
//		n5.setNodeParent(n4);
//		nodeService.create(n5);
//		
//		Node n6 = new Node();
//		n6.setWingBuff(wb1);
//		n6.setNodeParent(n4);
//		nodeService.create(n6);
//		
//		Node n7 = new Node();
//		n7.setEmote(pointing3);
//		n7.setNodeParent(n6);
//		nodeService.create(n7);
//		
//		Node n8 = new Node();
//		n8.setEmote(pointing4);
//		n8.setNodeParent(n7);
//		nodeService.create(n8);
//		
//		Node n9 = new Node();
//		n9.setSpell(s2);
//		n9.setNodeParent(n7);
//		nodeService.create(n9);
//		
//		Node n10 = new Node();
//		n10.setCosmetic(p1);
//		n10.setNodeParent(n7);
//		nodeService.create(n10);
//		
//		// --- Ushering Stargazer
//		Node n11 = new Node();
//		n11.setEmote(ushering1);
//		nodeService.create(n11);
//		
//		Node n12 = new Node();
//		n12.setEmote(ushering2);
//		n12.setNodeParent(n11);
//		nodeService.create(n12);
//		
//		Node n13 = new Node();
//		n13.setCosmetic(cheveux2);
//		n13.setNodeParent(n11);
//		nodeService.create(n13);
//		
//		Node n14 = new Node();
//		n14.setSpell(s4);
//		n14.setNodeParent(n11);
//		nodeService.create(n14);
//		
//		Node n15 = new Node();
//		n15.setCoeurAchat(heartBuying2);
//		n15.setNodeParent(n14);
//		nodeService.create(n15);
//		
//		Node n16 = new Node();
//		n16.setWingBuff(wb2);
//		n16.setNodeParent(n14);
//		nodeService.create(n16);
//		
//		Node n17 = new Node();
//		n17.setEmote(ushering3);
//		n17.setNodeParent(n16);
//		nodeService.create(n17);
//		
//		Node n18 = new Node();
//		n18.setEmote(ushering4);
//		n18.setNodeParent(n17);
//		nodeService.create(n18);
//		
//		Node n19 = new Node();
//		n19.setSpell(s2);
//		n19.setNodeParent(n17);
//		nodeService.create(n19);
//		
//		Node n20 = new Node();
//		n20.setCosmetic(p2);
//		n20.setNodeParent(n17);
//		nodeService.create(n20);
//
//		// --- Arbre ref
//		// Isle
//		Arbre arbre1_1 = new Arbre("Pointing_CandleMaker",Realm.Isle);
//		Set<Node> nodesArbre1 = new HashSet<Node>();
//		Collections.addAll(nodesArbre1, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10);
//		trefService.create(arbre1_1);
//		
//		Arbre arbre1_2 = new Arbre("Ushering_Stargazer",Realm.Isle);
//		Set<Node> nodesArbre2 = new HashSet<Node>();
//		Collections.addAll(nodesArbre2, n11, n12, n13, n14, n15, n16, n17, n18, n19, n20);
//		trefService.create(arbre1_2);
//		
//		//Arbre arbre1_3 = new Arbre("Rejecting_Voyager",Realm.Isle);
//		
//		// Prairie
//		/*Arbre arbre2_1 = new Arbre("Applauding_BellMaker",Realm.Prairie);
//		Arbre arbre2_2 = new Arbre("Waving_BellMaker",Realm.Prairie);
//		Arbre arbre2_3 = new Arbre("Slumbering_Shipwright",Realm.Prairie);
//		Arbre arbre2_4 = new Arbre("Laughing_Light_Catcher",Realm.Prairie);
//		trefService.create(arbre2_1);
//		trefService.create(arbre2_2);
//		trefService.create(arbre2_3);
//		trefService.create(arbre2_4);*/
//		
//		// --- Arbre In progress
//		ArbreInProgress arbreInProg1_1 = new ArbreInProgress();
//		arbreInProg1_1.setTref(arbre1_1);
//		arbreInProg1_1.setNodeRef();
//		arbreInProg1_1.setRealm(Realm.Isle);
//		arbreInProg1_1.setSkyKid(Julie);
//		tripService.create(arbreInProg1_1);
//		
//		ArbreInProgress arbreInProg1_2 = new ArbreInProgress();
//		arbreInProg1_2.setTref(arbre1_2);
//		arbreInProg1_2.setNodeRef();
//		arbreInProg1_2.setRealm(Realm.Isle);
//		arbreInProg1_1.setSkyKid(Julie);
//		tripService.create(arbreInProg1_2);
//		
//		/*ArbreInProgress arbreInProg1_3 = new ArbreInProgress();
//		arbreInProg1_3.setTref(arbre1_3);
//		arbreInProg1_3.setRealm(Realm.Isle);
//		arbreInProg1_1.setSkyKid(Hamza);
//		tripService.create(arbreInProg1_3);
//		
//		ArbreInProgress arbreInProg2_1 = new ArbreInProgress();
//		arbreInProg2_1.setTref(arbre2_1);
//		arbreInProg2_1.setRealm(Realm.Prairie);
//		arbreInProg2_1.setSkyKid(Hamza);
//		tripService.create(arbreInProg2_1);*/
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(SkyBootApplication.class, args);
	}

}
