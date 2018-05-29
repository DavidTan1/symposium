package symposium;

public class Armor {

	private String name;
	public int defensestats;
	public int armorweight;
	private String img;
	public int cost;

	public Armor(String name, int armorweight, int defensestats, int cost, String img) {
		this.name = name;
		this.cost = cost;
		this.armorweight = armorweight;
		this.defensestats = defensestats;
		this.img = img;
	}

	public int getdefense() {
		return defensestats;
	}

	public int getweight() {
		return armorweight;
	}


	public String img() {
		return img;
	}

	
	public int getCost() {
		return cost;
	}

	public String name() {
		return name;
	}
}
