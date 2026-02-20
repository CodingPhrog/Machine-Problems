package Valera_MP;

public class Student {
	private String name;
	private double[] grades;
	
	public Student (String name, double[] grades) {
		this.name = name;
		this.grades = grades;
	}
	
	public double calculateAverage () {
		double average = 0;
		int counter = 0;
		for (double g : grades) {
			average += g;
			counter++;
		}
		return average / counter;
	}
	
	public void displayInfo() {
		System.out.println("| Student Name: " + name);
		System.out.println("| Grades: ");
		for (double g : grades) {
			System.out.println("| > " + g);
		}
		System.out.printf("| Average: %.2f %n", this.calculateAverage());
	}
}
