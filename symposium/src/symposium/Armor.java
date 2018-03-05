package symposium;

public class Armor {

	
	private String name;
	public int defensestats;
	public int armorweight;
	
	
	
	public Armor(String name, int armorweight, int defensestats) {
		this.name = name;
		
		this.armorweight = armorweight;
		this.defensestats = defensestats;
		
	}
	
	public int getdefense()
	{
		return defensestats;
	}
	
	public int getweight()
	{
		return armorweight;
	}

	public String getArmorName()
	{
		return name;
	}
	
	
}
