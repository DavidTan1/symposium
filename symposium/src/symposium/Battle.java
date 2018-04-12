package symposium;

import java.awt.event.KeyEvent;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Battle extends FullFunctionScreen {

	public int currHP;
	public int count;
	private AnimatedComponent walking;
	private Graphic standing;
	public int currPosition;
	public int newPosition;
	private TextArea stats;
	private TextArea welcomeText;
	private Button skills;
	private Button attack;
	private AnimatedComponent mob;
	private AnimatedComponent strike;
	public boolean attackrn;

	public Battle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub

		MinuteQuestButBetter.bdragon.img();

		count = 1;
		currHP = MinuteQuestButBetter.mc.getVit();
		currPosition = 700;
		attackrn = false;

		Graphic background = new Graphic(0, 0, 1364, 746, "symposium/battlebackground.png");

		viewObjects.add(background);

		strike = new AnimatedComponent(currPosition, 603, 102, 107);
		viewObjects.add(strike);

		standing = new Graphic(700, 603, 64, 82, "symposium/stand1_0.png");
		// viewObjects.add(standing);

		walking = new AnimatedComponent(700, 603, 65, 83);
		viewObjects.add(walking);

		walking.addSequence("symposium/walking.png", 200, 0, 0, 64, 82, 8);
		Thread walk = new Thread(walking);
		walk.start();

		mob = new AnimatedComponent(500, 603, 74, 82);
		viewObjects.add(mob);

		mob.addSequence("symposium/blackdragonstand.png", 200, 0, 0, 73, 81, 5);
		Thread mobbdragon = new Thread(mob);
		mobbdragon.start();

		stats = new TextArea(1375, 100, 200, 1000, "Your character has " + MinuteQuestButBetter.mc.getWeapon().name()
				+ " equipped." + " Your character STR: " + MinuteQuestButBetter.mc.getStr() + "->"
				+ MinuteQuestButBetter.mc.setStr() + " Your character has "
				+ MinuteQuestButBetter.mc.getArmor().getArmorName() + " equipped." + " Your character VIT: "
				+ MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit() + " Your character AGL: "
				+ MinuteQuestButBetter.mc.getAgl() + " -> " + MinuteQuestButBetter.mc.setAgl());

		viewObjects.add(stats);

		welcomeText = new TextArea(5, 800, 800, 100, "Welcome to armory! We sell the finest weapons. "
				+ "PRO TIP: Click on the weapon you would like to buy.");
		viewObjects.add(welcomeText);

		attack = new Button(1000, 850, 60, 60, "Attack", new Action() {

			@Override
			public void act() {
				welcomeText.setText("You try to attack but fail.");

			}

		});

		viewObjects.add(attack);

		skills = new Button(1000, 800, 60, 60, "Skills", new Action() {

			@Override
			public void act() {
				welcomeText.setText("You don't have any skills.");

			}

		});

		viewObjects.add(skills);
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (attackrn == false) {
				for (int i = 0; i < 1; i++) {

					if (currPosition <= 700) {
						newPosition = currPosition + count;
						walking.move(newPosition, 603, 100);
						count++;
						currPosition = newPosition;
					}

				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			if (attackrn == false) {
				for (int i = 0; i < 1; i++) {

					if (currPosition >= 1) {
						newPosition = currPosition - count;
						walking.move(newPosition, 603, 100);
						count++;
						currPosition = newPosition;
					}
				}
			}

		} else if (e.getKeyCode() == KeyEvent.VK_A) {

			walking.setVisible(false);

			attackrn = true;

			if (attackrn == true) {

				strike.setVisible(true);
				strike.move(currPosition - 20, 603, 1);

				strike.addSequence("symposium/basicattack.png", 200, 0, 0, 97, 107, 7);
				Thread striking = new Thread(strike);
				striking.start();

				new Thread() {

					public void run() {

						try {
							Thread.sleep(2000);
						} catch (InterruptedException a) {
							// TODO Auto-generated catch block
							a.printStackTrace();
						}

						strike.setVisible(false);

						walking.setVisible(true);

					}
				}.start();

				attackrn = false;

				
				if(checkMob()==true)
				{
					MinuteQuestButBetter.bdragon.currHealth();
					welcomeText.setText("Black Dragon health: "+MinuteQuestButBetter.bdragon.currHealth()
					+"/"+MinuteQuestButBetter.bdragon.getVit());
				}

				
				
			} else {

			}

		}
		repaint();

	}
	
	
	public boolean checkMob()
	{
		
		if(currPosition==MinuteQuestButBetter.bdragon.getPositionx())
		{
			return true;

		}
		return false;
		
	}

}
