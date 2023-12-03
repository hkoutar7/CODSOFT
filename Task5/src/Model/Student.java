package Model;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String major;
    private float totalGrade;

    public Student() {
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.major = "";
        this.totalGrade = 0.0F;
    }

    public Student(String firstName, String lastName, String major, float totalGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.totalGrade = totalGrade;
    }

    public Student(int id,String firstName, String lastName, String major, float totalGrade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.major = major;
        this.totalGrade = totalGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public float getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(float totalGrade) {
        this.totalGrade = totalGrade;
    }

    @Override
    public String toString() {
        return "Student Informations " +
                "id=" + id +
                ", firstName = " + firstName + '\'' +
                ", lastName = " + lastName + '\'' +
                ", major = " + major + '\'' +
                ", totalGrade = " + totalGrade;
    }
}
