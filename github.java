import java.util.Scanner;

// Class to represent a Student
class Student {
    private String name;
    private int age;
    private String grade;
    
    // Constructor
    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }
    //testing a new line 
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

// Main class for the Student Management System
public class StudentManagementSystem {

    private static Student[] students = new Student[5]; // Array to hold up to 5 students
    private static int studentCount = 0; // Counter for number of students

    // Method to add a student
    public static void addStudent(String name, int age, String grade) {
        if (studentCount < students.length) {
            students[studentCount] = new Student(name, age, grade);
            studentCount++;
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Cannot add more students. The system is full.");
        }
    }

    // Method to display all students
    public static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println("\nStudent " + (i + 1) + ":");
                students[i].displayStudentInfo();
            }
        }
    }

    // Method to find and display a student by name
    public static void findStudentByName(String name) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                System.out.println("\nStudent found:");
                students[i].displayStudentInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with the name " + name + " not found.");
        }
    }

    // Method to delete a student by name
    public static void deleteStudentByName(String name) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(name)) {
                // Shift all students after this one to the left
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null; // Clear the last student
                studentCount--;
                System.out.println("Student " + name + " has been deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with the name " + name + " not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Find Student by Name");
            System.out.println("4. Delete Student by Name");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();
                    addStudent(name, age, grade);
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter student's name to search: ");
                    String searchName = scanner.nextLine();
                    findStudentByName(searchName);
                    break;
                case 4:
                    System.out.print("Enter student's name to delete: ");
                    String deleteName = scanner.nextLine();
                    deleteStudentByName(deleteName);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
