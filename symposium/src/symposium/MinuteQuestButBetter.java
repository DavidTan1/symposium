package symposium;

import guiTeacher.GUIApplication;
import javafx.scene.paint.Color;

public class MinuteQuestButBetter extends GUIApplication {

	public static MinuteQuestButBetter gameGUI;
	public static Shop shop;
	public static Hero mc;
	public static Weapon knife;
	public static Weapon club;
	public static Weapon Firerod;
	public static Weapon crossBow;
	public static Weapon IronSword;
	public static Weapon cane;
	public static Weapon LongSword;
	public static Weapon bow;
	public static Weapon LightSaber;
	public static Weapon axe;
	public static Weapon pistol;
	public static Weapon rocketL;
	public static Weapon treeBranch;
	public static Weapon scythe;
	public static Weapon claws;
	public static Weapon ElectricLance;
	public static Weapon stick;
	public static Weapon hammer;
	public static Weapon shotgun;
	public static Weapon spear;
	public static Armor rags;
	
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
		setScreen(shop);
		

	}
	
	
	public static void main(String[] args) {
		
		
		gameGUI = new MinuteQuestButBetter(800, 800);
		Thread runner = new Thread(gameGUI);
		runner.start();
		
		
	}
	
	public static void creation()
	{
		knife = new Weapon("symposium/deathislikethewind/blueorb.png","KNIFE",200,100,"STAB"); 
		club = new Weapon("symposium/deathislikethewind/hook.png","CLUB",400,320,"STAB");
		Firerod = new Weapon("symposium/deathislikethewind/firerod.png","FIRE ROD",100,140,"STAB");
		crossBow = new Weapon("symposium/deathislikethewind/crossbow.png","CROSS BOW",400,180,"STAB");
		IronSword = new Weapon("symposium/deathislikethewind/ironsword.png","IRON SWORD",800,50,"STAB");
		cane = new Weapon("symposium/deathislikethewind/staff.png","CANE",300,50,"STAB");
		LongSword = new Weapon("symposium/deathislikethewind/longsword.png","LONG SWORD",700,50,"STAB");
		bow = new Weapon("symposium/deathislikethewind/bow.png","BOW",850,50,"STAB");
		LightSaber = new Weapon("symposium/deathislikethewind/lightsaber.png","LIGHT SABER",1000,50,"STAB");
		axe = new Weapon("symposium/deathislikethewind/axe.png","AXE",350,50,"STAB");
		pistol = new Weapon("symposium/deathislikethewind/pistol.png","PISTOL",700,50,"STAB");
		rocketL = new Weapon("symposium/deathislikethewind/rocketl.png","ROCKET",2000,100,"STAB");
		treeBranch = new Weapon("symposium/deathislikethewind/treebranch.png","TREEBRANCH",200,50,"STAB");
		scythe = new Weapon("symposium/deathislikethewind/scythe.png","SCYTHE",900,50,"STAB");
		claws = new Weapon("symposium/deathislikethewind/claws.png","CLAWS",500,25,"STAB");
		ElectricLance = new Weapon("symposium/deathislikethewind/lightinglance.png","ELECTRIC LANCE",900,75,"STAB");
		stick = new Weapon("symposium/deathislikethewind/stick.png","STICK",10,1,"STAB");
		hammer = new Weapon("symposium/deathislikethewind/hammertime.png","HAMMER",100,10,"STAB");
		shotgun = new Weapon("symposium/deathislikethewind/shotgun.png","SHOTGUN",800,10,"STAB");
		spear = new Weapon("symposium/deathislikethewind/spear.png","SPEAR",100,5,"STAB");
		
		rags = new Armor("RAGS", 10, 5);
		mc = new Hero(IronSword,rags,1,1,1,1,1);
		
		
		
	}



}
