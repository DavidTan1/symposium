package symposium;

import java.util.ArrayList;

public class Hero {

	private Weapon weapon;
	private Armor armor;
	private ArrayList<Integer> asdf;
	private int str;
	private int agl;
	private int vit;
	private int luk;
	private int level;
	private int gold;
	private int maxHealth;
	public int currHealth;
	private int exp;
	private int maxEnergy;
	public int currEnergy;

	public int points;

	public Hero(Weapon weapon, Armor armor, int str, int agl, int vit, int luk, int level, int gold) {

		this.weapon = weapon;
		this.armor = armor;
		this.str = str;
		this.agl = agl;
		this.vit = vit;
		this.luk = luk;
		this.level = level;
		this.gold = gold;

		maxHealth = getHealth();
		currHealth = maxHealth;

		maxEnergy = getEnergy();
		currEnergy = maxEnergy;

		asdf = new ArrayList<Integer>();

		int x = 10;

		for (int i = 1; i < 20; i++) {
			asdf.add(x);
			x = x * 2;
			System.out.println("Level " + i + " " + asdf.get(i - 1));
		}

	}

	public static void main(String[] args) {

	}

	public int increaseGold(int amount) {
		return gold = gold + amount;
	}

	public int subGold(int amount) {
		return gold = gold - amount;

	}

	public int getGold() {
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

	public int instr() {
		return str++;
	}

	public int inagl() {
		return agl++;
	}

	public int invit() {
		return vit++;
	}

	public int inluk() {
		return luk++;
	}

	public int setStr() {

		System.out.println(getWeapon());
		int trueSTR = str * getWeapon().getattackstats();
		return trueSTR;
	}

	public int getAgl() {
		return agl;
	}

	public int setAgl() {
		int trueAGL = (int) (agl - (getArmor().getweight() * .75));
		return trueAGL;
	}

	public int getVit() {
		return vit;
	}

	public int getHealth() {
		return getVit() * 100;
	}

	public int getEnergy() {
		return getLuk() * 100;
	}

	public int currEnergy() {
		if (maxEnergy == currEnergy) {
			currEnergy = maxEnergy - 100;
			System.out.println(currEnergy);
			return currEnergy;

		} else {

			currEnergy = currEnergy - 100;
			System.out.println(currEnergy);
			return currEnergy;
		}

	}

	public boolean dead() {
		if (currHealth <= 0) {
			return true;
		}
		return false;
	}

	public int currHealth(Mobs a) {

		if (maxHealth == currHealth) {
			currHealth = maxHealth - MinuteQuestButBetter.battle.mobs(a);

			return currHealth;

		} else {

			currHealth = currHealth - MinuteQuestButBetter.battle.mobs(a);
			return currHealth;
		}

	}

	public int setVit() {
		int trueVIT = vit * (getArmor().getdefense() / 10);
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

	public int inlevel() {
		return level++;
	}

	public int dispoint() {
		return points;
	}

	public int points() {
		return points += 3;

	}

	public int decreasepoints() {
		return points--;
	}

	public void levelup() {
		if (exp > asdf.get(level - 1)) {
			System.out.println("You leveled up!");
			inlevel();
			points();
		}

	}

	public int exp(int x) {
		exp += x;
		return x;
	}

	public void addWeapon(Weapon asdf) {
		weapon = asdf;
	}

	public void addArmor(Armor asdf) {
		armor = asdf;
	}

	public int energy() {
		return currEnergy;
	}

	public int refill() {
		return currEnergy = getEnergy();
	}
}
