import java.util.*;
import java.io.*;

public class ICS2602 {
	//Custom Words
	static Scanner in = new Scanner (System.in);
	static PrintStream out = new PrintStream (System.out);
	
	static class dataBank { //Houses all data
		int ID, daysWorked, ratePerDay, daysAbsent; //first part
		int SSS, pagIBIG; //part of deductions
		int grossPay, totalDeductions, netPay; //Computations
	}
	
	public static void main(String[] args) {
		dataBank data = new dataBank();
		
		out.println("<{[----------SALARY COMPUTER----------]}>");
		out.print("Enter your Employee ID:\t");
		data.ID = in.nextInt();
		
		if (data.ID == 1011) {
			out.println("   > Welcome Ma. Angela I. Valera");
			out.print("Number of days worked:\t");
			data.daysWorked = in.nextInt();
			out.print("Rate per Day:\t\t");
			data.ratePerDay = in.nextInt();
			out.print("Number of days absent:\t");
			data.daysAbsent = in.nextInt();
			
			//IF STATEMENT
			if (data.daysAbsent > 3) 
				out.println("*NOTICE: file a leave*\n");
			else 
				out.println("[Continuing to next part...]\n");
			
			//Computations
			data.grossPay = data.daysWorked * data.ratePerDay;
			//Deductions
			data.SSS = (int) (data.grossPay * 0.15);
			data.pagIBIG = (int) (data.grossPay * 0.2);
			data.daysAbsent *= data.ratePerDay;
			//NetPay
			data.totalDeductions = data.SSS + data.pagIBIG + data.daysAbsent;
			data.netPay = data.grossPay - data.totalDeductions;
			
			out.println("<{[-------------RESULTS-------------]}>");
			out.println("Employee Name:\tMa. Angela I. Valera");
			//role
			out.print("Role:\t\t");
			if (data.grossPay >= 50000) {
				out.println("Manager");
			} else if (data.grossPay >= 30000) {
				out.println("Supervisor");
			} else
				out.println("Staff");
			out.println("Gross Pay:\t" + data.grossPay + "PHP");
			out.println("Deductions:\t" + data.totalDeductions + "PHP");
			out.println("   > SSS:\t" + data.SSS + "PHP");
			out.println("   > Pag-IBIG:\t" + data.pagIBIG + "PHP");
			out.println("   > Absences:\t" + data.daysAbsent + "PHP");
			out.println("Net Pay:\t" + data.netPay + "PHP");
		} else 
			out.println("ERROR: INVALID EMPLOYEE ID");
	}

}
