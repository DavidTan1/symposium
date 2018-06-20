package symposium;

public class Mobs {

	private String img;
	private String name;
	private int str;
	private int agl;
	private int vit;
	private int luk;
	private int level;
	private int positionx;
	private int positiony;
	public int currHealth;
	public int maxHealth;
	private boolean isAttack;

	public Mobs(String img, String name, int str, int agl, int vit, int luk, int positionx, int positiony) {
		this.img = img;
		this.name = name;
		this.str = str;
		this.agl = agl;
		this.vit = vit;
		this.luk = luk;
		this.positionx = positionx;
		this.positiony = positiony;

		isAttack = false;
		maxHealth = getVit();
		currHealth = maxHealth;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int multiplier() {

		if (name().equals("Demon"))
			return 2;

		if (name().equals("Wild Beast"))
			return 3;

		if (name().equals("Vampire"))
			return 4;

		if (name().equals("Black Dragon"))
			return 5;

		return 1;
	}

	public int getLevel() {
		level = MinuteQuestButBetter.round()+1;
		return level;
	}

	public String name() {
		return name;
	}

	public boolean isattack() {
		isAttack = true;
		return isAttack;
	}

	public int currHealth() {
		if (maxHealth == currHealth) {
			currHealth = maxHealth - MinuteQuestButBetter.mc.getStr();
			System.out.println(currHealth);

			return currHealth;

		} else {

			currHealth = currHealth - MinuteQuestButBetter.mc.getStr();
			return currHealth;
		}

	}

	public int currHealthBlast() {
		if (maxHealth == currHealth) {
			currHealth = maxHealth - MinuteQuestButBetter.mc.getStr()*10;
			System.out.println(currHealth);

			return currHealth;

		} else {

			currHealth = currHealth - MinuteQuestButBetter.mc.getStr()*10;
			return currHealth;
		}

	}
	
	
	public boolean dead() {
		if (currHealth <= 0) {

			return true;
		}
		return false;
	}

	public int getHealth() {

		return 1;
	}

	public int getPositiony() {
		return positiony;
	}

	public int getPositionx() {
		return positionx;
	}

	public int getStr() {
		return str * getLevel() * multiplier();
	}

	public int getAgl() {
		return agl * getLevel() * multiplier();
	}

	public int getVit() {
		return vit * getLevel() * multiplier();
	}

	public int getLuk() {
		return luk;
	}

	public String img() {
		return img;
	}

	public int getMaxH() {
		System.out.println("dragon maxHealth: " + maxHealth);
		return maxHealth;
	}

	public int getcurrHealth() {
		System.out.println("dragon currHealth: " + currHealth);
		return currHealth;
	}

}
