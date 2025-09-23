import java.util.Scanner;

public class Variables_Operations
{
	public static void main (String[] args)
	{ 
		//Variables
		Scanner console = new Scanner (System.in);
		float floatNum1;
		float floatNum2;
		
		//Entering the Values
		System.out.println("-------Floating Operations-------");
		System.out.print("Enter 1st floating point number: ");
		floatNum1 = console.nextFloat();
		System.out.print("Enter 2nd floating point number: ");
		floatNum2 = console.nextFloat();
		
		//Operations (Narrowing Casting)
		int SUM = (int) (floatNum1 + floatNum2);
		int DIFF = (int) (floatNum1 - floatNum2);
		int PROD = (int) (floatNum1 * floatNum2);
		int QUOTE = (int) (floatNum1 / floatNum2);
		
		//Printing results
		System.out.println("-------------Results-------------");
		System.out.println("Sum: " + SUM);
		System.out.println("Difference: " + DIFF);
		System.out.println("Product: " + PROD);
		System.out.println("Quotient: " + QUOTE);
		
	}
}