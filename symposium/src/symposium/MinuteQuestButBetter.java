package symposium;

import guiTeacher.GUIApplication;

public class MinuteQuestButBetter extends GUIApplication {

	public static MinuteQuestButBetter gameGUI;
	// public static Inventory inventory;
	public static Battle battle;
	public static Shop shop;
	public static Hero mc;
	
	
	//public static Weapon knife;
	public static Weapon axe;
	public static Weapon rod;
	public static Weapon sword;
	public static Weapon fist;
	public static Weapon nonew;


	public static Armor nonea;
	public static Armor advancerobe;
	public static Armor advancebasicarmor;
	public static Armor robe;
	public static Armor basicarmor;

	public static Mobs slime;
	public static Mobs demon;
	public static Mobs beast;
	public static Mobs vampire;
	public static Mobs bdragon;
	public static Mobs deadMob;

	public MinuteQuestButBetter(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {

		creation();
		// TODO Auto-generated method stub
		shop = new Shop(getWidth(), getHeight());
		battle = new Battle(getWidth(), getHeight());
		// inventory = new Inventory(getWidth(),getHeight());
		setScreen(shop);

	}

	public static void main(String[] args) {

		gameGUI = new MinuteQuestButBetter(800, 800);
		Thread runner =
				new Thread(gameGUI);
		runner.start();

	}

	public static void creation() {
		
		axe = new Weapon("symposium/deathislikethewind/axe.png", "AXE", 400, 320, "STAB", 75);
		rod = new Weapon("symposium/deathislikethewind/firerod.png", "ROD", 100, 140, "STAB", 150);
		sword = new Weapon("symposium/deathislikethewind/longsword.png", "SWORD", 700, 50, "STAB", 175);
		fist = new Weapon("symposium/deathislikethewind/hook.png", "FIST", 700, 50, "STAB", 175);
		nonew = new Weapon("", "no weapon", 0, 0, "", 0);

		
		nonea = new Armor("no armor", 0, 0, 0, "symposium/white.png");
		advancerobe = new Armor("ADVANCE ROBE", 10, 25, 80, "symposium/armor/beginnerrobe.png");
		advancebasicarmor = new Armor("ADVANCE ARMOR", 20, 50, 400, "symposium/armor/bronzearmor.png");
		basicarmor = new Armor("BASIC ARMOR", 30, 75, 750, "symposium/armor/devilarmor.png");
		robe = new Armor("BASIC ROBE", 40, 100, 800, "symposium/armor/diamondarmor.png");
		
		mc = new Hero(nonew, nonea, 10, 10, 10, 10, 1, 100);

		//mobs parameters: String img, String name ,int str, int agl, int vit, int luk, int level, int positionx, int positiony
		slime = new Mobs(	"symposium/slime.png", 			"Slime",		10, 10, 50, 15, 1, 150, 603);
		demon = new Mobs(	"symposium/demonmetus.png", "Demon",		10, 10, 50, 15, 1, 300, 603);
		beast = new Mobs(	"symposium/wildbeast.png", 			"Wild Beast",	10, 10, 50, 15, 1, 450, 603);
		vampire = new Mobs(	"symposium/blackmage.png", 			"Vampire",		10, 10, 50, 15, 1, 600, 603);
		bdragon = new Mobs(	"symposium/bdragon.png", 	"Black Dragon",	10, 10, 50, 15, 1, 750, 603);

		
		//hero parameters: Weapon weapon, Armor armor, int str, int agl, int vit, int luk, int level, int gold

	}

}
