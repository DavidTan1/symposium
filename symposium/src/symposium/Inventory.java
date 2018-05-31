package symposium;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Inventory extends FullFunctionScreen {

	private TextArea asdf;
	private TextArea asd;
	private TextArea as;
	private TextArea a;

	private Button back;
	private Button equip;
	private Graphic weapon;
	private TextArea stats;
	private Graphic armorEquip;
	private Graphic weaponEquip;
	private Graphic armor;

	public Inventory(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		
		
		Font fontsize50 = new Font("serif", Font.PLAIN, 50);
		Font fontsize25 = new Font("serif", Font.PLAIN, 25);

		asdf.setTextColor(Color.BLACK);

		asdf = new TextArea(100, 25, 1000, 1000, "Inventory");
		viewObjects.add(asdf);
		asdf.setFont(fontsize50);

		asd = new TextArea(100, 125, 1000, 1000, "Weapon");
		asd.setFont(fontsize25);
		viewObjects.add(asd);

		as = new TextArea(300, 125, 1000, 1000, "Armor");
		as.setFont(fontsize25);
		viewObjects.add(as);

		a = new TextArea(500, 125, 1000, 1000, "Equipped");
		a.setFont(fontsize25);
		viewObjects.add(a);
		
		
		weaponEquip = new Graphic(500, 200, 60, 60, "symposium/white.png");
		armorEquip = new Graphic(500, 275, 60, 60, "symposium/white.png");

		stats = new TextArea(5, 675, 800, 100, "Your character has " + MinuteQuestButBetter.mc.getWeapon().name()
				+ " equipped." + " Your character STR: " + MinuteQuestButBetter.mc.getStr() + "->"
				+ MinuteQuestButBetter.mc.setStr() + " Your character has " + MinuteQuestButBetter.mc.getArmor().name()
				+ " equipped." + " Your character VIT: " + MinuteQuestButBetter.mc.getVit() + " -> "
				+ MinuteQuestButBetter.mc.setVit() + " Your character AGL: " + MinuteQuestButBetter.mc.getAgl() + " -> "
				+ MinuteQuestButBetter.mc.setAgl());

		viewObjects.add(stats);

		back = new Button(700, 625, 60, 60, "Back", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				
				
				MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.shop);

			}

		});

		viewObjects.add(back);

		if (!MinuteQuestButBetter.shop.getInventory().isEmpty()) {
			weapon();
		}

		if (!MinuteQuestButBetter.shop.getAInventory().isEmpty()) {

			armor();
		}

		// stats.setText(MinuteQuestButBetter.mc.getWeapon().img());

	}

	public void updateEquip() {
		stats.setText("Your character has a " + MinuteQuestButBetter.mc.getWeapon().name() + " equipped."
				+ " Your character STR: " + MinuteQuestButBetter.mc.getStr() + "->" + MinuteQuestButBetter.mc.setStr()
				+ " Your character has a " + MinuteQuestButBetter.mc.getArmor().name() + " equipped."
				+ " Your character VIT: " + MinuteQuestButBetter.mc.getVit() + " -> " + MinuteQuestButBetter.mc.setVit()
				+ " Your character AGL: " + MinuteQuestButBetter.mc.getAgl() + " -> "
				+ MinuteQuestButBetter.mc.setAgl());
	}

	public void upgrade() {

	}

	public void armor() {
		for (int i = 0; i < MinuteQuestButBetter.shop.getAInventory().size(); i++) {
			armor = new Graphic(300, (50 * i) + 200, 60, 60, MinuteQuestButBetter.shop.getAInventory().get(i).img());
			getViewObjects().add(armor);

		}
		System.out.println(MinuteQuestButBetter.shop.getAInventory().size());
		for (int item = 0; item <= MinuteQuestButBetter.shop.getAInventory().size(); item++) {
			int number = item;
			equip = new Button(300, (50 * item) + 200, 60, 60, "", new Action() {

				public void act() {

					MinuteQuestButBetter.mc.addArmor(MinuteQuestButBetter.shop.getAInventory().get(number));
					updateEquip();

					getViewObjects().remove(armorEquip);

					armorEquip = new Graphic(500, 200, 60, 60,
							MinuteQuestButBetter.shop.getAInventory().get(number).img());
					getViewObjects().add(armorEquip);
				}

			});

			getViewObjects().add(equip);

		}
	}

	public void weapon() {
		for (int i = 0; i < MinuteQuestButBetter.shop.getInventory().size(); i++) {
			weapon = new Graphic(100, (50 * i) + 200, 60, 60, MinuteQuestButBetter.shop.getInventory().get(i).img());
			getViewObjects().add(weapon);

		}

		System.out.println(MinuteQuestButBetter.shop.getInventory().size());
		for (int item = 0; item <= MinuteQuestButBetter.shop.getInventory().size(); item++) {
			int number = item;
			equip = new Button(100, (50 * item) + 200, 60, 60, "", new Action() {

				public void act() {
					// System.out.println(MinuteQuestButBetter.shop.getInventory().get(number));

					MinuteQuestButBetter.mc.addWeapon(MinuteQuestButBetter.shop.getInventory().get(number));
					updateEquip();

					getViewObjects().remove(weaponEquip);

					weaponEquip = new Graphic(500, 275, 60, 60,
							MinuteQuestButBetter.shop.getInventory().get(number).img());
					getViewObjects().add(weaponEquip);

				}

			});

			getViewObjects().add(equip);

		}
	}

}
