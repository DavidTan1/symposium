package guiPlayer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputMachine {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter some text");
		InputMachine x = new InputMachine();
		x.testSaveContent(in.nextLine());
	}

	public InputMachine() {
		// TODO Auto-generated constructor stub
	}
	
	public void testSaveContent(String text) {
		try{    
			FileWriter fw=new FileWriter("text.txt");
			fw.write(text);
			fw.close();    
			System.out.println("Success! File \""+"text.txt"+"\" saved!");

		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}
	}
}
