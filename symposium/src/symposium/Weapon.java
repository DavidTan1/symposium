package symposium;

public class Weapon {

	private String name;
	private String type;
	private String img;
	public int atkstats;
	public int weaponweight;
	
	public Weapon(String img, String name, int atkstats, int weaponweight, String type) {
		this.img = img;
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
	public String img()
	{
		return img;
	}
	
	

}
