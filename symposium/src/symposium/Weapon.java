package symposium;

public class Weapon {

	private String name;
	private String type;
	private String img;
	public int atkstats;
	public int weaponweight;
	public int cost;

	public Weapon(String img, String name, int atkstats, int weaponweight, String type, int cost) {
		this.img = img;
		this.name = name;
		this.atkstats = atkstats;
		this.weaponweight = weaponweight;
		this.type = type;
		this.cost = cost;
	}

	public String weaponType() {
		return type;
	}

	public int getCost() {
		return cost;
	}

	public int getattackstats() {
		return atkstats;
	}

	public int weight() {
		return weaponweight;
	}

	public String name() {
		return name;
	}

	public String img() {
		return img;
	}

}
