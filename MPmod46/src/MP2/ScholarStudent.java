package MP2;

public class ScholarStudent extends Student implements Discountable {
    private float discountRate;

    public ScholarStudent(String name, int studentID, String course, int yearLevel, float tuitionFee, double[] grades) {
        super(name, studentID, course, yearLevel, tuitionFee, grades);
    }

    public void applyScholarship(double percentage) {
        this.discountRate = (float) percentage;
    }

    public float calculateTuition() {
        payableAmount = tuitionFee - (tuitionFee * (discountRate / 100));
        return payableAmount;
    }
    
    public void displayInfo() {
        super.displayInfo();
        System.out.println("| Status: Scholar | Final Payable Tuition " + calculateTuition());
    }
}