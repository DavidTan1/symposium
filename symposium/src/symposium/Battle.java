package symposium;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Battle extends FullFunctionScreen {

	public ArrayList<Mobs> mobs;
	public ArrayList<Hero> hero;

	public int currHP;
	public int count;
	public int currPosition;

	private AnimatedComponent dragon;
	public BlastSprite blast;
	private Sprite walklr;
	private SpriteAttack punchlr;

	private TextArea stats;
	private TextArea welcomeText;
	private TextArea asd;
	private TextArea one;
	private TextArea health;
	private Money money;

	private Button items;

	public boolean attackrn;
	public boolean rightw;
	public boolean leftw;
	public int c;

	private boolean gameover;
	private boolean textD;
	private Graphic mob2;
	private Graphic mob1;
	private Graphic mob3;
	private Graphic mob4;
	
	private int y;
	private TextArea energy;

	public Battle(int width, int height, int round) {
		super(width, height);

		// TODO Auto-generated constructor stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		setBackground(Color.BLACK);

		welcomeText = new TextArea(5, 800, 800, 100,
				"Kill all the mobs to advance to the next level." + "PRO TIP: Pressed 'A' to attack.");

		viewObjects.add(welcomeText);

		welcomeText.setTextColor(Color.WHITE);

		stats = new TextArea(1075, 800, 200, 500, "");

		viewObjects.add(stats);

		asd = new TextArea(5, 800, 800, 100, "");
		viewObjects.add(asd);

		createMobs();

		count = 1;
		c = 10;
		currPosition = 10;
		gameover = false;
		attackrn = false;

		Graphic background = new Graphic(0, 0, 1364, 746, "symposium/battlebackground.png");

		viewObjects.add(background);

		// dragon = new AnimatedComponent(mobs.get(0).getPositionx(), 603, 74, 82);
		// viewObjects.add(dragon);
		//
		// dragon.addSequence("symposium/blackdragonstand.png", 200, 0, 0, 73, 81, 5);
		// Thread mobbdragon = new Thread(dragon);
		// mobbdragon.start();

		items = new Button(1000, 800, 60, 60, "Items", new Action() {

			@Override
			public void act() {
				welcomeText.setText("You don't have any items yet.");

			}

		});

		viewObjects.add(items);
		items.setBackground(Color.WHITE);
		items.update();

		
		walklr = new Sprite(currPosition, 603, 61, 76);
		viewObjects.add(walklr);

		walklr.num = 4;
		
		walklr.addSequence("symposium/walkl&r.png", 200, 0, 0, 60, 75, 16);
		Thread walkrl = new Thread(walklr);
		walkrl.start();

		punchlr = new SpriteAttack(walklr.getX(), walklr.getY(), 75, 83);
		viewObjects.add(punchlr);
		punchlr.setVisible(false);

		punchlr.addSequence("symposium/punchlr.png", 200, 0, 0, 74, 82, 6);
		Thread punchrl = new Thread(punchlr);
		punchrl.start();

		punchlr.punchg = 3;

		blast = new BlastSprite(walklr.getX() + 44, 573, 178, 135);
		viewObjects.add(blast);

		blast.addSequence("symposium/blastc.png", 200, 0, 0, 178, 135, 2);
		Thread ki = new Thread(blast);
		ki.start();

		blast.setVisible(false);

		viewObjects.add(mob1);
		viewObjects.add(mob2);
		viewObjects.add(mob3);
		viewObjects.add(mob4);

		health = new TextArea(walklr.getX(), walklr.getY() - 50, 500, 50,
				"Health: " + MinuteQuestButBetter.mc.currHealth + "/" + MinuteQuestButBetter.mc.getHealth());

		viewObjects.add(health);

		energy = new TextArea(walklr.getX(), walklr.getY() - 100, 500, 50,
				"Energy: " + MinuteQuestButBetter.mc.energy() + "/" + MinuteQuestButBetter.mc.getEnergy());

		viewObjects.add(energy);
		updateW();

		Font fontsize12 = new Font("serif", Font.PLAIN, 12);

		energy.setFont(fontsize12);
		health.setFont(fontsize12);

	}

	public void updateW() {
		if (MinuteQuestButBetter.mc.getWeapon().name().equals("FIST")) {
			walklr.setVisible(false);

			walklr = new Sprite(currPosition, 603, 64, 83);
			getViewObjects().add(walklr);

			walklr.num = 4;
			
			walklr.addSequence("symposium/walkglove.png", 200, 0, 0, 63, 82, 8);
			Thread walkrl = new Thread(walklr);
			walkrl.start();

			punchlr.setVisible(false);

			punchlr = new SpriteAttack(walklr.getX(), 590, 87, 79);
			getViewObjects().add(punchlr);
			punchlr.setVisible(false);

			punchlr.addSequence("symposium/punchglove.png", 200, 0, 0, 86, 78, 4);
			Thread punchrl = new Thread(punchlr);
			punchrl.start();

			punchlr.punchg = 2;

			// punchglove

		} else if (MinuteQuestButBetter.mc.getWeapon().name().equals("SWORD")) {

			walklr.setVisible(false);

			walklr = new Sprite(currPosition, 603, 71, 85);
			getViewObjects().add(walklr);

			walklr.num = 4;
			
			walklr.addSequence("symposium/walkinggsword.png", 200, 0, 0, 70, 84, 8);
			Thread walkrl = new Thread(walklr);
			walkrl.start();

			punchlr.setVisible(false);

			punchlr = new SpriteAttack(walklr.getX(), walklr.getY(), 107, 79);
			getViewObjects().add(punchlr);
			punchlr.setVisible(false);

			punchlr.addSequence("symposium/swordswing.png", 200, 0, 0, 106, 79, 4);
			Thread punchrl = new Thread(punchlr);
			punchrl.start();

			punchlr.punchg = 2;

		} else if (MinuteQuestButBetter.mc.getWeapon().name().equals("AXE")) {
			
			walklr.setVisible(false);

			walklr = new Sprite(currPosition, 603, 70, 82);
			getViewObjects().add(walklr);

			
			walklr.num = 2;
			
			walklr.addSequence("symposium/walkaxe.png", 200, 0, 0, 69, 81, 4);
			Thread walkrl = new Thread(walklr);
			walkrl.start();

			punchlr.setVisible(false);

			punchlr = new SpriteAttack(walklr.getX(), 590, 82, 82);
			getViewObjects().add(punchlr);
			punchlr.setVisible(false);

			punchlr.addSequence("symposium/punchaxe.png", 200, 0, 0, 81, 81, 4);
			Thread punchrl = new Thread(punchlr);
			punchrl.start();

			punchlr.punchg = 2;

		} else if (MinuteQuestButBetter.mc.getWeapon().name().equals("ROD")) {
			walklr.setVisible(false);

			walklr = new Sprite(currPosition, 603, 136, 81);
			getViewObjects().add(walklr);

			walklr.num = 2;

			
			walklr.addSequence("symposium/walkrod.png", 200, 0, 0, 135, 80, 4);
			Thread walkrl = new Thread(walklr);
			walkrl.start();

			punchlr.setVisible(false);

			punchlr = new SpriteAttack(walklr.getX(), 590, 143, 81);
			getViewObjects().add(punchlr);
			punchlr.setVisible(false);

			punchlr.addSequence("symposium/punchrod.png", 200, 0, 0, 142, 80, 4);
			Thread punchrl = new Thread(punchlr);
			punchrl.start();

			punchlr.punchg = 2;

		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			walklr.setVx(0);

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			walklr.setVx(0);

		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			if (textD == false) {

				stats.setText("Your character has " + MinuteQuestButBetter.mc.getWeapon().name() + " equipped."
						+ " Your character Attack: " + MinuteQuestButBetter.mc.getStr() + "->"
						+ MinuteQuestButBetter.mc.setStr() + " Your character has "
						+ MinuteQuestButBetter.mc.getArmor().name() + " equipped." + " Your character Defense: "
						+ MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit()
						+ " Your character Speed: " + MinuteQuestButBetter.mc.getAgl() + " -> "
						+ MinuteQuestButBetter.mc.setAgl());

				textD = true;
			} else {
				stats.setText("");
				textD = false;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_B) {
			blast.move(walklr.getX(), 573, 1);

		}

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT && gameover == false && !c()) {

			if (walklr.getX() > 1300) {

				MinuteQuestButBetter.mc.exp(100);
				MinuteQuestButBetter.mc.levelup();
				MinuteQuestButBetter.increaseround();

				MinuteQuestButBetter.mc.refill();

				MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.shop);
			}

			if (mobs.size() == 4) {

				mobAttack(walklr.getX(), mobs.get(0), mob1);
				mobAttack(walklr.getX(), mobs.get(1), mob2);
				mobAttack(walklr.getX(), mobs.get(2), mob3);
				mobAttack(walklr.getX(), mobs.get(3), mob4);

			}

			if (mobs.size() == 3) {

				mobAttack(walklr.getX(), mobs.get(0), mob2);
				mobAttack(walklr.getX(), mobs.get(1), mob3);
				mobAttack(walklr.getX(), mobs.get(2), mob4);

			}

			if (mobs.size() == 2) {

				mobAttack(walklr.getX(), mobs.get(0), mob3);
				mobAttack(walklr.getX(), mobs.get(1), mob4);

			}

			if (mobs.size() == 1) {

				mobAttack(walklr.getX(), mobs.get(0), mob4);

			}

			if (attackrn == false) {

				blast.move(walklr.getX(), 573, 1);
				health.move(walklr.getX(), walklr.getY() - 50, 1);
				energy.move(walklr.getX(), walklr.getY() - 100, 1);
				
				walklr.left = true;

				walklr.setVx(3.0); // parameter should be agl/weight

				rightw = true;
				leftw = false;

			}

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && gameover == false) {

			if (attackrn == false && walklr.getX() > 1) {

				blast.move(walklr.getX() + 44, 573, 1);
				health.move(walklr.getX(), walklr.getY() - 50, 1);
				energy.move(walklr.getX(), walklr.getY() - 100, 1);

				for (int i = 0; i < 1; i++) {

					walklr.left = false;

					walklr.setVx(-3.0);

					leftw = true;
					rightw = false;

				}
			}

			if (walklr.getX() < 1) {

				// MinuteQuestButBetter.increaseround();
				walklr.setVx(0);
				MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.shop);
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A && gameover == false) {

			walklr.setVisible(false);
			attackrn = true;

			if (attackrn == true && leftw == true) {

				punchlr.striker = false;

				punchlr.setVisible(true);
				punchlr.move(walklr.getX(), walklr.getY() - 5, 1);

				new Thread() {

					public void run() {

						try {
							Thread.sleep(2000);
						} catch (InterruptedException a) {
							// TODO Auto-generated catch block
							a.printStackTrace();
						}

						punchlr.setVisible(false);

						walklr.setVisible(true);
						attackrn = false;

					}
				}.start();

				if (mobs.size() == 4) {

					kill(walklr.getX(), mobs.get(0), mob1);
					kill(walklr.getX(), mobs.get(1), mob2);
					kill(walklr.getX(), mobs.get(2), mob3);
					kill(walklr.getX(), mobs.get(3), mob4);

				}

				if (mobs.size() == 3) {

					kill(walklr.getX(), mobs.get(0), mob2);
					kill(walklr.getX(), mobs.get(1), mob3);
					kill(walklr.getX(), mobs.get(2), mob4);

				}

				if (mobs.size() == 2) {

					kill(walklr.getX(), mobs.get(0), mob3);
					kill(walklr.getX(), mobs.get(1), mob4); //

				}

				if (mobs.size() == 1) {

					kill(walklr.getX(), mobs.get(0), mob4); //

				}

			} else {
				attackrn = true;

				punchlr.striker = true;

				punchlr.setVisible(true);
				punchlr.move(walklr.getX(), walklr.getY() - 5, 1);

				new Thread() {

					public void run() {

						try {
							Thread.sleep(2000);
						} catch (InterruptedException a) {
							// TODO Auto-generated catch block
							a.printStackTrace();
						}

						punchlr.setVisible(false);

						walklr.setVisible(true);
						attackrn = false;

					}
				}.start();

				if (mobs.size() == 4) {

					kill(walklr.getX(), mobs.get(0), mob1);

				}

				if (mobs.size() == 3) {

					kill(walklr.getX(), mobs.get(0), mob2);

				}

				if (mobs.size() == 2) {

					kill(walklr.getX(), mobs.get(0), mob3);

				}

				if (mobs.size() == 1) {

					kill(walklr.getX(), mobs.get(0), mob4);

				}

			}

		} else if (e.getKeyCode() == KeyEvent.VK_B && gameover == false && MinuteQuestButBetter.mc.energy() > 0) {

			attackrn = true;

			blast.fired = true;

			blast.setVisible(true);

			blast.setVx(3.0);

			energy.setText(
					"Energy: " + MinuteQuestButBetter.mc.currEnergy() + "/" + MinuteQuestButBetter.mc.getEnergy());

			welcomeText.setText("You used a energy blast.");

			new Thread() {

				public void run() {

					try {
						Thread.sleep((long) (blast.getVx() * 150));

					} catch (InterruptedException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}

					if (mobs.size() == 4) {

						contact(blast.getX() + 50, mob1, mobs.get(0));

					}

					if (mobs.size() == 3) {

						contact(blast.getX() + 50, mob2, mobs.get(0));
						contact(blast.getX() + 50, mob3, mobs.get(1));

					}

					if (mobs.size() == 2) {

						contact(blast.getX() + 50, mob3, mobs.get(0));

					}

					if (mobs.size() == 1) {

						contact(blast.getX() + 50, mob4, mobs.get(0));
					}

					blast.fired = true;
					blast.setVisible(false);
					blast.setVx(0);

					update();
					attackrn = false;

				}
			}.start();

		} else if (e.getKeyCode() == KeyEvent.VK_X && gameover == false) {

			if (money.getX() - 20 <= walklr.getX() && walklr.getX() <= money.getX() + 20) {

				System.out.println(money.getX());
				System.out.println(walklr.getX());

				MinuteQuestButBetter.mc.increaseGold(money.moneyAmount());

				getViewObjects().remove(money);
				System.out.println(MinuteQuestButBetter.mc.getGold());

			}

			// money

		}

		repaint();

	}

	public void removeMob(Mobs a, Graphic pic) {

		if (pic.getImage().toString().contains("slime")) {
			getViewObjects().remove(pic);
			mobs.remove(0);
			a.currHealth = a.maxHealth;

			update();
		}
		if (pic.getImage().toString().contains("demon")) {
			getViewObjects().remove(pic);
			mobs.remove(0);
			a.currHealth = a.maxHealth;

			update();
		}
		if (pic.getImage().toString().contains("beast")) {
			getViewObjects().remove(pic);
			mobs.remove(0);
			a.currHealth = a.maxHealth;

			update();
		}
		if (pic.getImage().toString().contains("mage")) {
			getViewObjects().remove(pic);
			mobs.remove(0);
			a.currHealth = a.maxHealth;

			update();
		}
		if (pic.getImage().toString().contains("dragon")) {
			getViewObjects().remove(pic);
			mobs.remove(0);
			a.currHealth = a.maxHealth;

			update();
		}

	}

	public boolean checkMob(int position, Graphic pic, Mobs mob) {

		int count = 0;

		if (mob.dead() == false) {

			if (position < pic.getX()) {
				for (int i = position + walklr.getWidth(); i <= pic.getX(); i++) {
					count++;

				}

				System.out.println("Range is " + count);

				if (count <= 60) {

					return true;
				}

			} else {

				walklr.setVx(0);
			}

		}

		return false;

	}

	public void createMobs() {
		mobs = new ArrayList<Mobs>();

		if (MinuteQuestButBetter.round() == 0) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.slime);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());

			// System.out.print("Mobs are level: " + mobs.get(1).getLevel() + " Attack stats
			// is: " + mobs.get(1).getStr());

		}

		if (MinuteQuestButBetter.round() == 1) {

			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.demon);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());

			// System.out.print("Mobs are level: " + mobs.get(1).getLevel() + " Attack stats
			// is: " + mobs.get(1).getStr());

		}

		if (MinuteQuestButBetter.round() == 2) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}

		if (MinuteQuestButBetter.round() == 3) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.slime);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}

		if (MinuteQuestButBetter.round() == 4) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());

		}

		if (MinuteQuestButBetter.round() == 5) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.beast);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}
		if (MinuteQuestButBetter.round() == 6) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}
		if (MinuteQuestButBetter.round() == 7) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.demon);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}
		if (MinuteQuestButBetter.round() == 7) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}

		if (MinuteQuestButBetter.round() == 7) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.vampire);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}

		if (MinuteQuestButBetter.round() == 8) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.vampire);
			mobs.add(MinuteQuestButBetter.vampire);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}
		if (MinuteQuestButBetter.round() == 9) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.beast);
			mobs.add(MinuteQuestButBetter.vampire);
			mobs.add(MinuteQuestButBetter.vampire);
			mobs.add(MinuteQuestButBetter.vampire);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}

		if (MinuteQuestButBetter.round() == 10) {
			// mobs.add(MinuteQuestButBetter.bdragon);
			mobs.add(MinuteQuestButBetter.vampire);
			mobs.add(MinuteQuestButBetter.vampire);
			mobs.add(MinuteQuestButBetter.vampire);
			mobs.add(MinuteQuestButBetter.vampire);

			mob1 = new Graphic(MinuteQuestButBetter.slime.getPositionx(), 603, 93, 70, mobs.get(0).img());
			mob2 = new Graphic(MinuteQuestButBetter.demon.getPositionx(), 603, 93, 70, mobs.get(1).img());
			mob3 = new Graphic(MinuteQuestButBetter.beast.getPositionx(), 603, 93, 70, mobs.get(2).img());
			mob4 = new Graphic(MinuteQuestButBetter.vampire.getPositionx(), 603, 93, 70, mobs.get(3).img());
		}

		if (MinuteQuestButBetter.round() == 11) {

			mobs.add(MinuteQuestButBetter.bdragon);

			welcomeText.setText("Final Boss");
			mob4 = new Graphic(MinuteQuestButBetter.bdragon.getPositionx(), 603, 93, 70, mobs.get(0).img());
		}

	}

	public boolean c() {

		if (mobs.size() == 4) {
			if (checkcollision(walklr.getX(), mob1, mobs.get(0)) == false
			// && checkcollision(walklr.getX(), mob2, mobs.get(1)) == false
			// && checkcollision(walklr.getX(), mob3, mobs.get(2)) == false
			// && checkcollision(walklr.getX(), mob4, mobs.get(3)) == false
			) {
				return false;
			}
		}

		if (mobs.size() == 3) {
			if (checkcollision(walklr.getX(), mob2, mobs.get(0)) == false
			// && checkcollision(walklr.getX(), mob3, mobs.get(1)) == false
			// && checkcollision(walklr.getX(), mob4, mobs.get(2)) == false
			) {
				return false;

			}
		}

		if (mobs.size() == 2) {
			if (checkcollision(walklr.getX(), mob3, mobs.get(0)) == false
			// && checkcollision(walklr.getX(), mob4, mobs.get(1)) == false
			) {
				return false;

			}
		}

		if (mobs.size() == 1) {
			if (checkcollision(walklr.getX(), mob4, mobs.get(0)) == false) {
				return false;

			}
		}

		if (mobs.size() == 0) {
			return false;
		}

		return true;

	}

	public boolean checkcollision(int x, Graphic pic, Mobs mob) {

		
		
		if ((0 > ((pic.getX()) - walklr.getWidth()) - x) && !mob.dead()) {
			walklr.setVx(0);
			return true;
		}

		return false;
	}

	public int mobs(Mobs a) {
		return a.getStr();
	}

	public void mobAttack(int position, Mobs mob, Graphic pic) {

		if (checkcollision(position, pic, mob) == true && MinuteQuestButBetter.mc.currHealth(mob) > 0) {

			if (dodge(MinuteQuestButBetter.mc.setAgl(), mob.getAgl())) {

				System.out.println("asdhaksfhaksfhas");

				health.setText("Health: " + MinuteQuestButBetter.mc.currHealth(mob) + "/"
						+ MinuteQuestButBetter.mc.getHealth());

				health.setTextColor(Color.WHITE);

				getViewObjects().add(health);

			}

		} else {
			if (MinuteQuestButBetter.mc.dead() == true) {
				welcomeText.setText("You have been slain.");
				gameover = true;
				getViewObjects().remove(health);

			}
		}

	}

	public boolean dodge(int userspeed, int mobspeed) {
		if (userspeed > mobspeed) {
			int rate = (int) (Math.random() * 100) + 1;

			if (rate > 90) {
				return false;// dodge attack
			}

			return true;// fail to dodge attack
		}

		return true;
	}

	public void kill(int xcoord, Mobs mob, Graphic pic) {
		if (checkcollision(xcoord, pic, mob) == true) {

			if (speedOrder(MinuteQuestButBetter.mc.setAgl(), mob.getAgl())) {

				if (y == 1) {
					getViewObjects().remove(one);
					y = 0;

				}

				y = 1;

				one = new TextArea(pic.getX(), 553, 93, 70, mob.name() + ":" + mob.currHealth() + "/" + mob.getVit());

				getViewObjects().add(one);

				blast.setVisible(false);

				System.out.println("check");

			}

			mobAttack(xcoord, mob, pic);

			if (mob.dead() == true) {

				getViewObjects().remove(one);

				welcomeText.setText("You kill the " + mob.name());

				removeMob(mob, pic);

				System.out.println("Mob size is currently " + mobs.size());

				money = new Money(pic.getX(), 650, 25, 25, "X", mob.multiplier());
				getViewObjects().add(money);

				update();

			}

		} else {
			welcomeText.setText("You swung, but your attack missed.");
		}
	}

	public void contact(int xcoord, Graphic pic, Mobs mob) {
		if (xcoord > pic.getX() && speedOrder(MinuteQuestButBetter.mc.setAgl(), mob.getAgl())) {
			// if (y == 1) {
			// getViewObjects().remove(one);
			// y = 0;
			//
			// }
			//
			// y = 1;
			one = new TextArea(pic.getX(), 553, 93, 70, mob.name() + ":" + mob.currHealthBlast() + "/" + mob.getVit());
			getViewObjects().add(one);

			System.out.println(mob.name() + " just got hit");
			if (mob.dead() == true) {

				getViewObjects().remove(one);

				welcomeText.setText("You kill the " + mob.name());

				removeMob(mob, pic);

				money = new Money(pic.getX(), 650, 25, 25, "O", mob.multiplier());
				getViewObjects().add(money);
				

				update();

			}
		}
	}

	public boolean speedOrder(int userspeed, int mobspeed) {
		if (mobspeed > userspeed) {
			int rate = (int) (Math.random() * 100) + 1;

			if (rate > 1) {
				System.out.println("DODGE!!!");
				return false;// dodge attack
			}

			return true;// fail to dodge attack
		}

		return true;
	}

}
