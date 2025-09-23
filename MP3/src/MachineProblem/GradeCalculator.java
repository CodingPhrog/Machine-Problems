package MachineProblem;
import java.util.Scanner;
import java.io.PrintStream;

public class GradeCalculator 
{
	//CUSTOM WORDS
	static Scanner in = new Scanner(System.in);				//Establishes the Scanner to "in"
	static PrintStream out = new PrintStream(System.out);	//Changes System.out to "out"
	
	//INPUTS
	static class studInfo {								//Holds all the getStudInfo data
		String studNum, studName, section;
	}
	static studInfo getStudInfo ()						//Getting Student Information
	{
		studInfo info = new studInfo();
		
		out.println("{[----------GRADE CALCULATOR----------]}");
		out.println("-> Student Information");
		out.print("\tNumber:\t");
			info.studNum = in.nextLine();
		out.print("\tName:\t");
			info.studName = in.nextLine();
		out.print("\tSection:");
			info.section = in.nextLine();
		return info;
	}
	
	static class PrelimGrades {							//Holds all the getPrelimGrades data
	    double MP1, MP2, MP3, LQ1, LQ2, Prelim;
	}
	static PrelimGrades getPrelimGrades() {				//Input Prelim Scores
		PrelimGrades score = new PrelimGrades();
		
		out.println("-> Prelim Scores");
		//Machine Problems
		out.println("\t> Machine Problems(50)");
		out.print("\t   MP1:\t");
			score.MP1 = in.nextDouble();
		out.print("\t   MP2:\t");
			score.MP2 = in.nextDouble();
		out.print("\t   MP3:\t");
			score.MP3 = in.nextDouble();
		
		//Long Quizzes
		out.println("\t> Long Quizzes(50)");
		out.print("\t   LQ1:\t");
			score.LQ1 = in.nextDouble();
		out.print("\t   LQ2:\t");
			score.LQ2 = in.nextDouble();
		
		//Prelim Exam
		out.print("\t> Prelim Exam(60): ");
			score.Prelim = in.nextDouble();
		return score;
	}
	
	static class FinalGrades {							//Holds all the getFinalGrades data
		double MP4, MP5, MP6, LQ3, LQ4, Final;
	}
	static FinalGrades getFinalGrades() 				//Input Finals Scores
	{
		FinalGrades score = new FinalGrades();
		
		out.println("-> Final Scores");
		//Machine Problems
		out.println("\t> Machine Problems(50)");
		out.print("\t   MP4:\t");
			score.MP4 = in.nextDouble();
		out.print("\t   MP5:\t");
			score.MP5 = in.nextDouble();
		out.print("\t   MP6:\t");
			score.MP6 = in.nextDouble();
		
		//Long Quizzes
		out.println("\t> Long Quizzes(50)");
		out.print("\t   LQ3:\t");
			score.LQ3 = in.nextDouble();
		out.print("\t   LQ4:\t");
			score.LQ4 = in.nextDouble();
		
		//Prelim Exam
		out.print("\t> Final Exam(60): ");
			score.Final = in.nextDouble();
		return score;
	}
	
	//COMPUTING
	static double computePrelim(PrelimGrades ps) {		//Computes the Prelim Grade percentage
		double MP, LQ, PE;
		
		MP = ((ps.MP1 + ps.MP2 + ps.MP3) / 150) * 30;
		LQ	= ((ps.LQ1 + ps.LQ2) / 100) * 30;
		PE = (ps.Prelim / 60) * 40;
		
		return (MP + LQ + PE);
	}
	
	static double computeFinals(FinalGrades fs) {		//Computes the Final Grade percentage
		double MP, LQ, FE;
		
		MP = ((fs.MP4 + fs.MP5 + fs.MP6)/ 150) * 30;
		LQ = ((fs.LQ3 + fs.LQ4)/100) * 30;
		FE = (fs.Final / 60) * 40;
		
		return (MP + LQ + FE);
	}
	
	static double computeICS2602Grade(PrelimGrades ps, FinalGrades fs) {	//Computes the subject ICS2602 grade
		double PrelimGrade = computePrelim (ps);
		double FinalGrade = computeFinals (fs);
		
		return ((PrelimGrade / 100) * 50) + ((FinalGrade / 100) * 50);
	}
	
	//DISPLAY
	public static void main(String[] args) 
	{
		studInfo student = getStudInfo();									//Calls the getStudInfo Method and establish name for StudInfo
		
		PrelimGrades prelim = getPrelimGrades();							//Calls the getPrelimGrades Method
		double pGrade = computePrelim(prelim);								//Assigns data in PrelimScores class to the computePrelim Method
		
		FinalGrades finals = getFinalGrades();								//Calls the getPrelimGrades Method
		double fGrade = computeFinals(finals);								//Assigns data in FinalScores class to the computeFinals Method
		
		double ICS2602Grade = computeICS2602Grade(prelim, finals);			//Calls the computeICS2602Grade method
		
		out.println("{[--------STUDENT INFORMATION---------]}");
		out.println("Student Num:\t" + student.studNum);
		out.println("Student Name:\t" + student.studName.toUpperCase());
		out.println("Section:\t\t" + student.section);
		out.println("{[-----------COMPUTED GRADE-----------]}");
		out.printf("Prelim Grade:\t%.2f\n", pGrade);
		out.printf("Finals Grade:\t%.2f\n", fGrade);
		out.printf("ICS2602 Grade:\t%.2f\n", ICS2602Grade);
	}
}
