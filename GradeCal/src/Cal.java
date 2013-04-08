import javax.swing.JOptionPane;


public class Cal {

	public static void main(String[] args) {
		
		//this is all the numbers that are bing used in the program
		int unit1;
		int unit2;
		int unit3;
		int unit4;
		int unit5;
		int unit6;
		int unit7;
		int unit8;
		int unit9;
		int total;
		
		//this collects the grades for each unit from the user
		unit1 = getInput(null, "Pleace enter Unit 1's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit2 = getInput(null, "Pleace enter Unit 2's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit3 = getInput(null, "Pleace enter Unit 3's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit4 = getInput(null, "Pleace enter Unit 4's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit5 = getInput(null, "Pleace enter Unit 5's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit6 = getInput(null, "Pleace enter Unit 6's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit7 = getInput(null, "Pleace enter Unit 7's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit8 = getInput(null, "Pleace enter Unit 8's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		unit9 = getInput(null, "Pleace enter Unit 9's Grade",
				"GradeCal", JOptionPane.QUESTION_MESSAGE);
		
		//this works out the users final grade and a number
		total = unit1 + unit2 + unit3 + unit4 + unit5 + unit6 + unit7 + unit8 + unit9;
		
		//this tells the user their total marks
		System.out.println(total);
		
		//this if statement then works out what final grade by number finding out what 
		//the number is equal to as a letter group
		if (total <= 649){
			System.out.println("PPP");
			System.exit(0);
		}
		if (total >= 650 && total <= 669){
			System.out.println("MPP");
			System.exit(0);
		}
		if (total >= 670 && total <= 689){
			System.out.println("MMP");
			System.exit(0);
		}	
		if (total >= 690 && total <= 709){
			System.out.println("MMM");
			System.exit(0);
		}
		if (total >= 710 && total <= 729){
			System.out.println("DMM");
			System.exit(0);
		}
		if (total >= 730 && total <= 749){
			System.out.println("DDM");
			System.exit(0);
		}	
		if (total >= 750 && total <= 764){
			System.out.println("DDD");
			System.exit(0);
		}	
		if (total >= 765 && total <= 779){
			System.out.println("D*DD");
			System.exit(0);
		}		
		if (total >= 780 && total <= 794){
			System.out.println("D*D*D");
			System.exit(0);
		}	
		if (total > 795 && total <= 810){
			System.out.println("D*D*D*");
			System.exit(0);

		}
}

	public static int getInput(Object object, String string, String string2, int questionMessage) {
		String usergrade = null;
		
		//this is the method for collecting the users grade it collects the character
		//and store it as a variable
		
		try {
			usergrade = JOptionPane.showInputDialog(null,
					"Pleace enter Units Grade",
					"GradeCal", JOptionPane.QUESTION_MESSAGE);

		} catch (NumberFormatException error) {
			System.out.println("Pleace enter your grade");
			System.exit(0);
		}
		char grade =  usergrade.charAt(0);
		
		//this checks what character was entered with a number so the program and do the math
		//for working out the grade
		
		switch(grade) {
			case 'p': 
				return 70;
			case 'P': 
				return 70;
				
			case 'm':
				return 80;
			case 'M':
				return 80;
				
			case 'd':
				return 90;
			case 'D':
				return 90;
			
			//this tells the user they failed the course as they had a F 
			//and will end the program
			case 'F':
				System.out.println("You have failed the course");
				System.exit(0);
			case 'f':
				System.out.println("You have failed the course");
				System.exit(0);
			//if no grade is entered then it asks for the user to "enter grade"	
			default: System.out.println("Enter Grade");
		}
		return grade;
	}
}
