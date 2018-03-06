package symposium;

import guiTeacher.GUIApplication;

public class MinuteQuestButBetter extends GUIApplication {

	public static MinuteQuestButBetter gameGUI;
	public static Shop shop;
	
	public MinuteQuestButBetter(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initScreen() {
		// TODO Auto-generated method stub
		shop = new Shop(getWidth(), getHeight());
		setScreen(shop);
	}
	
	
	public static void main(String[] args) {
		gameGUI = new MinuteQuestButBetter(800, 800);
		Thread runner = new Thread(gameGUI);
		runner.start();
	}

}
