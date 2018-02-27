package symposium;

public class Hero {

	private String armorEquip;
	private String weaponEquip;
	private int str;
	private int agl;
	private int vit;
	private int luk;
	private int level;

	public Hero(String armor, String weapon, int str, int agl, int vit, int luk, int level) {

		this.armorEquip = armorEquip;
		this.weaponEquip = weaponEquip;
		this.str = str;
		this.agl = agl;
		this.vit = vit;
		this.luk = luk;
		this.level = level;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int level()
	{
		return level;
	}
	
	public int strength() {
		return str;
		
	}

	public int speed() {
		return agl;
	}

	public int health() {
		return vit;
	}

	public int luck() {
		return luk;
		// luk*.001;
	}

	public String weaponE() {
		return weaponEquip;
	}

	public String armorEquip() {
		return armorEquip;
	}

	public void setStrength(int strength) {
		//this.str = str* (weaponatk/10 + 1);;
	}

	public void setSpeed(int speed) {
		//this.agl = agl- (weight of wpn*.5 + amr*.25);
	}

	public void setAttack(int attack) {
		//this.attack = attack;
	}

	public void setDefense(int defense) {
		//this.vit = vit* (Amr/10 + 1);
	}

	public void setHp(int hp) {
		this.vit = vit * 50;
	}

	public void setLevel(int level) {
		this.level += level;
	}

	public int getLevel() {
		return this.level;
	}



}
