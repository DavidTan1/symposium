
package symposium;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiTeacher.components.AnimatedComponent;

public class SpriteAttack extends AnimatedComponent {

	
	public boolean striker;
	public boolean strikel;
	
	public int punchg;
	
	public SpriteAttack(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	public void drawImage(Graphics2D g) {
		
		
		long currentTime = System.currentTimeMillis();// gets time now
		// check if it's time to change the frame
		// and make sure that there are images in the frame list
		if (frame != null && frame.size() > 0 && frame.size() == times.size()
				&& currentTime - displayTime > times.get(currentFrame)) {
			displayTime = currentTime;

			// increase the currentFrameIndex but don't exceed size()
			currentFrame = (currentFrame + 1) % punchg;

			if (striker) {

				currentFrame += punchg;
			}
			
			

			// end animation if not on repeat
			if (currentFrame == 0 && !repeat) {
				setRunning(false);
				return;
			}
			// clear the previous image
			clear();
			BufferedImage newFrame = frame.get(currentFrame);
			g.drawImage(newFrame, 0, 0, getWidth(), getHeight(), 0, 0, newFrame.getWidth(), newFrame.getHeight(), null);
		}
	}

}
