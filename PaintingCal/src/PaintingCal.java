import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PaintingCal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		double	width;
		double	height;
		double	length;
		double	h = 1.75; //high Paint cost
		double	s = 1.00; //standard Paint cost
		double	v = 0.45; //value Paint cost
		double	area;
		String  userPaint;
		double	totalcost;
		double  userPaintcost;
		
		String[] choices = {"High - £1.75", "Standard - £1.00", "Value - £0.45", "Quit"};
		
		//creates a window for the users results
		public PaintingCal() {
			setTitle("Room Painting Caculator");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(450, 150);
			setResizable(false);
			setVisible(true);
			repaint();
		}
		public void paint(Graphics g) {
			
			//paints the JFrame background black
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			
			//works out the area and prints it for the user
			g.setColor(Color.RED);
		 	g.drawString("Area = " + ((height*width)*2 + (length*height)*2)+"m2", 25, 50);
			
		 	//tells the user their paint choice and price
		 	g.setColor(Color.RED);
			g.drawString("You Selected " + userPaint + " this costs " + userPaintcost + "per meter squared", 25, 70);
			
			totalcost = area * userPaintcost; //works out the total cost
			
			DecimalFormat df = new DecimalFormat("#.##"); //rounds number to 2 decimal places
			
			//tells the user the total cost for the paint
			g.setColor(Color.RED);
			g.drawString("Total cost: £" + (df.format(totalcost)), 50, 90);	
			
		}
		
		{
			
		//asks for width
	 	width = Double.parseDouble(JOptionPane.showInputDialog("Enter Width"));
	 	//asks for height
	 	height = Double.parseDouble(JOptionPane.showInputDialog("Enter Height"));
	 	//asks for length
	 	length= Double.parseDouble(JOptionPane.showInputDialog("Enter Length"));
	 	
	 	//works out the area and stores it as a variable
	 	area = ((height*width)*2 + (length*height)*2);
	 	
	 	//opens the option asking the user what quality paint they would like
	    int response = JOptionPane.showOptionDialog(
                null                       // Centre in window.
              , "What Paint Would You Like?"        // Message
              , "Paint"               // Title in titlebar
              , JOptionPane.YES_NO_OPTION  // Option type
              , JOptionPane.PLAIN_MESSAGE  // messageType
              , null                       // Icon (none)
              , choices                    // Button text as above.
              , "Quit"    // Default button's label
            );

	    //sets response for High Quality Paint
	 	if (response == 0) {
	 				
	 		userPaint = "High Quality Paint";
	 		userPaintcost = h;

	 	}
	 	//sets response for Standard Quality Paint
	 	else if (response == 1) {
	 		
	 		userPaint = "Standared Quality Paint";
	 		userPaintcost = s;
 
	 	}
	 	//sets response for Value paint
	 	else if (response == 2) {
	 		
	 		userPaint = "Value Paint";
	 		userPaintcost = v;

	 	}
	 	//exits program
	 	else if (response == 3) {
	 		System.exit(0);
	 	}
		}
	 		
	 		public static void main(String[] args) {
				new PaintingCal();
			}
	
}