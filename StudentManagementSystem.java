import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static class Student {
        private int rollNo;
        private java.lang.String name;
        private double marks;

        public Student(int rollNo, java.lang.String name, double marks) {
            this.rollNo = rollNo;
            this.name = name;
            this.marks = marks;
        }

        public int getRollNo() {
            return rollNo;
        }

        public java.lang.String getName() {
            return name;
        }

        public double getMarks() {
            return marks;
        }

        public void display() {
            System.out.println(
                "Roll No: " + rollNo +
                " | Name: " + name +
                " | Marks: " + marks
            );
        }
    }

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        java.lang.String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(rollNo, name, marks));

        System.out.println("Student added successfully!");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student List ---");

        for (Student student : students) {
            student.display();
        }
    }

    public static void searchStudent() {
        System.out.print("Enter Roll Number to search: ");
        int rollNo = sc.nextInt();

        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                System.out.println("Student found:");
                student.display();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Roll Number to delete: ");
        int rollNo = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNo() == rollNo) {
                students.remove(i);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void main(java.lang.String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}