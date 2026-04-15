package MP2;

public class RegularStudent extends Student {
    public RegularStudent(String name, int studentID, String course, int yearLevel, float tuitionFee, double[] grades) {
        super(name, studentID, course, yearLevel, tuitionFee, grades);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("| Status: Regular | Final Payable Tuition " + calculateTuition());
    }

    public float calculateTuition() {
        payableAmount = tuitionFee;
        return payableAmount;
    }
}