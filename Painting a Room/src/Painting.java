import javax.swing.JOptionPane;

public class Painting {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new Painting();

		double width;
		double height;
		double length;
		double h = 1.75; // highPaint
		double s = 1.00; // standardPaint
		double v = 0.45; // valuePaint
		double area;
		double totalcost;

		String[] choices = { "High - £1.75", "Standard - £1.00",
				"Value - £0.45", "Quit" };

		// asks for width
		width = Double.parseDouble(JOptionPane.showInputDialog("Enter Width"));
		// asks for height
		height = Double
				.parseDouble(JOptionPane.showInputDialog("Enter Height"));
		// asks for length
		length = Double
				.parseDouble(JOptionPane.showInputDialog("Enter Length"));

		// works out the area and stores it as a variable
		area = ((height * width) * 2 + (length * height) * 2);

		// //works out the area and prints it for the user
		System.out.println("Area = "
				+ ((height * width) * 2 + (length * height) * 2));

		int response = JOptionPane.showOptionDialog(null // Center in window.
				, "What Paint Would You Like?" // Message
				, "Paint Option" // Title in titlebar
				, JOptionPane.YES_NO_OPTION // Option type
				, JOptionPane.PLAIN_MESSAGE // messageType
				, null // Icon (none)
				, choices // Button text as above.
				, "Quit" // Default button's label
		);

		// prints response for High Quality Paint
		if (response == 0) {
			
			totalcost = area * h;
			System.out.println("You selected High Quality Paint");
			System.out.println("The Total Cost is £" + totalcost);
		}
		// prints response for Standard Quality Paint
		else if (response == 1) {

			totalcost = area * s;
			System.out.println("You selected Standard Quality Paint");
			System.out.println("The Total Cost is £" + totalcost);
		} else if (response == 2) {

			totalcost = area * v;
			System.out.println("You have selected Value Paint");
			System.out.println("The Total Cost is £" + totalcost);

		}
		// exits program
		else if (response == 3) {
			System.exit(0);

		}
	}
}


