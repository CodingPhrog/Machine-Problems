package Valera_MP;

import java.io.PrintStream;
import java.util.Scanner;

public class TestMain {
	// Shortcuts
	static PrintStream out = new PrintStream (System.out);
	static Scanner in = new Scanner (System.in);
	
	// Main
	public static void main (String args[]) {
		// Variables
		String name;
		double grade;
		
		//Enter number of students
		out.print("+- Enter Number of Students =  ");
		int numStud = in.nextInt();
		
		// Initialize Arrays
		Student[] Class = new Student [numStud];
		
		// Enter Names and grade
		for (int index = 0, count = 1; index < Class.length; index++, count++) {
			double[] grades = new double[3];
			
			out.printf("| Enter Student[%d]: ", count);
			name = in.next();
			
			// Iterating Input Grade
			for (int g = 0, gcount = 1; g < grades.length; g++, gcount++) {
				out.printf("| > Grade [%d]: ", gcount);
				grade = in.nextDouble();
				grades[g] = grade;
			}
			
			// Condition
			if (index == 0) Class[index] = new HonorStudent(name, grades);
			else Class[index] = new Student(name, grades);
			out.println("+----------");
		}
		
		// Displaying Information
		out.println("\n+- STUDENT RECORDS ->");
		for (int count = 0; count < Class.length; count++) {
			Class[count].displayInfo();
			out.println("+----------");
		}
		
	}
}
