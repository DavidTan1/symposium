package symposium;


import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.TextLabel;


public class Money extends TextLabel {
	
	public int money;

	public Money(int x, int y, int w, int h, String text, int value) {
		super(x, y, w, h, text);
		
		money = value;

	}

	public void update(Graphics2D g){
		clear();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(getFont());
		FontMetrics fm = g.getFontMetrics();
		g.setColor(getTextColor());
		if(getText() != null){
			String[] paragraphs = getText().split("\n");
			final int SPACING = 2;
			int y = 0 + fm.getHeight()+SPACING;
			for(String paragraph: paragraphs){
				String[] words = paragraph.split(" ");
				if(words.length >0){
					int i = 0;
					String line = "";
					//				i++;
					while(i < words.length){
						while(i < words.length && fm.stringWidth(line) + fm.stringWidth(words[i]) < getWidth()){
							line += words[i]+" ";
							i++;
						}
						if(y < getHeight()){
							g.drawString(line, 2, y);
							y += fm.getDescent() + fm.getHeight()+SPACING;
							line = "";
						}else{
							break;//print no more text
						}
					}
				}
			}
		}
	}
	
	
	public int moneyAmount()
	{
		return money;
	}

}
