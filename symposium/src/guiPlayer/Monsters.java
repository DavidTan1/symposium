package guiPlayer;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Monsters extends Component {
	
	private String name;
	private int baseHP;
	private int jumpRes;
	private int koRes;
	private int mountRes;
	private int fireRes;
	private int iceRes;
	private int waterRes;
	private int thunderRes;
	private int dragonRes;
	private int poisonRes;
	private int sleepRes;
	private int blastRes;
	private String type;
	private double size;

	public Monsters(String name, int baseHP,int fireRes, int iceRes, int waterRes, int thunderRes, int dragonRes, int poisonRes, int sleepRes, int blastRes, int jumpRes, int koRes, int mountRes, String type, double size) {
		super(40, 40, 962, 10);
		this.name = name;
		this.baseHP = baseHP;
		this.fireRes = fireRes;
		this.iceRes = iceRes;
		this.waterRes = waterRes;
		this.thunderRes = thunderRes;
		this.dragonRes = dragonRes;
		this.poisonRes = poisonRes;
		this.blastRes = blastRes;
		this.jumpRes = jumpRes;
		this.koRes = koRes;
		this.mountRes = mountRes;
		this.type = type;
		this.size = size;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		//super.update(g);
	}

	public String toString() {
		return name + "," + baseHP + "," + fireRes + "," + iceRes + "," + waterRes + "," + thunderRes + "," + dragonRes + "," +
				poisonRes + "," + sleepRes + "," + blastRes + "," + jumpRes + "," + koRes + "," + mountRes + "," + type + "," + size;
	}
}
