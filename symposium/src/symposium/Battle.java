package symposium;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Battle extends FullFunctionScreen {

	public ArrayList<Mobs> mobs;
	public ArrayList<Integer> mobsX;
	public ArrayList<Hero> hero;

	public int currHP;
	public int count;
	public int currPosition;

	private AnimatedComponent dragon;
	private BlastSprite blast;

	private Sprite walklr;
	private Sprite swordlr;

	private SpriteAttack punchlr;
	private SpriteAttack swordslr;

	private TextArea stats;
	private TextArea welcomeText;
	private TextArea hpBar;
	private Button items;
	private TextArea asd;

	public boolean attackrn;
	public boolean rightw;
	public boolean leftw;
	public int healthMax;
	public int currHealth;
	public int c;

	private boolean gameover;
	private TextArea asdf;
	private boolean textD;
	private Graphic demon;
	private Graphic slime;
	private Graphic beast;
	private Graphic vampire;

	public Battle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		updateW();

		setBackground(Color.BLACK);

		welcomeText = new TextArea(5, 800, 800, 100,
				"Kill the dragon to reach the next town." + "PRO TIP: Pressed 'A' to attack.");

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
		healthMax = MinuteQuestButBetter.mc.getVit();
		// currHealth = healthMax;
		currHP = healthMax;
		gameover = false;

		attackrn = false;

		Graphic background = new Graphic(0, 0, 1364, 746, "symposium/battlebackground.png");

		viewObjects.add(background);

		asdf = new TextArea(100, 100, 1000, 1000, "______________________________");
		viewObjects.add(asdf);
		asdf.setTextColor(Color.green);
		asdf.update();

		hpBar = new TextArea(100, 100, 1000, 100, "______________________________");

		viewObjects.add(hpBar);

		hpBar.update();

		dragon = new AnimatedComponent(mobs.get(0).getPositionx(), 603, 74, 82);
		viewObjects.add(dragon);

		dragon.addSequence("symposium/blackdragonstand.png", 200, 0, 0, 73, 81, 5);
		Thread mobbdragon = new Thread(dragon);
		mobbdragon.start();

		items = new Button(1000, 800, 60, 60, "Skills/Items", new Action() {

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

		walklr.addSequence("symposium/walkl&r.png", 200, 0, 0, 60, 75, 16);
		Thread walkrl = new Thread(walklr);
		walkrl.start();

		swordlr = new Sprite(currPosition, 603, 71, 85);
		viewObjects.add(swordlr);
		swordlr.setVisible(false);

		swordlr.addSequence("symposium/walkinggsword.png", 200, 0, 0, 70, 84, 8);
		Thread swordrl = new Thread(swordlr);
		swordrl.start();

		punchlr = new SpriteAttack(walklr.getX(), 590, 51, 90);
		viewObjects.add(punchlr);
		punchlr.setVisible(false);

		punchlr.addSequence("symposium/punchlr.png", 200, 0, 0, 62, 90, 10);
		Thread punchrl = new Thread(punchlr);
		punchrl.start();

		/*
		 * swordslr = new SpriteAttack(swordlr.getX(), 590, 51, 90);
		 * viewObjects.add(swordslr); swordslr.setVisible(false);
		 * 
		 * swordslr.addSequence("symposium/swordswing.png", 200, 0, 0, 62, 90, 12);
		 * Thread swordsrl = new Thread(swordslr); swordsrl.start();
		 */

		blast = new BlastSprite(walklr.getX() + 44, 573, 178, 135);
		viewObjects.add(blast);

		blast.addSequence("symposium/blastc.png", 200, 0, 0, 178, 135, 2);
		Thread ki = new Thread(blast);
		ki.start();

		blast.setVisible(false);

		viewObjects.add(demon);
		viewObjects.add(slime);
		viewObjects.add(beast);
		viewObjects.add(vampire);
	}

	public void updateW() {
		if (MinuteQuestButBetter.mc.getWeapon().name().equals("FIST")) {
			swordlr.setVisible(false);
			walklr.setVisible(false);
		} else if (MinuteQuestButBetter.mc.getWeapon().name().equals("SWORD")) {
			swordlr.setVisible(true);
			walklr.setVisible(false);

		} else if (MinuteQuestButBetter.mc.getWeapon().name().equals("AXE")) {
			swordlr.setVisible(false);
			walklr.setVisible(false);

		} else if (MinuteQuestButBetter.mc.getWeapon().name().equals("ROD")) {
			swordlr.setVisible(false);
			walklr.setVisible(false);

		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			walklr.setVx(0);

			if (walklr.getX() > 1300) {
				MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.shop);
			}
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			walklr.setVx(0);

		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			if (textD == false) {

				stats.setText("Your character has " + MinuteQuestButBetter.mc.getWeapon().name() + " equipped."
						+ " Your character STR: " + MinuteQuestButBetter.mc.getStr() + "->"
						+ MinuteQuestButBetter.mc.setStr() + " Your character has "
						+ MinuteQuestButBetter.mc.getArmor().name() + " equipped." + " Your character VIT: "
						+ MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit()
						+ " Your character AGL: " + MinuteQuestButBetter.mc.getAgl() + " -> "
						+ MinuteQuestButBetter.mc.setAgl());

				textD = true;
			} else {
				stats.setText("");
				textD = false;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_B) {

			new Thread() {

				public void run() {

					System.out.println(blast.getX());

					kill(blast.getX() + dragon.getX(), MinuteQuestButBetter.bdragon);
					kill(blast.getX() + demon.getX(), MinuteQuestButBetter.demon);

					try {
						Thread.sleep((long) (blast.getVx() * 750));

					} catch (InterruptedException a) {
						// TODO Auto-generated catch block
						a.printStackTrace();
					}
					blast.fired = true;
					blast.setVisible(false);
					blast.setVx(0);

					kill(blast.getX(), MinuteQuestButBetter.bdragon);
					kill(blast.getX(), MinuteQuestButBetter.demon);

					blast.move(walklr.getX(), 573, 1);
					update();
					attackrn = false;

				}
			}.start();

		}

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT && gameover == false) {

			if (attackrn == false) {

				blast.move(walklr.getX(), 573, 1);

				for (int i = 0; i < 1; i++) {

					if (checkcollision(walklr.getX(), MinuteQuestButBetter.bdragon) == false) {

						walklr.left = true;
						System.out.println(walklr.getX());

						if (checkcollision(walklr.getX(), MinuteQuestButBetter.bdragon) == true) {
							walklr.setVx(0);

						} else {
							walklr.setVx(3.0); // parameter should be agl/weight

						}

						rightw = true;
						leftw = false;

					}
				}
			}

			mobAttack(walklr.getX(), MinuteQuestButBetter.bdragon);
			mobAttack(walklr.getX(), MinuteQuestButBetter.demon);

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && gameover == false) {

			if (attackrn == false && walklr.getX() > 1) {

				blast.move(walklr.getX() + 44, 573, 1);

				for (int i = 0; i < 1; i++) {

					walklr.left = false;

					walklr.setVx(-3.0);

					leftw = true;
					rightw = false;

				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A && gameover == false) {

			System.out.println("Dragon Multiplier is: " + MinuteQuestButBetter.bdragon.multiplier() + " ");
			System.out.println("Dragon Attack is: " + MinuteQuestButBetter.bdragon.getStr() + " ");

			System.out.println("Demon Multiplier is: " + MinuteQuestButBetter.demon.multiplier() + " ");
			System.out.println("Demon Attack is: " + MinuteQuestButBetter.demon.getStr() + " ");

			walklr.setVisible(false);
			attackrn = true;

			if (attackrn == true && leftw == true) {

				punchlr.striker = false;

				punchlr.setVisible(true);
				punchlr.move(walklr.getX(), 590, 1);

				// punchlr.addSequence("symposium/punchlr.png", 200, 0, 0, 50, 90, 10);
				// Thread strike = new Thread(punchlr);
				// strike.start();

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

				kill(walklr.getX(), mobs.get(0));

			} else {
				attackrn = true;

				punchlr.striker = true;

				punchlr.setVisible(true);
				punchlr.move(walklr.getX() - 20, 590, 1);

				// punchlr.addSequence("symposium/punchlr.png", 200, 0, 0, 50, 90, 10);
				// Thread strikingR = new Thread(punchlr);
				// strikingR.start();

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

				kill(walklr.getX(), mobs.get(0));

			}

		} else if (e.getKeyCode() == KeyEvent.VK_B && gameover == false) {

			attackrn = true;

			blast.fired = true;

			blast.setVisible(true);

			blast.setVx(3.0);

			welcomeText.setText("You used a energy blast.");

		}

		repaint();

	}

	public void kill(int xcoord, Mobs a) {
		if (checkMob(xcoord, a) == true) {
			a.currHealth();
			welcomeText.setText(a.name() + "health: " + a.currHealth() + "/" + a.getVit());
			blast.setVisible(false);

			System.out.println("check");
			mobAttack(xcoord, a);

			if (a.dead() == true) {
				welcomeText.setText("You kill the " + a.name());

				removeMob(a);
				mobs.remove(a);

				update();
				// make sure to remove dead mobs
			}

		} else {
			welcomeText.setText("You attack nothing. Try moving closer");
		}
	}

	private void removeMob(Mobs a) {

		int z = 0;

		for (int i = 0; i < mobs.size(); i++) {
			if (!(mobs.get(i) == a)) {
				z++;
			}
		}

		if (z == 0) {
			MinuteQuestButBetter.bdragon.dead();
			getViewObjects().remove(dragon);
		}
		if (z == 1) {
			MinuteQuestButBetter.demon.dead();

			getViewObjects().remove(demon);
		}

	}

	public void calcCollision(int x, int y) {

		mobsX = new ArrayList<Integer>();

		for (int i = 0; i < mobs.size(); i++) {
			// System.out.println(mobs.get(i).getPositionx());
			mobsX.add(mobs.get(i).getPositionx());
		}

	}

	public boolean checkMob(int position, Mobs a) {

		int count = 0;

		if (a.dead() == false) {

			if (position < a.getPositionx()) {
				for (int i = position; i <= a.getPositionx(); i++) {
					count++;
				}
			} else {

				for (int i = a.getPositionx(); i <= position; i--) {
					count++;
				}
			}
			if (count <= 102) {

				return true;
			}

		}

		System.out.println("Range is " + count);
		return false;

	}

	private void createMobs() {
		mobs = new ArrayList<Mobs>();

		mobs.add(MinuteQuestButBetter.bdragon);
		mobs.add(MinuteQuestButBetter.slime);
		mobs.add(MinuteQuestButBetter.beast);
		mobs.add(MinuteQuestButBetter.vampire);
		mobs.add(MinuteQuestButBetter.demon);

		// a = new Graphic(mobs.get(0).getPositionx(), 603, 74, 82, mobs.get(0).img());
		demon = new Graphic(mobs.get(4).getPositionx(), 603, 93, 70, mobs.get(4).img());
		slime = new Graphic(mobs.get(1).getPositionx(), 603, 93, 70, mobs.get(1).img());
		beast = new Graphic(mobs.get(2).getPositionx(), 603, 93, 70, mobs.get(2).img());
		vampire = new Graphic(mobs.get(3).getPositionx(), 603, 93, 70, mobs.get(3).img());

	}

	public int checkHealth() {

		if (healthMax == currHP) {
			currHP = healthMax - MinuteQuestButBetter.mc.getStr();
			System.out.println(currHP);

			return currHP;

		} else {

			currHP = currHP - MinuteQuestButBetter.mc.getStr();
			return currHP;
		}
	}

	public boolean checkcollision(int x, Mobs a) {

		if (0 > ((a.getPositionx()) - 74) - x) {
			return true;
		}

		return false;
	}

	public void mobAttack(int x, Mobs a) {
		while (checkcollision(x, a) == true && currHP >= 0) {
			System.out.println(currHP);

			checkHealth();

			if (decreaseBar() == true && c < 31) {
				hpBar.setText("______________________________".substring(0, 30 - c));
				c++;

				System.out.println("HP: " + currHP);

			} else {
				welcomeText.setText("You are dead.");
				gameover = true;
			}
		}

	}

	public boolean decreaseBar() {
		if (currHP < healthMax) {
			return true;
		}
		return false;
	}

}
