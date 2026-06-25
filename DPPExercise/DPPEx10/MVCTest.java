package DPPEx10;

public class MVCTest {
    public static void main(String[] args) {
        Student model = new Student("Abhishek", 101, "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Rahul");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}