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
	
	public Mobs(String img, int str, int agl, int vit, int luk, int level, int positionx, int positiony) {
		this.img = img;
		this.str = str;
		this.agl = agl;
		this.vit = vit;
		this.luk = luk;
		this.level = level;
		this.positionx = positionx;
		this.positiony = positiony;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int currHealth()
	{
		return currHealth = vit-MinuteQuestButBetter.mc.getStr();
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

	public String img()
	{
		return img;
	}

		


}
