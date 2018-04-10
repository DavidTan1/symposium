package symposium;

import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Battle extends FullFunctionScreen {

	public int currHP;
	private AnimatedComponent walking;

	public Battle(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		currHP = MinuteQuestButBetter.mc.getVit();
		
		Graphic background = new Graphic(0, 0, 1364,746, "symposium/battlebackground.png");
		
		viewObjects.add(background);
		
		Graphic standing = new Graphic(700, 603, 64,82, "symposium/stand1_0.png");
		viewObjects.add(standing);

		
		
		walking = new AnimatedComponent(700, 603, 65, 83);
		viewObjects.add(walking);
		
		walking.addSequence("symposium/walking.png", 200, 0, 0, 64, 82, 8);
		Thread walk = new Thread(walking);
		walk.start();
		
		
	}

}