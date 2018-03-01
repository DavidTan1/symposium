package symposium;

public class MainGame {

	public static Hero mc;
	public static Weapon knife;
	public static Weapon club;
	public static Weapon lance;
	public static Weapon rod;
	public static Weapon arrow;
	
	public static Armor rags;
	
	public MainGame() {
		
	}

	public static void main(String[] args) {
		
		creation();
		System.out.println("Your character has a "+mc.getWeapon().name()+" equipped.");
		
	}
	
	
	public static void creation()
	{

		knife = new Weapon("KNIFE", 5, 1, "STAB");
		club = new Weapon("CLUBS",2,5,"BASH");
		lance = new Weapon("LANCE",2,5,"JAB");
		rod = new Weapon("ROD",2,5,"MAGIC"); 
		arrow = new Weapon("ARROW",2,5,"RANGE");
		
		rags = new Armor("RAGS", 1, 1);
		mc = new Hero(knife,rags,1,1,1,1,1);
		
		
	}
	

}
