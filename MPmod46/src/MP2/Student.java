package MP2;

public abstract class Student {
    private String name;
    private int yearLevel;
    private double[] grades;
    private final int studentID;
    private String course;
    protected float tuitionFee;
    protected float payableAmount;

    enum YearLevel { FRESHMAN, SOPHOMORE, JUNIOR, SENIOR }

    public Student(String name, int studentID, String course, int yearLevel, float tuitionFee, double[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.course = course;
        this.yearLevel = yearLevel;
        this.tuitionFee = tuitionFee;
        this.grades = grades;
    }

    public double calculateAverage() {
        double sum = 0;
        for (double g : grades) sum += g;
        return sum / grades.length;
    }

    public void displayInfo() {
        System.out.println("| Student Name: " + name);
        System.out.println("| StudentID: " + studentID);
        System.out.println("| Course: " + course );
        System.out.print("| Year Level: ");
        switch (yearLevel) {
        	case 1: System.out.println(YearLevel.FRESHMAN); break;
            case 2: System.out.println(YearLevel.SOPHOMORE); break;
            case 3: System.out.println(YearLevel.JUNIOR); break;
            case 4: System.out.println(YearLevel.SENIOR); break;
            default: System.out.println("System Error: Index 4 out of bounds for length 4. Please re-enter this student.");
        }
        System.out.printf("| Average Grade: %.2f %n", calculateAverage());
    }

    public abstract float calculateTuition();
}