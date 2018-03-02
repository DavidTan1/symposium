package symposium;

import java.util.ArrayList;

public class MainGame {

	public static Hero mc;
	public static Weapon knife;
	public static Weapon club;
	public static Weapon lance;
	public static Weapon rod;
	public static Weapon arrow;
	public static Weapon IronSword;
	
	public ArrayList<Weapon> weaponDropList;
	
	public static Armor rags;
	
	public MainGame() {
		
	}

	public static void main(String[] args) {
		
		creation();
		System.out.println("Your character has a "+mc.getWeapon().name()+" equipped.");
		System.out.println(mc.getWeapon().img());
	}
	
	
	public static void creation()
	{
		IronSword = new Weapon("resources/ironsword.png","IRON SWORD",3,5,"STAB");
		knife = new Weapon("resources/knife.jpg","KNIFE", 5, 1, "STAB");
		club = new Weapon("resources/club.jpg","CLUBS",2,5,"BASH");
		lance = new Weapon("resources/lance.jpg","LANCE",2,5,"JAB");
		rod = new Weapon("resources/rod.jpg","ROD",2,5,"MAGIC"); 
		//arrow = new Weapon("ARROW",2,5,"RANGE");
		
		rags = new Armor("RAGS", 1, 1);
		mc = new Hero(IronSword,rags,1,1,1,1,1);
		
		//kunai
		//dual blade
		//posion arrow
		//flame arrow
		//katana
	}
	
	public void dropRates() {
		weaponDropList.add(IronSword);
		weaponDropList.add(knife);
		weaponDropList.add(club);
		weaponDropList.add(rod);
		weaponDropList.add(lance);

		
	}
	

}
