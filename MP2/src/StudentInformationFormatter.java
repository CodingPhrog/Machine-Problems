import java.util.Scanner;
public class StudentInformationFormatter
{
	public static void main(String[] args)
	{
		//ALL Variables (EnterDetails)
		Scanner enter = new Scanner(System.in);
		String fullName;
		String studentID;
		char gender;
		int age;
		float GPA;
		String mobileNum;
		//ALL Variables (MethodDemonstrations)
		
		//Input
		System.out.println("<{{-------------ENTER-DETAILS-------------}}>");
		System.out.print("Full Name:\t\t");
		fullName = enter.nextLine();
		System.out.print("Student ID:\t\t");
		studentID = enter.next();
		System.out.print("Gender(M/F):\t\t");
		gender = enter.next().charAt(0);
		System.out.print("Age:\t\t\t");
		age = enter.nextInt();
		System.out.print("GPA:\t\t\t");
		GPA = enter.nextFloat();
		System.out.print("Mobile#:\t\t\t");
		mobileNum = enter.next();
		
		//Print Input
		System.out.println("<{{-----STUDENT-REGISTRATION-COMPLETE!-----}}>");
		System.out.println("Full Name:\t\t".concat(fullName));
		System.out.println("Student ID:\t\t".concat(studentID));
		System.out.println("Gender:\t\t\t" + gender);
		System.out.println("Age:\t\t\t" + age);
		System.out.println("GPA:\t\t\t" + GPA);
		System.out.println("Mobile(#):\t\t" + mobileNum);
		
		//Output Method Demonstrations
		System.out.println("<{{---------METHOD-DEMONSTRATIONS---------}}>");
		String fullNameRes;
		String studentIDYear;;
		fullNameRes = fullName.toUpperCase(); 
		studentIDYear = studentID.substring(0, 4);
		String genderRes = "" + gender;
		genderRes = genderRes.substring(0);
		String num = "First Last"; 									
		int inc = 0;
		String fullNameSplit[] = fullName.split(" ");
		String numSplit[] = num.split(" ");
		
		System.out.println("Uppercase Name:\t\t" + fullNameRes); 	//Full Name
		
		System.out.println("Year of Entry:\t\t" + studentIDYear); 	//Year
		
		if (studentID.equals("2025-002321") || studentID.equals("2025002321"))	{ 					//ID Match
			System.out.println("ID Match:\t\ttrue");
		} else {
			System.out.println("ID Match:\t\tfalse");
		}
		
		if (genderRes.equalsIgnoreCase("F")) { 						//Gender Match
			System.out.println("Gender Match:\t\ttrue");
		} else {
			System.out.println("Gender Match:\t\tfalse");
		}
		
		for (String f:fullNameSplit) {
			System.out.println(numSplit[inc] + " Name:\t\t" + f);	//First and LastName
			inc = inc + 1;
		}
		
		System.out.println("Name w/ Underscore:\t" + fullName.replace(" ", "_")); 	//Underscore
		
		System.out.println("Name w/ ID:\t\t" + fullName.concat(studentID)); 		//Name + ID
		
		System.out.println("1st Digit of (#):\t" + mobileNum.substring(0, 1)); 		//MobileFirstDigit
		
		System.out.println("Name Length:\t\t" + fullName.length()); 				//Name Length 
	}
}