package symposium;

public class Hero {
	
	
	private String armorEquip;
	private String weaponEquip;
	private int str;
	private int agl;
	private int vit;
	private int luk;

	public Hero(String armor, String weapon, int str, int agl, int vit, int luk) {
		
		this.armorEquip = "none";
		this.weaponEquip = "none";
		this.str = 1;
		this.agl = 1;
		this.vit = 1;		
		this.luk = 1;

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int strength()
	{
		return str;
		//str* (weaponatk/10 + 1);
	}
	
	public int speed()
	{
		return agl;
		//agl- (weight of wpn*.5 + amr*.25).
	}
	
	public int health()
	{
		return vit*50;
		
		//vit* (Amr/10 + 1);
	}
	
	public int luck()
	{
		return luk;
		//luk*.001;
	}
	
	public String weaponE()
	{
		return weaponEquip;
	}
	
	public String armorEquip()
	{
		return armorEquip;
	}

}
