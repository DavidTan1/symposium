package symposium;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Inventory extends FullFunctionScreen{

	private Button back;
	private Graphic weapon;
	public Inventory(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		//Graphic hero = new Graphic(0, 0, getWidth(), getHeight(), "symposium/inventoryhero.jpg");
		//viewObjects.add(hero);
		
		
		System.out.println(MinuteQuestButBetter.shop.getInventory());
		
		
		
		back = new Button(700, 625, 60, 60, "Back", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub
				MinuteQuestButBetter.gameGUI.setScreen(MinuteQuestButBetter.shop);

			}

		});

		viewObjects.add(back);
		
		displayInventory();
		
		for(int i=0; i<MinuteQuestButBetter.shop.getInventory().size(); i++)
		{
			weapon = new Graphic(100, 100*i, 60, 60, MinuteQuestButBetter.shop.getInventory().get(i).img());
			viewObjects.add(weapon);

		}

		
	}
	
	public void displayInventory()
	{
		
	}

}
