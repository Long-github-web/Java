import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String className;
    private double gpa;

    public Student(String id, String firstName, String lastName, String birthDate, String className, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.className = className;
        this.gpa = gpa;
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFullName() { return firstName + " " + lastName; }
    public String getBirthDate() { return birthDate; }
    public String getClassName() { return className; }
    public double getGpa() { return gpa; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public void setClassName(String className) { this.className = className; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + getFullName() + ", Birth Date: " + birthDate +
                ", Class: " + className + ", GPA: " + gpa;
    }
}

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n==== STUDENT MANAGEMENT ====");
            System.out.println("1. Add Students");
            System.out.println("2. Search Students by Last Name");
            System.out.println("3. Search and Update Student by Full Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addStudents();
                case 2 -> searchByLastName();
                case 3 -> searchAndUpdateStudent();
                case 4 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void addStudents() {
        System.out.print("Enter number of students to add: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Birth Date (yyyy-mm-dd): ");
            String birthDate = scanner.nextLine();
            System.out.print("Class: ");
            String className = scanner.nextLine();
            System.out.print("GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            students.add(new Student(id, firstName, lastName, birthDate, className, gpa));
        }
        System.out.println("Students added successfully.");
    }

    private static void searchByLastName() {
        System.out.print("Enter last name to search: ");
        String lastName = scanner.nextLine();
        boolean found = false;
        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with last name: " + lastName);
        }
    }

    private static void searchAndUpdateStudent() {
        System.out.print("Enter full name to search: ");
        String fullName = scanner.nextLine();
        for (Student student : students) {
            if (student.getFullName().equalsIgnoreCase(fullName)) {
                System.out.println("Student found: " + student);
                System.out.println("Enter new details:");
                System.out.print("New First Name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("New Last Name: ");
                String newLastName = scanner.nextLine();
                System.out.print("New Birth Date (yyyy-mm-dd): ");
                String newBirthDate = scanner.nextLine();
                System.out.print("New Class: ");
                String newClassName = scanner.nextLine();
                System.out.print("New GPA: ");
                double newGpa = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                student.setBirthDate(newBirthDate);
                student.setClassName(newClassName);
                student.setGpa(newGpa);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("No student found with name: " + fullName);
    }
}