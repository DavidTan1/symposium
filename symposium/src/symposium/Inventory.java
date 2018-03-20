package symposium;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Inventory extends FullFunctionScreen {

	private Button back;
	private Button equip;
	private Graphic weapon;
	private TextArea stats;
	private Graphic armorEquip;
	private Graphic weaponEquip;


	public Inventory(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		// Graphic hero = new Graphic(0, 0, getWidth(), getHeight(),
		// "symposium/inventoryhero.jpg");
		// viewObjects.add(hero);

		weaponEquip = new Graphic(600, 400, 60, 60, "symposium/white.png");
		
		stats = new TextArea(5, 675, 800, 100, "Your character has a " + MinuteQuestButBetter.mc.getWeapon().name()
				+ " equipped." + " Your character STR: " + MinuteQuestButBetter.mc.getStr() + "->"
				+ MinuteQuestButBetter.mc.setStr() + " Your character has a "
				+ MinuteQuestButBetter.mc.getArmor().getArmorName() + " equipped." + " Your character VIT: "
				+ MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit() + " Your character AGL: "
				+ MinuteQuestButBetter.mc.getAgl() + " -> " + MinuteQuestButBetter.mc.setAgl());

		viewObjects.add(stats);

		back = new Button(700, 625, 60, 60, "Back", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.shop);

			}

		});

		viewObjects.add(back);

		displayInventory();

		for (int i = 0; i < MinuteQuestButBetter.shop.getInventory().size(); i++) {
			weapon = new Graphic(100, (50 * i)+50, 60, 60, MinuteQuestButBetter.shop.getInventory().get(i).img());
			viewObjects.add(weapon);

		}
		System.out.println(MinuteQuestButBetter.shop.getInventory().size());
		for (int item = 0; item <= MinuteQuestButBetter.shop.getInventory().size(); item++) {
			int number = item;
			equip = new Button(100, (50 * item)+50, 60, 60, "", new Action() {

				public void act() {
					// System.out.println(MinuteQuestButBetter.shop.getInventory().get(number));
					MinuteQuestButBetter.mc.addWeapon(MinuteQuestButBetter.shop.getInventory().get(number));
					updateEquip();
					
					viewObjects.remove(weaponEquip);

					
					weaponEquip = new Graphic(600, 400, 60, 60, MinuteQuestButBetter.shop.getInventory().get(number).img());
					viewObjects.add(weaponEquip);
				}

			});

			viewObjects.add(equip);

		}

		// stats.setText(MinuteQuestButBetter.mc.getWeapon().img());

	}

	
	
	public void updateEquip() {
		stats.setText("Your character has a " + MinuteQuestButBetter.mc.getWeapon().name() + " equipped."
				+ " Your character STR: " + MinuteQuestButBetter.mc.getStr() + "->" + MinuteQuestButBetter.mc.setStr()
				+ " Your character has a " + MinuteQuestButBetter.mc.getArmor().getArmorName() + " equipped."
				+ " Your character VIT: " + MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit()
				+ " Your character AGL: " + MinuteQuestButBetter.mc.getAgl() + " -> "
				+ MinuteQuestButBetter.mc.setAgl());
	}

	public void displayInventory() {
		
		//weaponEquip = new Graphic(100, 100 * i, 60, 60, MinuteQuestButBetter.shop.getInventory().get(i).img());

	}

}
