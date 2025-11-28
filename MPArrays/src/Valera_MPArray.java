import java.util.*;
import java.io.*;

public class Valera_MPArray {
	// Assigning object names for printing and input
	static PrintStream out = new PrintStream (System.out);
	static Scanner in = new Scanner (System.in);
	
	// Holds every array to be used
	static class ArrayBank {
		// Student Customer Section
		String[] studentNames = new String[5];
		
		// Menu Section
		String[] menuCategs = {"Breakfast", "Lunch", "Dinner"};
		String[][] menuFoods = {
				{"Pancakes", "Omelette", "Coffee", "Toast", "Juice"},
				{"Burger", "Pasta", "Salad", "Rice Meal", "Soda"},
				{"Steak", "Fish", "Soup", "Fried Rice", "Tea"}};
		
		int[][] menuFoodPrices = {
				{50,45,30,25,35}, 
				{80,70,60,75,25},
				{150,120,60,70,30}};
		
		// Student Order Section
		int[][] orderPrice = new int[5][];
		String[][] orderName = new String[5][];
		
		// Summary Report Section
		int[] totalBill = new int[5];
	}
	
	// Main Method
	public static void main(String[] args) {
		ArrayBank data = new ArrayBank();
		
		// Inputting the Names of 5 Students
		out.println("+== ENTER NAMES ======>");
		out.println("| Input 5 students who will order!");
		for (int rowIndex = 0, studentNum = 1; rowIndex < data.studentNames.length; rowIndex++, studentNum++) {
			out.printf("| > Student %d: ", studentNum);
			data.studentNames[rowIndex] = in.next();
		}
		out.println("| Names Recorded! Moving on...");
		out.println("+====================>\n");
		
		// Menu Printing
		out.println("+== MENU ========================================================================================>");
		out.printf("| %-13s | %-13s | %-13s | %-13s | %-13s | %-13s%n", "Category", "Index [0]", "Index [1]", "Index [2]", "Index [3]", "Index [4]");
		for (int rowIndex = 0; rowIndex < data.menuCategs.length; rowIndex++) {
			out.printf("| [%d]%-11s", rowIndex, data.menuCategs[rowIndex]);
			for (int columnIndex = 0; columnIndex < data.menuFoods[rowIndex].length; columnIndex++) {
				out.printf("| %-10s%3d ", data.menuFoods[rowIndex][columnIndex], data.menuFoodPrices[rowIndex][columnIndex]);
			}
			out.println("");
		}
		out.println("+================================================================================================>\n");
		
		// Student Ordering
		out.println("+== FOOD ORDER ======>");
		for (int rowIndex = 0; rowIndex < data.studentNames.length; rowIndex++) {
			// How many will the student order?
			out.printf("| > Hi %s! How many will you order? ", data.studentNames[rowIndex]);
			int howMany = in.nextInt();
			data.orderPrice[rowIndex] = new int[howMany];
			data.orderName[rowIndex] = new String[howMany];
			
			// Enter food index
			
			for (int columnIndex = 0; columnIndex < data.orderPrice[rowIndex].length; columnIndex++) {
				out.print("| | Category Index: ");
				int categIndex = in.nextInt(); //rowindex
				out.print("| | Item Index: ");
				int itemIndex = in.nextInt(); //columnIndex
				data.orderPrice[rowIndex][columnIndex] = data.menuFoodPrices[categIndex][itemIndex];
				data.orderName[rowIndex][columnIndex] = data.menuFoods[categIndex][itemIndex];
			}
			if (rowIndex < data.studentNames.length - 1) out.println("| ");
		}
		out.println("+==============>\n");
		
		// Summary Report
		out.println("+== SUMMARY REPORT ======>");
		for (int rowIndex = 0; rowIndex < data.studentNames.length; rowIndex++) {
			int sum = 0;
			out.printf("| > Student: %s%n", data.studentNames[rowIndex]);
			
			// Printing Ordered List
			out.print("| | > Orders: ");
			for (int columnIndex = 0; columnIndex < data.orderName[rowIndex].length; columnIndex++) {
				out.print(data.orderName[rowIndex][columnIndex]);
				if (columnIndex < data.orderName[rowIndex].length - 1) out.print(", ");
			}
			out.print("\n");
			
			// Summation of the Order
			for (int op : data.orderPrice[rowIndex]) sum += op;
			
			// Printing Total Bill
			out.printf("| | > Total Bill: %s%n", sum);
			data.totalBill[rowIndex] = sum;
			
			out.println("| ");
		}
		
		// Highest Spender
		int highestSpender = 0;
		String spenderName = "";
		
		for (int rowIndex = 0; rowIndex < data.totalBill.length; rowIndex++) {
			if (data.totalBill[rowIndex] > highestSpender) {
				highestSpender = data.totalBill[rowIndex];
				spenderName = data.studentNames[rowIndex];
			}
		}
		
		out.printf("| > Highest Spender: %s (%d)%n", spenderName, highestSpender);
		out.println("+==============>\n");
		
		// Thank you Message
		out.println("Thank you for using the Cafeteria Order System <3");
	}
}
