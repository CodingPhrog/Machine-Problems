package MP2;

import java.io.PrintStream;
import java.util.Scanner;

public class TestMain {
    static PrintStream out = System.out;
    static Scanner in = new Scanner(System.in);

    @FunctionalInterface
    interface ProcessingComplete {
        void msg();
    }

    // Exceptions
    static class InvalidYearLevelException extends Exception {
        public InvalidYearLevelException (String msg) {
    		super(msg);
    	}
    }
    static class InvalidGradeException extends Exception {
        public InvalidGradeException (String msg) {
    		super(msg);
    	}
    }
    static class InvalidDiscountException extends Exception {
        public InvalidDiscountException (String msg) {
    		super(msg);
    	}
    }
    
    // Main Method
    public static void main(String[] args) {
    	// Number of Students Input
        int numStud = 0;
		try {
			out.print("+- Enter Number of Students = ");
			String numStudStr = in.nextLine();
			numStud = Integer.parseInt(numStudStr);

		} catch (NumberFormatException e) {
			out.println("| ! Invalid input. Defaulting to 1 student.");
			numStud = 1;
		} finally {
			assert (numStud > 0) : "| ! Number of students must be greater than 0";
		}
		
		Student[] Class = new Student[numStud];
		
        // Class Iteration
        for (int index = 0; index < Class.length; index++) {
            double[] grades = new double[3];
            
            // Error Repeater
            repeat:
            while (true) {
            out.println("| >> Processing Entry #" + (index + 1));
            
            // Name
            out.printf("| Enter Student[%d] Name: ", index + 1);
            String name = in.nextLine().trim();

            // Student ID
            out.print("| Enter StudentID: ");
            int studentID = in.nextInt();
            in.nextLine();

            // Course
            out.print("| Enter Course: ");
            String course = in.nextLine().trim();

            // Year Level
            int yearLevel = 0;
            boolean validYear = false;
            while (!validYear) {
                try {
                    out.print("| Year Level (1:FRESHMAN, 2:SOPHOMORE, 3:JUNIOR, 4:SENIOR): ");
                    String yearStr = in.nextLine();
                    yearLevel = Integer.parseInt(yearStr);
                    if (yearLevel < 1 || yearLevel > 4) {
                        throw new InvalidYearLevelException("Index " + yearLevel + " out of bounds for length 4.");
                    }
                    validYear = true;
                } catch (InvalidYearLevelException e) {
                    out.println("| ! System Error: " + e.getMessage() + " Please re-enter.");
                } catch (NumberFormatException e) {
                    out.println("| ! System Error: Invalid input. Please enter a number.");
                }
            }
            
            // Base Tuition Fee Input
            float tuitionFee = 0;
            boolean validTuition = false;
            while (!validTuition) {
                try {
                    out.print("| Base Tuition Fee: ");
                    String tuitionStr = in.nextLine();
                    tuitionFee = Float.parseFloat(tuitionStr); 
                    validTuition = true; 
                } catch (NumberFormatException e) {
                    out.println("| ! System Error: " + e.getMessage() + ". Please re-enter this student.");
                    continue repeat;
                }
            }
            
            // Grade Input
            for (int g = 0; g < grades.length; g++) {
                boolean valid = false;
                while (!valid) {
                    try {
                        out.printf("| > Grade [%d]: ", g + 1);
                        String gradeStr = in.nextLine();
                        double grade = Double.valueOf(gradeStr); 
                        if (grade < 0 || grade > 100) {
                            throw new InvalidGradeException("Grade must be between 0 and 100.");
                        }
                        grades[g] = grade;
                        valid = true; 
                    } catch (InvalidGradeException e) {
                        out.println("| ! System Error: " + e.getMessage() + ". Please re-enter.");
                        continue repeat;
                    } catch (NumberFormatException e) {
                    	out.println("| ! System Error: " + e.getMessage() + ". Please re-enter.");
                        continue repeat;
                    }
                }
            }
            
            // Scholar Conditional
            out.print("| Enroll as Scholar? (Y/N): ");
            String scholarDecide = in.nextLine();
            if (scholarDecide.equalsIgnoreCase("y")) {
            	ScholarStudent scholar = new ScholarStudent(name, studentID, course, yearLevel, tuitionFee, grades);
            	boolean validDiscount = false;
            	while (!validDiscount) {
            	    try {
            	        out.print("| Scholarship Discount %: ");
            	        String discountStr = in.next();              
            	        float discountRate = Float.parseFloat(discountStr); 
            	        if (discountRate < 0 || discountRate >= 100) {
            	            throw new InvalidDiscountException("Scholarship discount must be between 0 and 100.");
            	        }
            	        scholar.applyScholarship(discountRate);      
            	        validDiscount = true;
            	    } catch (InvalidDiscountException e) {
            	        out.println("| ! System Error: " + e.getMessage() + " Please re-enter.");
            	        continue repeat;
            	}
                
                Class[index] = scholar;
                } 
            } else {
            	// Regular
                Class[index] = new RegularStudent(name, studentID, course, yearLevel, tuitionFee, grades);
            }
            
            // Divider
            out.println("+----------");
            break repeat;
        }
    }
        
        // Printing Information
        out.println("\n+- OFFICIAL ENROLLMENT REPORT ->");
        for (Student s : Class) {
            s.displayInfo();
            out.println("+----------");
        }

        // Completion Confirmation Message
        ProcessingComplete pc = () -> out.println("\nProcessing Complete! Thank you for using our system!");
        pc.msg();
        }
    }
