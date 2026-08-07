import java.util.*;
 
class Student {
    private int rollNo;
    private String name;
    private double marks;
 
    public Student(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    public int getRollNo() { return rollNo; }
    public String getName() { return name; }
    public double getMarks() { return marks; }
 
    public void display() {
        System.out.println(rollNo + "\t" + name + "\t" + marks);
    }
}
 
public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
 
    public static void addStudent() {
        try {
            System.out.print("Enter Roll No: ");
            int roll = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Marks: ");
            double marks = Double.parseDouble(sc.nextLine());
            students.add(new Student(roll, name, marks));
            System.out.println("Student added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid data.");
        }
    }
 
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        for (Student s : students) s.display();
    }
 
    public static void searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNo() == rollNo) {
                s.display();
                return;
            }
        }
        System.out.println("Student not found.");
    }
 
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1.Add  2.View  3.Search  4.Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> {
                    System.out.print("Enter Roll No to search: ");
                    searchStudent(Integer.parseInt(sc.nextLine()));
                }
                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
