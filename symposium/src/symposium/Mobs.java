package symposium;

public class Mobs {

	private String img;
	private int str;
	private int agl;
	private int vit;
	private int luk;
	private int level;
	private int positionx;
	private int positiony;
	private int currHealth;
	private int maxHealth;
	private boolean isAttack;

	public Mobs(String img, int str, int agl, int vit, int luk, int level, int positionx, int positiony) {
		this.img = img;
		this.str = str;
		this.agl = agl;
		this.vit = vit;
		this.luk = luk;
		this.level = level;
		this.positionx = positionx;
		this.positiony = positiony;

		isAttack = false;
		maxHealth = getVit();
		currHealth = maxHealth;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		return str;
	}

	public int getAgl() {
		return agl;
	}

	public int getVit() {
		return vit;
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
