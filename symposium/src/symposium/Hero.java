package symposium;

public class Hero {
	
	private Weapon weapon;
	private Armor armor;
	private int str;
	private int agl;
	private int vit;
	private int luk;
	private int level;

	public Hero(Weapon weapon, Armor armor, int str, int agl, int vit, int luk, int level) {

		this.weapon = weapon;
		this.armor = armor;
		this.str = str;
		this.agl = agl;
		this.vit = vit;
		this.luk = luk;
		this.level = level;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getStr() {
		
		return str;
	}

	public int setStr() {
		
		System.out.println(getWeapon());
		int trueSTR = str*getWeapon().getattackstats();
		return trueSTR;
	}

	public int getAgl() {
		return agl;
	}

	public void setAgl(int agl) {
		this.agl = agl;
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getLuk() {
		return luk;
	}

	public void setLuk(int luk) {
		this.luk = luk;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
}
