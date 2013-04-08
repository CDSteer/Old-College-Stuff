import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class Player extends GameObject {

	/**
	 * Create a player
	 * @param xPos x position
	 * @param yPos y position
	 * @param height height of player
	 * @param width width of player
	 * @param health health of player
	 * @param img image of player
	 * @param score of player
	 */

	public Player(final int xPos, final int yPos, final int width,
			final int height, final int health, final String img, final int score) {
		
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		this.width = width;
		this.rect = new Rectangle (xPos, yPos, width, height);
		this.img = getimage(img);
		this.health = health;
		this.score = score;
		
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(img, xPos, yPos, width, height, null);
	}

	@Override
	void update(final Shooter shooter, final int id) {
		if(id==1){
			//player 1 up and down
			if(shooter.anArray[0] && !(yPos<26))
				yPos--;
				rect.y--;
			//w=up
			if(shooter.anArray[1] && !(yPos>shooter.getHeight()-96))
				yPos++;
				rect.y++;
			//y=up
		} else if(id==2) {
			//player 2 up and down
			if(shooter.anArray[2]&& !(yPos<26))
				yPos--;
				rect.y--;
			//up key
			if(shooter.anArray[3] && !(yPos>shooter.getHeight()-96))
				yPos++;
				rect.y++;
			//down key
		}
	}

	@Override
	Image getimage(String img) {
		
		return Toolkit.getDefaultToolkit().getImage(img);
	
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}