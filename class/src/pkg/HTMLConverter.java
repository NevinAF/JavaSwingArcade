package pkg;

import java.util.Scanner;

/**
 * 
 * @Author Nevin Foster
 * 
 * @Class CSC110: 11384
 * @Title Final, HTML project
 * @Description made to test skills as a programmer
 */
public class HTMLConverter
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in); //the way to get information
		
		try
		{
			// ask for info
		System.out.println("Amount of the Loan (Any Currency):");
		double principal = scanner.nextDouble();
		
		System.out.println("Annual Percentage Rate of Interest:");
		double interest = scanner.nextDouble() /100 /12;
		
		System.out.println("Repayment Period in Years:");
		double payments = scanner.nextDouble() *12;
			// check for bad info
		if(interest <= 0 || payments <= 0 || principal < 0) throw new RuntimeException();
			//math
		double x = Math.pow(1 + interest, payments);
		double monthly = (principal * x * interest)/(x-1);
		
		//Output the data
		System.out.println("Info!");
		System.out.println("   Your Monthly Payment will be: " + monthly);
		System.out.println("   Your Total Payment will be: " + monthly * payments);
		System.out.println("   Your Total Interest Payments will be: " + ((monthly * payments) - principal));

		} //Handle bad info
		catch (java.util.InputMismatchException e)
		{
			System.out.println("You have entered Bad info. Sorry.");
		}
		catch (RuntimeException e)
		{
			System.out.println("You have entered Bad info. Sorry.");
		}
		
		scanner.close(); //close the scanner
	}
}
