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

	public int currHP;
	public int count;
	public int currPosition;

	private AnimatedComponent walking;
	private AnimatedComponent walkingR;
	private AnimatedComponent strikeR;
	private AnimatedComponent strikeL;
	private AnimatedComponent mob;

	private Sprite walklr;

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

	public Battle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		setBackground(Color.BLACK);

		welcomeText = new TextArea(5, 800, 800, 100,
				"Kill the dragon to reach the next town." + "PRO TIP: Pressed 'A' to attack.");

		viewObjects.add(welcomeText);

		welcomeText.setTextColor(Color.WHITE);

		stats = new TextArea(1075, 800, 200, 500, "");

		viewObjects.add(stats);

		asd = new TextArea(5, 800, 800, 100,
				"Kill the dragon to reach the next town." + "PRO TIP: Pressed 'A' to attack.");
		viewObjects.add(asd);

		// TODO Auto-generated method stub

		createMobs();

		count = 1;
		c = 10;
		currPosition = 300;
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
		// strikeL = new AnimatedComponent(currPosition, 585, 102, 107); // create
		// better movement and attack animation
		// viewObjects.add(strikeL); // striking left

		// strikeR = new AnimatedComponent(currPosition, 585, 101, 101); // create
		// better movement and attack animation
		// viewObjects.add(strikeR); // striking right

		// walkingR = new AnimatedComponent(100, 585, 91, 117);
		// viewObjects.add(walkingR);

		// walkingR.addSequence("symposium/walkingsword.png", 200, 0, 0, 90, 116, 4); //
		// create better movement and attack
		// animation
		// Thread walkR = new Thread(walkingR); // animation for moving right
		// walkR.start();

		// walking = new AnimatedComponent(100, 590, 65, 83);
		// viewObjects.add(walking);
		// walking.setVisible(false);

		// walking.addSequence("symposium/walking.png", 200, 0, 0, 64, 82, 8); // create
		// better movement and attack
		// animation
		// Thread walk = new Thread(walking); // animation for moving left
		// walk.start();

		mob = new AnimatedComponent(500, 603, 74, 82);
		viewObjects.add(mob);

		mob.addSequence("symposium/blackdragonstand.png", 200, 0, 0, 73, 81, 5);
		Thread mobbdragon = new Thread(mob);
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

		walklr.addSequence("symposium/walkl&r.png", 200, 0, 0, 60, 75, 8);
		Thread walkrl = new Thread(walklr);
		walkrl.start();

	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// walkingR.setVx(0);
			walklr.setVx(0);

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			// walking.setVx(0);
			walklr.setVx(0);

		} else if (e.getKeyCode() == KeyEvent.VK_S) {

			if (textD == false) {

				stats.setText("Your character has " + MinuteQuestButBetter.mc.getWeapon().name() + " equipped."
						+ " Your character STR: " + MinuteQuestButBetter.mc.getStr() + "->"
						+ MinuteQuestButBetter.mc.setStr() + " Your character has "
						+ MinuteQuestButBetter.mc.getArmor().getArmorName() + " equipped." + " Your character VIT: "
						+ MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit()
						+ " Your character AGL: " + MinuteQuestButBetter.mc.getAgl() + " -> "
						+ MinuteQuestButBetter.mc.setAgl());

				textD = true;
			} else {
				stats.setText("");
				textD = false;
			}
		}

	}

	public void keyPressed(KeyEvent e) {
		// System.out.println(currPosition);

		if (e.getKeyCode() == KeyEvent.VK_RIGHT && gameover == false) {
			if (attackrn == false) {
				// walkingR.setVisible(true);
				for (int i = 0; i < 1; i++) {

					walklr.left = true;

					currPosition++;
					System.out.println(currPosition);
					walklr.setVx(3.0); //parameter should be agl/weight
					// walking.move(currPosition, 592, 1);
					// walkingR.move(currPosition, 585, 1);

					// walking.setVisible(false);

					rightw = true;
					leftw = false;

					if (currPosition > 470) {
						MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.shop);
					}
				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && gameover == false) {

			if (attackrn == false) {
				// walking.setVisible(true);
				for (int i = 0; i < 1; i++) {

					

						walklr.left = false;
						currPosition--;

						walklr.setVx(-3.0);

						// walkingR.setVx(3.0);

						// walking.move(currPosition, 592, 1);
						// walkingR.move(currPosition, 585, 1);

						// walkingR.setVisible(false);

						leftw = true;
						rightw = false;
					
				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A && gameover == false) {

			walking.setVisible(false);
			walkingR.setVisible(false);

			attackrn = true;

			if (attackrn == true && leftw == true) {

				strikeL.setVisible(true);
				strikeL.move(currPosition - 20, 585, 1);

				strikeL.addSequence("symposium/basicattack.png", 200, 0, 0, 97, 107, 7);
				Thread striking = new Thread(strikeL); // animation for striking left
				striking.start();

				new Thread() {

					public void run() {

						try {
							Thread.sleep(2000);
						} catch (InterruptedException a) {
							// TODO Auto-generated catch block
							a.printStackTrace();
						}

						strikeL.setVisible(false);

						walking.setVisible(true);
						attackrn = false;

					}
				}.start();

				if (checkMob() == true) {
					mobs.get(0).currHealth();
					welcomeText
							.setText("Black Dragon health: " + mobs.get(0).currHealth() + "/" + mobs.get(0).getVit());

					System.out.println("check ");
					mobAttack();

					if (mobs.get(0).dead() == true) {
						welcomeText.setText("You kill the dragon.");

						if (MinuteQuestButBetter.bdragon.dead() == true) {

							getViewObjects().remove(mob);

						}
						mob.update();
					}

				} else {
					welcomeText.setText("You swing your sword but hit nothing.");
				}

			} else {
				attackrn = true;
				strikeR.setVisible(true);
				strikeR.move(currPosition - 20, 603, 1);

				strikeR.addSequence("symposium/attack right.png", 200, 0, 0, 100, 100, 7);
				Thread strikingR = new Thread(strikeR); // animation for striking right
				strikingR.start();

				new Thread() {

					public void run() {

						try {
							Thread.sleep(2000);
						} catch (InterruptedException a) {
							// TODO Auto-generated catch block
							a.printStackTrace();
						}

						strikeR.setVisible(false);

						walkingR.setVisible(true);
						attackrn = false;

					}
				}.start();

				if (checkMob() == true) {
					mobs.get(0).currHealth();
					welcomeText
							.setText("Black Dragon health: " + mobs.get(0).currHealth() + "/" + mobs.get(0).getVit());

					if (mobs.get(0).dead() == true) {
						welcomeText.setText("You kill the dragon.");

						if (MinuteQuestButBetter.bdragon.dead() == true) {

							getViewObjects().remove(mob);

						}
						mob.update();
					}

				} else {
					welcomeText.setText("You swing your sword but hit nothing.");
				}

			}

		}

		repaint();

	}

	public boolean checkMob() {
		int count = 0;

		if (mobs.get(0).dead() == false) {

			if (currPosition < mobs.get(0).getPositionx()) {
				for (int i = currPosition; i <= mobs.get(0).getPositionx(); i++) {
					count++;
				}
			} else {

				for (int i = mobs.get(0).getPositionx(); i <= currPosition; i--) {
					count++;
				}
			}
			if (count <= 75) {

				return true;
			}

		}

		System.out.println("range is " + count);
		return false;

	}

	private void createMobs() {
		mobs = new ArrayList<Mobs>();
		// System.out.println(bannerNum);

		mobs.add(MinuteQuestButBetter.bdragon);
		mobs.add(MinuteQuestButBetter.robot);
		// mobs.add();
		// mobs.add();
		// mobs.add();

		System.out.println(mobs.get(0).img() + " " + mobs.get(1).img());

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

	public void mobAttack() {
		if (mobs.get(0).getcurrHealth() < mobs.get(0).getVit()) {

			System.out.println("dragon hp: " + currHP);
			checkHealth();

			if (decreaseBar() == true && c < 31) {
				hpBar.setText("______________________________".substring(0, 30 - c));
				c++;

				System.out.println("HP: " + currHP);

			} else {
				welcomeText.setText("You are dead.");
				gameover = true;
			}
		} else {

		}

	}

	public boolean checkcollision() {

		for (int i = 0; i < mobs.size(); i++) {
			if (mobs.get(i).getPositionx() == currPosition) {
				return true;
			}

		}
		return false;
	}

	public boolean decreaseBar() {
		if (currHP < healthMax) {
			return true;
		}
		return false;
	}

}
