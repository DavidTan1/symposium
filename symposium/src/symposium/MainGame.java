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
		knife = new Weapon("symposium/deathislikethewind/blueorb.png","KNIFE",200,100,"STAB",100); 
		club = new Weapon("symposium/deathislikethewind/hook.png","CLUB",400,320,"STAB",75);
		Firerod = new Weapon("symposium/deathislikethewind/firerod.png","FIRE ROD",100,140,"STAB",150);
		crossBow = new Weapon("symposium/deathislikethewind/crossbow.png","CROSS BOW",400,180,"STAB",125);
		IronSword = new Weapon("symposium/deathislikethewind/ironsword.png","IRON SWORD",800,50,"STAB",150);
		cane = new Weapon("symposium/deathislikethewind/staff.png","CANE",300,50,"STAB",50);
		LongSword = new Weapon("symposium/deathislikethewind/longsword.png","LONG SWORD",700,50,"STAB",175);
		bow = new Weapon("symposium/deathislikethewind/bow.png","BOW",850,50,"STAB",100);
		LightSaber = new Weapon("symposium/deathislikethewind/lightsaber.png","LIGHT SABER",1000,50,"STAB",200);
		axe = new Weapon("symposium/deathislikethewind/axe.png","AXE",350,50,"STAB",100);
		pistol = new Weapon("symposium/deathislikethewind/pistol.png","PISTOL",700,50,"STAB",175);
		rocketL = new Weapon("symposium/deathislikethewind/rocketl.png","ROCKET",2000,100,"STAB",225);
		treeBranch = new Weapon("symposium/deathislikethewind/treebranch.png","TREEBRANCH",200,50,"STAB",25);
		scythe = new Weapon("symposium/deathislikethewind/scythe.png","SCYTHE",900,50,"STAB",200);
		claws = new Weapon("symposium/deathislikethewind/claws.png","CLAWS",500,25,"STAB",100);
		ElectricLance = new Weapon("symposium/deathislikethewind/lightinglance.png","ELECTRIC LANCE",900,75,"STAB",200);
		stick = new Weapon("symposium/deathislikethewind/stick.png","STICK",10,1,"STAB",10);
		hammer = new Weapon("symposium/deathislikethewind/hammertime.png","HAMMER",100,10,"STAB",50);
		shotgun = new Weapon("symposium/deathislikethewind/shotgun.png","SHOTGUN",800,10,"STAB",210);
		spear = new Weapon("symposium/deathislikethewind/spear.png","SPEAR",100,5,"STAB",50);
		rags = new Armor("RAGS", 10, 5);
		mc = new Hero(IronSword,rags,1,1,1,1,1,100);
		
		
		
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