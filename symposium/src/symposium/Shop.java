package symposium;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Shop extends FullFunctionScreen {

	public static Inventory inventory;
	private Button ONE;
	private Button TWO;
	private Button THREE;
	private Button FOUR;
	private Button battleb;
	private Graphic userinventory;
	private TextArea welcomeText;

	public ArrayList<Armor> armor;
	public ArrayList<Weapon> weapons;
	public ArrayList<Armor> ainventory;
	public ArrayList<Weapon> uinventory;
	public ArrayList<Graphic> asf;
	public int stock1;
	public int stock2;
	public int stock3;
	public int stock4;
	public int stock5;
	public int stock6;
	public int stock7;
	public int stock8;

	public int i;
	public int currValue;
	private Graphic bob;
	private Button inventoryb;
	private TextArea welcomeTextS;
	private Visible FIVE;
	private Button SIX;
	private Visible SEVEN;
	private Visible EIGHT;

	public Shop(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		setBackground(Color.BLACK);

		currValue = MinuteQuestButBetter.mc.getGold();

		i = 1;
		stock1 = 1;
		stock2 = 1;
		stock3 = 1;
		stock4 = 1;
		stock5 = 1;
		stock6 = 1;
		stock7 = 1;
		stock8 = 1;

		ainventory = new ArrayList<Armor>();
		armor = new ArrayList<Armor>();
		weapons = new ArrayList<Weapon>();
		uinventory = new ArrayList<Weapon>();

		Graphic text = new Graphic(0, 500, 800, 800, "symposium/blackscreen.jpg");
		// viewObjects.add(text);

		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "symposium/weaponshopbackground.png");
		viewObjects.add(background);

		armor.add(MinuteQuestButBetter.advancerobe);
		armor.add(MinuteQuestButBetter.advancebasicarmor);
		armor.add(MinuteQuestButBetter.robe);
		armor.add(MinuteQuestButBetter.basicarmor);

		weapons.add(MinuteQuestButBetter.rod);
		weapons.add(MinuteQuestButBetter.sword);
		weapons.add(MinuteQuestButBetter.axe);
		weapons.add(MinuteQuestButBetter.fist);

		welcomeTextS = new TextArea(5, 675, 800, 100, "Welcome to armory! We sell the finest weapons. "
				+ "PRO TIP: Click on the weapon you would like to buy.");
		viewObjects.add(welcomeTextS);

		welcomeTextS.setTextColor(Color.WHITE);

		welcomeText = new TextArea(5, 675, 800, 100, "Welcome to armory! We sell the finest weapons. "
				+ "PRO TIP: Click on the weapon you would like to buy.");
		viewObjects.add(welcomeText);

		welcomeText.setTextColor(Color.WHITE);

		Graphic firstitem = new Graphic(100, 100, 60, 60, weapons.get(0).img());

		Graphic seconditem = new Graphic(100, 200, 60, 60, weapons.get(1).img());

		Graphic thirditem = new Graphic(100, 300, 60, 60, weapons.get(2).img());

		Graphic fourthitem = new Graphic(100, 400, 60, 60, weapons.get(3).img());

		Graphic item5 = new Graphic(300, 100, 60, 60, armor.get(0).img());

		Graphic item6 = new Graphic(300, 200, 60, 60, armor.get(1).img());

		Graphic item7 = new Graphic(300, 300, 60, 60, armor.get(2).img());

		Graphic item8 = new Graphic(300, 400, 60, 60, armor.get(3).img());

		viewObjects.add(firstitem);
		viewObjects.add(seconditem);
		viewObjects.add(thirditem);
		viewObjects.add(fourthitem);

		viewObjects.add(item5);
		viewObjects.add(item6);
		viewObjects.add(item7);
		viewObjects.add(item8);

		ONE = new Button(100, 100, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock1 == 1 && weapons.get(0).getCost() <= currValue) {

					System.out.println("Add to inventory.");

					displayInventory(weapons.get(0));
					update();

					viewObjects.add(userinventory);

					update();
					stock1--;

					System.out.println(weapons.get(0).name() + " cost " + weapons.get(0).getCost());

					ONE.setEnabled(false);
					ONE.setVisible(false);
					check();
					currValue = currValue - weapons.get(0).getCost();

					uinventory.add(weapons.get(0));
					welcomeText.setText("You have " + currValue + " gold left.");

				} else {
					System.out.print("You don't have enough gold.");
				}

			}
		});

		viewObjects.add(ONE);

		TWO = new Button(100, 200, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock2 == 1 && weapons.get(1).getCost() <= currValue) {

					welcomeText.setText("Add to inventory.");

					displayInventory(weapons.get(1));
					update();

					viewObjects.add(userinventory);

					update();
					stock2--;

					System.out.println(weapons.get(1).name() + " cost " + weapons.get(1).getCost());

					TWO.setEnabled(false);
					TWO.setVisible(false);
					check();

					currValue = currValue - weapons.get(1).getCost();

					uinventory.add(weapons.get(1));

					welcomeText.setText("You have " + currValue + " gold left.");

				} else {
					welcomeText.setText("You don't have enough gold.");

				}

			}
		});

		viewObjects.add(TWO);

		THREE = new Button(100, 300, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock3 == 1 && weapons.get(2).getCost() <= currValue) {

					displayInventory(weapons.get(2));
					update();

					viewObjects.add(userinventory);
					update();
					stock3--;

					THREE.setEnabled(false);
					THREE.setVisible(false);
					check();
					System.out.print(currValue);

					currValue = currValue - weapons.get(2).getCost();
					uinventory.add(weapons.get(2));
					welcomeText.setText("You have " + currValue + " gold left.");

				} else {
					welcomeText.setText("You don't have enough gold.");

				}

			}
		});

		viewObjects.add(THREE);

		FOUR = new Button(100, 400, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock4 == 1 && weapons.get(3).getCost() <= currValue) {

					System.out.print("Add to inventory.");

					displayInventory(weapons.get(3));
					update();

					viewObjects.add(userinventory);
					update();
					stock4--;

					FOUR.setEnabled(false);
					FOUR.setVisible(false);

					check();
					currValue = currValue - weapons.get(3).getCost();

					uinventory.add(weapons.get(3));
					welcomeText.setText("You have " + currValue + " gold left.");
				} else {
					welcomeText.setText("You don't have enough gold.");

				}

			}
		});

		viewObjects.add(FOUR);

		FIVE = new Button(300, 100, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock5 == 1 && armor.get(0).getCost() <= currValue) {

					System.out.println("Add to inventory.");

					displayInventory(armor.get(0));
					update();

					viewObjects.add(userinventory);

					update();
					stock5--;

					System.out.println(armor.get(0).name() + " cost " + armor.get(0).getCost());

					// FIVE.setEnabled(false);
					FIVE.setVisible(false);
					check();
					currValue = currValue - armor.get(0).getCost();

					ainventory.add(armor.get(0));
					welcomeText.setText("You have " + currValue + " gold left.");

				} else {
					System.out.print("You don't have enough gold.");
				}

			}
		});

		viewObjects.add(FIVE);

		SIX = new Button(300, 200, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock6 == 1 && armor.get(1).getCost() <= currValue) {

					System.out.println("Add to inventory.");

					displayInventory(armor.get(1));
					update();

					viewObjects.add(userinventory);

					update();
					stock6--;

					System.out.println(armor.get(1).name() + " cost " + armor.get(1).getCost());

					// SIX.setEnabled(false);
					SIX.setVisible(false);
					check();
					currValue = currValue - armor.get(1).getCost();

					ainventory.add(armor.get(1));
					welcomeText.setText("You have " + currValue + " gold left.");

				} else {
					System.out.print("You don't have enough gold.");
				}

			}
		});

		viewObjects.add(SIX);

		SEVEN = new Button(300, 300, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock7 == 1 && armor.get(2).getCost() <= currValue) {

					System.out.println("Add to inventory.");

					displayInventory(armor.get(2));
					update();

					viewObjects.add(userinventory);

					update();
					stock7--;

					System.out.println(armor.get(2).name() + " cost " + armor.get(2).getCost());

					// SIX.setEnabled(false);
					SEVEN.setVisible(false);
					check();
					currValue = currValue - armor.get(2).getCost();

					ainventory.add(armor.get(2));
					welcomeText.setText("You have " + currValue + " gold left.");

				} else {
					System.out.print("You don't have enough gold.");
				}

			}
		});

		viewObjects.add(SEVEN);

		EIGHT = new Button(300, 400, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock8 == 1 && armor.get(3).getCost() <= currValue) {

					System.out.println("Add to inventory.");

					displayInventory(armor.get(3));
					update();

					viewObjects.add(userinventory);

					update();
					stock8--;

					System.out.println(armor.get(3).name() + " cost " + armor.get(3).getCost());

					// SIX.setEnabled(false);
					EIGHT.setVisible(false);
					check();
					currValue = currValue - armor.get(3).getCost();

					ainventory.add(armor.get(3));
					welcomeText.setText("You have " + currValue + " gold left.");

				} else {
					System.out.print("You don't have enough gold.");
				}

			}
		});

		viewObjects.add(EIGHT);

		battleb = new Button(700, 620, 60, 40, "Battle", new Action() {

			@Override
			public void act() {
				MinuteQuestButBetter.battle.updateW();
				MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.battle);

			}

		});

		viewObjects.add(battleb);
		battleb.setBackground(Color.WHITE);
		battleb.update();

		inventoryb = new Button(700, 680, 60, 40, "Inventory", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

				// inventory = new Inventory(getWidth(),getHeight());

				/*
				 * if(!uinventory.get(0).name().isEmpty()){
				 * 
				 * System.out.println(uinventory.get(0).name());
				 * 
				 * } else if(!ainventory.get(0).name().isEmpty()) {
				 * 
				 * System.out.println(ainventory.get(0).name());
				 * 
				 * }
				 */

				MinuteQuestButBetter.gameGUI.setScreen(new Inventory(getWidth(), getHeight()));
				// MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.inventory);

			}

		});

		inventoryb.setBackground(Color.WHITE);
		inventoryb.update();

		viewObjects.add(inventoryb);

	}

	protected void check() {
		if (stock1 == 0 && stock2 == 0 && stock3 == 0 && stock4 == 0) {
			welcomeText.setText("Out of items come back later.");

		}
	}

	public int checkOut(int cost) {

		currValue = currValue - cost;
		System.out.print(currValue);
		return currValue;
	}

	public void displayInventory(Weapon weapon) {

		userinventory = new Graphic(700, 50 * i, 30, 30, weapon.img());
		i++;

	}

	public void displayInventory(Armor armor) {

		userinventory = new Graphic(700, 50 * i, 30, 30, armor.img());
		i++;

	}

	public ArrayList<Weapon> getInventory() {
		return uinventory;
	}

	public ArrayList<Armor> getAInventory() {
		return ainventory;
	}

}