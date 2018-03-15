package symposium;

public class Hero {
	
	private Weapon weapon;
	private Armor armor;
	private int str;
	private int agl;
	private int vit;
	private int luk;
	private int level;
	private int gold;
	
	public Hero(Weapon weapon, Armor armor, int str, int agl, int vit, int luk, int level, int gold) {

		this.weapon = weapon;
		this.armor = armor;
		this.str = str;
		this.agl = agl;
		this.vit = vit;
		this.luk = luk;
		this.level = level;
		this.gold = gold;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getGold()
	{
		return gold;
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

	public int setAgl() {
		System.out.println(getArmor());
		int trueAGL = (int) (agl-(getArmor().getweight()*.75));
		return trueAGL;	}

	public int getVit() {
		return vit;
	}

	public int setVit() {
		System.out.println(getArmor());
		int trueVIT = vit*(getArmor().getdefense()/10);
		return trueVIT;
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
