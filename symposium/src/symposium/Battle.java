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

	public int currHP;
	public int count;
	public int currPosition;

	private AnimatedComponent mob;
	private BlastSprite blast;

	private Sprite walklr;
	private SpriteAttack punchlr;

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

	private Graphic blasts;

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

		asd = new TextArea(5, 800, 800, 100, "");
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

		mob = new AnimatedComponent(mobs.get(0).getPositionx(), 603, 74, 82);
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

		checkcollision();
		mobAttack();

		punchlr = new SpriteAttack(walklr.getX(), 590, 51, 90);
		viewObjects.add(punchlr);
		punchlr.setVisible(false);

		punchlr.addSequence("symposium/punchlr.png", 200, 0, 0, 62, 90, 10);
		Thread punchrl = new Thread(punchlr);
		punchrl.start();

		blasts = new Graphic(walklr.getX() + 44, 603, 88, 65, "symposium/blast1.png");
		viewObjects.add(blasts);
		blasts.setVisible(false);

		blast = new BlastSprite(walklr.getX() + 44, 573, 178, 135);
		viewObjects.add(blast);

		blast.addSequence("symposium/blastc.png", 200, 0, 0, 178, 135, 2);
		Thread ki = new Thread(blast);
		ki.start();

		blast.setVisible(false);

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
						+ MinuteQuestButBetter.mc.getArmor().getArmorName() + " equipped." + " Your character VIT: "
						+ MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit()
						+ " Your character AGL: " + MinuteQuestButBetter.mc.getAgl() + " -> "
						+ MinuteQuestButBetter.mc.setAgl());

				textD = true;
			} else {
				stats.setText("");
				textD = false;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_B) {

			
			mobsX = new ArrayList<Integer>();
			
			for(int i=0; i<mobs.size(); i++)
			{
				System.out.println(mobs.get(i).getPositionx());
				mobsX.add(mobs.get(i).getPositionx());
			}
			
			
			for(int x = 0; x<mobsX.size(); x++)
			{
				calcCollision(walklr.getX(),mobsX.get(x));

			}
			
			
			
			blast.setVx(0);
			blast.fired = false;

			blast.setVisible(false);
			blasts.setVisible(false);

			blast.move(walklr.getX() + 44, 573, 1);
			attackrn = false;

			
		}

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT && gameover == false) {

			if (attackrn == false) {

				
				blast.move(walklr.getX(), 573, 1);
				blasts.move(walklr.getX(), 603, 1);

				for (int i = 0; i < 1; i++) {

					if (checkcollision() == false) {

						walklr.left = true;
						System.out.println(walklr.getX());

						if (checkcollision() == true) {
							walklr.setVx(0);

						} else {
							walklr.setVx(3.0); // parameter should be agl/weight

						}

						rightw = true;
						leftw = false;

					}
				}
			}

			mobAttack();

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && gameover == false) {

			if (attackrn == false && walklr.getX() > 1) {
				
				
				blast.move(walklr.getX()+44, 573, 1);
				blasts.move(walklr.getX()+44, 603, 1);

				for (int i = 0; i < 1; i++) {

					walklr.left = false;

					walklr.setVx(-3.0);

					leftw = true;
					rightw = false;

				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A && gameover == false) {

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

		} else if (e.getKeyCode() == KeyEvent.VK_B && gameover == false) {

			attackrn = true;

			blast.fired = true;

			blast.setVisible(true);
			blasts.setVisible(true);

			blast.setVx(3.0);

			welcomeText.setText("You used a energy blast.");
			//hpBar.setText("");

		}

		repaint();

	}

	public boolean calcCollision(int x, int y)
	{
		
		//x is x coord of player
		//y is x coord of mobs
		if(x == y)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkMob() {
		
		
		
		
		
		
		int count = 0;

		if (mobs.get(0).dead() == false) {

			if (walklr.getX() < mobs.get(0).getPositionx()) {
				for (int i = walklr.getX(); i <= mobs.get(0).getPositionx(); i++) {
					count++;
				}
			} else {

				for (int i = mobs.get(0).getPositionx(); i <= walklr.getX(); i--) {
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

		mobs.add(MinuteQuestButBetter.bdragon);
		mobs.add(MinuteQuestButBetter.slime);
		mobs.add(MinuteQuestButBetter.beast);
		mobs.add(MinuteQuestButBetter.vampire);
		mobs.add(MinuteQuestButBetter.devil);
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

	public boolean checkcollision() {

		if (0 > ((mobs.get(0).getPositionx()) - 74) - walklr.getX()) {
			return true;
		}

		return false;
	}

	public void mobAttack() {
		while (checkcollision() == true && currHP >= 0) {
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
