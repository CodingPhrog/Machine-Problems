import java.util.*;
import java.io.*;

public class Valera_MaAngela_ATMLoop {
	
	//Shortening input and output syntax
	static Scanner in = new Scanner (System.in);
	static PrintStream out = new PrintStream (System.out);
	
	// Holds all the data and initializes the variables
	static class databank {
		int loginAttempts = 3, loginPin;
		int menuOption, transactionLimit;
		double balance = 0, deposit, withdraw;
	}
	
	// MAIN METHOD
	public static void main (String[] args) {
		
		// calls the databank class
		databank data = new databank();
		
		// Login System
		out.println("+=====================+");
		out.println("|        LOGIN        |");
		out.println("+============+========+");
		while (data.loginAttempts >= 0) {
			out.print("| Enter Pin: ");
			data.loginPin = in.nextInt();
			
			// IF Login Successful
			if (data.loginPin == 1234) {
				out.println("|> Login Succesful! Welcome User\n*\n");
				break;
			}
			
			// IF Login Unsuccessful
			if (data.loginAttempts < 2) {
				out.println("|!! All 3 login attempts has been used! Try again later...");
				System.exit(0);
			} else {
				data.loginAttempts--;
				out.println("|> INCORRECT, Try again! Attempts left " + data.loginAttempts);
			}
		}
		
		// Main Menu Options
		out.println("+=====================+");
		out.println("| WELCOME TO THE ATM! |");
		out.println("+============+========+");
		out.printf("| %-10s | %-5s |%n", "ACTION", "OPTION");
		out.println("+------------+--------+");
		out.printf("| %-10s | %-6d |%n", "Balance", 1);
		out.printf("| %-10s | %-6d |%n", "Deposit", 2);
		out.printf("| %-10s | %-6d |%n", "Withdraw", 3);
		out.printf("| %-10s | %-6d |%n", "Exit", 4);
		out.println("+---------------------+");
		
		//Choosing Option
		do {
			out.print("| Choose Option: ");
			data.menuOption = in.nextInt();
			
			// Check Balance
			if (data.menuOption == 1)
				out.printf("|> Your balance is: %.2f%n|%n", data.balance);
			
			// Deposit
			for (; data.menuOption == 2 && data.transactionLimit <= 4;) {
				out.print("| | Enter Deposit amount: ");
				data.deposit = in.nextDouble();
				
				// IF Invalid
				if (data.deposit <= 0) {
					out.println("| |> Invalid amount. Try again.");
					continue;
				}
				
				// IF Successful
				data.balance += data.deposit;
				out.printf("| |> Deposit successfully! New Balance: %.2f%n|%n", data.balance);
				data.transactionLimit++;
				break;
				}
			
			// Withdraw
			for (; data.menuOption == 3 && data.transactionLimit <= 4;) {
				out.print("| | Enter Withdraw amount: ");
				data.withdraw = in.nextDouble();
				
				// IF Invalid
				if (data.withdraw <= 0) {
					out.println("| |> Invalid amount. Try again.");
					continue;
				}
				
				// IF Successful
				data.balance -= data.withdraw;
				out.printf("| |> Withdraw successfully! New Balance: %.2f%n|%n", data.balance);
				data.transactionLimit++;
				break;
				}
			
			// Entered none of the options
			if (data.menuOption > 4 || data.menuOption < 1)
				out.println("| Enter valid option number!\n|");
		} while (data.menuOption != 4 && data.transactionLimit <= 4);
		
		out.println("*");
		
		if (data.transactionLimit == 5) {
			out.println("<|  All 5 Transaction attempts has been used  |>");
		} else {
			out.println("<|  Thank you for using the ATM!  |>");
		}
		
	}
}
