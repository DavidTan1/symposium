package symposium;

public class Weapon {

	private String name;
	private String type;
	public int atkstats;
	public int weaponweight;
	
	public Weapon(String name, int atkstats, int weaponweight, String type) {
		this.name = name;
		this.atkstats = atkstats;
		this.weaponweight = weaponweight;
		this.type = type;
	}

	
	public String weaponType()
	{
		return type;
	}
	
	public int getattackstats()
	{
		return atkstats;
	}
	
	public int weight()
	{
		return weaponweight;
	}
	public String name()
	{
		return name;
	}
	

}
