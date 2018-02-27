package symposium;

public class Weapon {

	
	private String type;
	public int atkstats;
	public int weaponweight;
	
	public Weapon(int atkstats, int weaponweight, String type) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String weaponType()
	{
		return type;
	}
	
	public int attack()
	{
		return atkstats;
	}
	
	public int weight()
	{
		return weaponweight;
	}

}
