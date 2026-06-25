package DSAExercise.EmployeeManagement;

public class EmployeeManagement {
    static class Employee {
        int id;
        String name;
        Employee(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Employee[] emp = new Employee[5];
        int count = 0;
        emp[count++] = new Employee(101, "Abhishek");
        emp[count++] = new Employee(102, "Rahul");
        emp[count++] = new Employee(103, "Amit");

        System.out.println("Employees:");
        for(int i = 0; i < count; i++) {
            System.out.println(emp[i].id + " " + emp[i].name);
        }
        int searchId = 102;
        for(int i = 0; i < count; i++) {
            if(emp[i].id == searchId) {
                System.out.println("Found: " + emp[i].name);
            }
        }
        int deleteId = 102;
        for(int i = 0; i < count; i++) {
            if(emp[i].id == deleteId) {
                for(int j = i; j < count - 1; j++) {
                    emp[j] = emp[j + 1];
                }
                count--;
                break;
            }
        }
        System.out.println("After Delete:");
        for(int i = 0; i < count; i++) {
            System.out.println(emp[i].id + " " + emp[i].name);
        }
    }
}