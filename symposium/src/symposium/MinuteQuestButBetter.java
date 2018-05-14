package symposium;

import guiTeacher.GUIApplication;

public class MinuteQuestButBetter extends GUIApplication {

	public static MinuteQuestButBetter gameGUI;
	// public static Inventory inventory;
	public static Battle battle;
	public static Shop shop;
	public static Hero mc;
	public static Weapon knife;
	public static Weapon club;
	public static Weapon Firerod;
	public static Weapon crossBow;
	public static Weapon IronSword;
	public static Weapon cane;
	public static Weapon LongSword;
	public static Weapon nonew;


	public static Armor nonea;
	public static Armor beginnerrobe;
	public static Armor bronzearmor;
	public static Armor devilarmor;
	public static Armor diamondarmor;

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
		knife = new Weapon("symposium/deathislikethewind/blueorb.png", "KNIFE", 200, 100, "STAB", 100);
		club = new Weapon("symposium/deathislikethewind/hook.png", "CLUB", 400, 320, "STAB", 75);
		Firerod = new Weapon("symposium/deathislikethewind/firerod.png", "FIRE ROD", 100, 140, "STAB", 150);
		crossBow = new Weapon("symposium/deathislikethewind/crossbow.png", "CROSS BOW", 400, 180, "STAB", 125);
		IronSword = new Weapon("symposium/deathislikethewind/ironsword.png", "IRON SWORD", 800, 50, "STAB", 150);
		cane = new Weapon("symposium/deathislikethewind/staff.png", "CANE", 300, 50, "STAB", 50);
		LongSword = new Weapon("symposium/deathislikethewind/longsword.png", "LONG SWORD", 700, 50, "STAB", 175);
		nonew = new Weapon("", "no weapon", 0, 0, "", 0);


		nonea = new Armor("no armor", 0, 0, 0, "symposium/white.png");
		beginnerrobe = new Armor("beginnerrobe", 10, 25, 80, "symposium/armor/beginnerrobe.png");
		bronzearmor = new Armor("bronzearmor", 20, 50, 400, "symposium/armor/bronzearmor.png");
		devilarmor = new Armor("devilarmor", 30, 75, 750, "symposium/armor/devilarmor.png");
		diamondarmor = new Armor("diamondarmor", 40, 100, 800, "symposium/armor/diamondarmor.png");
		

		slime = new Mobs("symposium/.png", "Slime",50, 10, 25, 100, 1, 150, 603);
		demon = new Mobs("symposium/demonmetus.png", "Demon",50, 10, 25, 100, 1, 300, 603);
		beast = new Mobs("symposium/.png", "Wild Beast",50, 10, 25, 100, 1, 450, 603);
		vampire = new Mobs("symposium/.png", "Vampire",50, 10, 25, 100, 1, 600, 603);
		bdragon = new Mobs("symposium/bdragon.png", "Black Dragon",50, 10, 25, 100, 1, 750, 603);

		mc = new Hero(nonew, nonea, 10, 10, 10, 10, 10, 100);

	}

}
