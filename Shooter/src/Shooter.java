import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JFrame;

public class Shooter extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Player player1;
	private Player player2;
	public Image image;
	private Graphics graphics;
	
	boolean [] anArray = {
			false,
			false,
			false,
			false
			};
	//players moment
	
	CopyOnWriteArrayList<Bullet> bullets = new CopyOnWriteArrayList<Bullet>();
	
	
	public Shooter() {
		setTitle("2D Shooter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setBackground(Color.BLACK);
		addKeyListener(this);
		setResizable(false);

		setVisible(true);

		player1 = new Player(10, 150, 20, 90, 10, "Images/player1.gif", 0);
		player2 = new Player(570, 150, 20, 90, 10, "Images/player2.gif", 0);
		
		
		repaint();

	}

	public void paint(Graphics g) {
		image = createImage(getWidth(), getHeight());
		graphics = image.getGraphics();

		paintComponent(graphics);
		g.drawImage(image, 0, 0, this);
		
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(player1.getScore()), 100, 90);
		
		g.setColor(Color.red);
		g.drawString(String.valueOf(player2.getScore()), 490, 90);
		
		g.setColor(Color.GREEN);
		g.drawString(String.valueOf(player1.getHealth()), 100, 300);
		
		g.setColor(Color.red);
		g.drawString(String.valueOf(player2.getHealth()), 490, 300);
		
		repaint();
	}

	public void paintComponent(Graphics g) {		
		if (player1.getHealth () > 0 && player2.getHealth()> 0){
			
		}
		else if (player1.getHealth()==0){
		
			g.setColor(Color.RED);
			g.drawString("Player 2 Wins!", 250, 190);
			
			player2.setScore(player2.getScore()+1);
			
			repaint();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
			
			player1.setHealth(10);
			player2.setHealth(10);
		}	
		else if (player2.getHealth()==0){
			
				player1.setScore(player1.getScore()+1);
				
				
				
				g.setColor(Color.GREEN);
				g.drawString("Player 1 Has Won!", 250, 190);		
				
				repaint();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					
				}
				
				player1.setHealth(10);
				player2.setHealth(10);
		}
		
		for (Bullet bullet : bullets){
			bullet.draw(g);
			bullet.update(this, 0);
		}
		
		player1.draw(g);
		player1.update(this, 1);
		player2.draw(g);
		player2.update(this, 2);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		anArray[0]   = (k==87);
		//87=W
		anArray[1] = (k==83);
		//83=s
		anArray[2]  = (k==38);
		//38=up
		anArray[3] = (k==40);
		//40=down

}	
	
	@Override
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if (k == 87)
			anArray[0] = false;
		// 87=W
		else if (k == 83)
			anArray[1] = false;
		// 83=s
		else if (k == 38)
			anArray[2] = false;
		// 38=up
		else if (k == 40)
			anArray[3] = false;
		// 40=down
		else if (k == 10)
			anArray[4] = false;
		else if (k == 10)
			anArray[5] = false;

		else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Bullet player1Bullet = new Bullet(player2, 1, player1.getxPos() + 20, player1.getyPos() + 45, 4, 4, "Images/bullet.gif");
			bullets.add(player1Bullet);
		}

		else if (e.getKeyCode() == KeyEvent.VK_L) {
			Bullet player2Bullet = new Bullet(player1, -1, player2.getxPos() - 4, player2.getyPos() + 45, 4, 4, "Images/bullet.gif");
			bullets.add(player2Bullet);

}
		
}


	@Override
	public void keyTyped(KeyEvent e ) {
		;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public static void main(String[] args) {
		new Shooter();

	}
}
