import java.util.Scanner;


public class gcd {
	
	public static void main(String args[]){
		
			int r = 0;
			
			System.out.println("Enter your first interger");
			
				Scanner scan = new Scanner (System.in);
				int A = scan.nextInt();
		
			
			System.out.println("Enter your second interger");

				Scanner scan1 = new Scanner (System.in);
				int B = scan1.nextInt();
				
				
				while (B != 0) {
					
					r = A % B;
					A = B;
					B = r;

				}

				System.out.println("GCD: " + A);
		
			}
		
	}



