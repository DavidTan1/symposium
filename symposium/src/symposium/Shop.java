package symposium;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import javafx.scene.paint.Color;

public class Shop extends FullFunctionScreen{

	private TextArea welcomeText; 
	private AnimatedComponent armor;
	public ArrayList<Weapon> weapons;

	
	public Shop(int width, int height) {
		super(width,height);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		//System.out.println("What would like to do buy we have "+Hero.Weapon.getname());
	}

	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
		weapons = new ArrayList<Weapon>();

		weapons.add(MainGame.axe);
		
		welcomeText = new TextArea(0,700,800,100,"What weapons would you like to purchase");
		viewObjects.add(welcomeText);
		
		armor = new AnimatedComponent(0, 0, 598, 59);
		viewObjects.add(armor);

		
		//armor.addSequence("symposium/armor1.png", 200, 0, 0, 597, 58, 10);
		//Thread asdf = new Thread(armor);
		//asdf.start();
		

		Graphic armor = new Graphic(0, 0, getWidth(), getHeight(), "symposium/armor1.png");
		viewObjects.add(armor);
		
		
		
		Graphic axe = new Graphic(0, 0, 100, 100,weapons.get(0).img());

		viewObjects.add(axe);
	}

}
