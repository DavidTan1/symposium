package symposium;

import java.util.ArrayList;

public class MainGame {

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
	
	
	public ArrayList<Weapon> weaponDropList;
	
	public static Armor rags;
	
	public MainGame() {
		
	}

	public static void main(String[] args) {
		
		creation();
		System.out.println("Your character has a "+mc.getWeapon().name()+" equipped.");
		System.out.println("Your character STR: "+mc.getStr() + "->" + mc.setStr());
		System.out.println(mc.getWeapon().img());
		
		System.out.println("Your character has a "+mc.getArmor().getArmorName()+" equipped.");
		System.out.println("Your character VIT: "+mc.getVit() + "->" + mc.setVit());

		
		System.out.println("Your character AGL: "+mc.getAgl() + "->" + mc.setAgl());

	}
	
	
	public static void creation()
	{
		knife = new Weapon("symposium/ironsword.png","KNIFE",200,100,"STAB"); 
		club = new Weapon("symposium/ironsword.png","CLUB",400,320,"STAB");
		Firerod = new Weapon("symposium/ironsword.png","FIRE ROD",100,140,"STAB");
		crossBow = new Weapon("symposium/ironsword.png","CROSS BOW",400,180,"STAB");
		IronSword = new Weapon("symposium/ironsword.png","IRON SWORD",800,50,"STAB");
		cane = new Weapon("symposium/ironsword.png","CANE",300,50,"STAB");
		LongSword = new Weapon("symposium/ironsword.png","LONG SWORD",700,50,"STAB");
		bow = new Weapon("symposium/ironsword.png","BOW",850,50,"STAB");
		LightSaber = new Weapon("symposium/ironsword.png","LIGHT SABER",1000,50,"STAB");
		axe = new Weapon("symposium/ironsword.png","AXE",350,50,"STAB");
		pistol = new Weapon("symposium/ironsword.png","PISTOL",700,50,"STAB");
		rocketL = new Weapon("symposium/ironsword.png","ROCKET",2000,100,"STAB");
		treeBranch = new Weapon("symposium/ironsword.png","TREEBRANCH",200,50,"STAB");
		scythe = new Weapon("symposium/ironsword.png","SCYTHE",900,50,"STAB");
		claws = new Weapon("symposium/ironsword.png","CLAWS",500,25,"STAB");
		ElectricLance = new Weapon("symposium/ironsword.png","ELECTRIC LANCE",900,75,"STAB");
		stick = new Weapon("symposium/ironsword.png","STICK",10,1,"STAB");
		hammer = new Weapon("symposium/ironsword.png","HAMMER",100,10,"STAB");
		shotgun = new Weapon("symposium/ironsword.png","SHOTGUN",800,10,"STAB");
		spear = new Weapon("symposium/ironsword.png","SPEAR",100,5,"STAB");
		
		rags = new Armor("RAGS", 10, 5);
		mc = new Hero(IronSword,rags,1,1,1,1,1);
		
		
		
	}
	
	public void dropRates() {
		
		weaponDropList.add(knife);
		weaponDropList.add(club);
		weaponDropList.add(Firerod);
		weaponDropList.add(crossBow);
		
		weaponDropList.add(IronSword);
		weaponDropList.add(cane);
		weaponDropList.add(LongSword);
		weaponDropList.add(bow);
		
		weaponDropList.add(LightSaber);
		weaponDropList.add(axe);
		weaponDropList.add(pistol);
		weaponDropList.add(rocketL);
		
		weaponDropList.add(treeBranch);
		weaponDropList.add(scythe);
		weaponDropList.add(claws);
		weaponDropList.add(ElectricLance);
		
		weaponDropList.add(stick);
		weaponDropList.add(hammer);
		weaponDropList.add(shotgun);
		weaponDropList.add(spear);
	}
	

}