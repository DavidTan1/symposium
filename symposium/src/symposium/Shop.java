package symposium;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import javafx.scene.paint.Color;

public class Shop extends FullFunctionScreen {

	private Button ONE;
	private Button TWO;
	private Button THREE;
	private Button FOUR;
	private Button back;
	private Graphic inventory;
	private TextArea welcomeText;
	private AnimatedComponent armor;
	public ArrayList<Weapon> weapons;
	public ArrayList<Weapon> uinventory;
	public ArrayList<Graphic> asf;
	public int stock1;
	public int stock2;
	public int stock3;
	public int stock4;
	public int i;
	private Graphic bob;
	
	public Shop(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		
		i = 1;
		stock1 = 1;
		stock2 = 1;
		stock3 = 1;
		stock4 = 1;

		weapons = new ArrayList<Weapon>();
		uinventory = new ArrayList<Weapon>();

		
		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "symposium/weaponshopbackground.jpg");

		viewObjects.add(background);
				
		weapons.add(MinuteQuestButBetter.axe);
		weapons.add(MinuteQuestButBetter.shotgun);
		weapons.add(MinuteQuestButBetter.spear);
		weapons.add(MinuteQuestButBetter.stick);

		welcomeText = new TextArea(5, 700, 800, 100, "Welcome to armory! We sell the finest weapons. "
				+ "PRO TIP: Click on the weapon you would like to buy.");
		viewObjects.add(welcomeText);

		armor = new AnimatedComponent(0, 0, 598, 59);
		viewObjects.add(armor);

		// armor.addSequence("symposium/armor1.png", 200, 0, 0, 597, 58, 10);
		// Thread asdf = new Thread(armor);
		// asdf.start();

		Graphic firstitem = new Graphic(100, 100, 60, 60, weapons.get(0).img());

		Graphic seconditem = new Graphic(100, 200, 60, 60, weapons.get(1).img());

		Graphic thirditem = new Graphic(100, 300, 60, 60, weapons.get(2).img());

		Graphic fourthitem = new Graphic(100, 400, 60, 60, weapons.get(3).img());

		viewObjects.add(firstitem);
		viewObjects.add(seconditem);
		viewObjects.add(thirditem);
		viewObjects.add(fourthitem);

		ONE = new Button(100, 100, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock1 == 1) {

					System.out.print("Add to inventory.");

					displayInventory(weapons.get(0));
					update();

					viewObjects.add(inventory);

					update();
					stock1--;

					ONE.setEnabled(false);
					ONE.setVisible(false);
					check();

				}

			}
		});

		viewObjects.add(ONE);

		TWO = new Button(100, 200, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock2 == 1) {

					System.out.print("Add to inventory.");

					displayInventory(weapons.get(1));
					update();

					viewObjects.add(inventory);
					update();
					stock2--;

					TWO.setEnabled(false);
					TWO.setVisible(false);
					check();

				}

			}
		});

		viewObjects.add(TWO);

		THREE = new Button(100, 300, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock3 == 1) {

					System.out.print("Add to inventory.");

					displayInventory(weapons.get(2));
					update();

					viewObjects.add(inventory);
					update();
					stock3--;

					THREE.setEnabled(false);
					THREE.setVisible(false);
					check();

				}

			}
		});

		viewObjects.add(THREE);

		FOUR = new Button(100, 400, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock4 == 1) {

					System.out.print("Add to inventory.");

					displayInventory(weapons.get(3));
					update();

					viewObjects.add(inventory);
					update();
					stock4--;

					FOUR.setEnabled(false);
					FOUR.setVisible(false);

					check();
				}

			}
		});

		viewObjects.add(FOUR);

		back = new Button(700, 650, 60, 60, "Back", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

			}

		});

		viewObjects.add(back);
	}

	protected void check() {
		if (stock1 == 0 && stock2 == 0 && stock3 == 0 && stock4 == 0) {
			welcomeText.setText("Out of items come back later.");

		}
	}

	public void displayInventory(Weapon weapon) {

		inventory = new Graphic(700, 50 * i, 30, 30, weapon.img());
		i++;

	}
}