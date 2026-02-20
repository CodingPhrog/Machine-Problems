package Valera_MP;

public class HonorStudent extends Student{
	
	public HonorStudent(String name, double[] grades) {
		super(name, grades);
	}

	public void displayInfo() {
		super.displayInfo();
		System.out.println("| ! Award Details: You have an award for being great :)");
	}
}
