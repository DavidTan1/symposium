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
	private Graphic inventory;
	private TextArea welcomeText;
	private AnimatedComponent armor;
	public ArrayList<Weapon> weapons;
	public ArrayList<Weapon> uinventory;
	public int stock;
	public int i;

	public Shop(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {

		stock = 1;

		weapons = new ArrayList<Weapon>();
		uinventory = new ArrayList<Weapon>();

		weapons.add(MinuteQuestButBetter.axe);
		weapons.add(MinuteQuestButBetter.shotgun);
		weapons.add(MinuteQuestButBetter.spear);
		weapons.add(MinuteQuestButBetter.stick);

		
		

		welcomeText = new TextArea(5, 700, 800, 100, "Welcome to armory! We sell the finest weapons. "+"PRO TIP: Click on the weapon you would like to buy.");
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

				if (stock == 1)
				{
					displayInventory();
					

					uinventory.add(weapons.get(0));
					displayInventory();
					//Graphic inventory = new Graphic(700, 700, 60, 60, uinventory.get(0).img());
					viewObjects.add(inventory);
					stock = 0;

					ONE.setEnabled(false);
					ONE.setVisible(false);

				} 

			}
		});

		viewObjects.add(ONE);
		
		
		TWO = new Button(100, 200, 60, 60, "", new Action() {

			@Override
			public void act() {

				if (stock == 1)
				{
					
					
					System.out.print("Add to inventory.");

					uinventory.add(weapons.get(1));
					displayInventory();
					//Graphic inventory = new Graphic(700, 700, 60, 60, uinventory.get(0).img());
					viewObjects.add(inventory);
					stock = 0;

					TWO.setEnabled(false);
					TWO.setVisible(false);

				} 

			}
		});

		viewObjects.add(TWO);
	}
		
	
	public void displayInventory()
	{
		for(i=0; i<uinventory.size(); i++)
		{
			inventory = new Graphic(700, i*100, 60, 60, uinventory.get(i).img());

		}
	}
		
}