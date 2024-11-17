import java.util.Scanner;
import java.util.TreeMap;

class Student {
    String id;
    String name;
    String course;
    int year;

    public Student(String id, String name, String course, int year) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Course: " + course + ", Year: " + year;
    }
}

public class SchoolIDDetector {
    private TreeMap<String, Student> studentRecords;
    private Scanner scanner;

    public SchoolIDDetector() {
        studentRecords = new TreeMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nSchool ID Detector");
            System.out.println("1. Add Student Record");
            System.out.println("2. Remove Student Record");
            System.out.println("3. Search Student Record");
            System.out.println("4. Display Student Records");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addStudentRecord();
                    break;
                case 2:
                    removeStudentRecord();
                    break;
                case 3:
                    searchStudentRecord();
                    break;
                case 4:
                    displayStudentRecords();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void addStudentRecord() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(id, name, course, year);
        studentRecords.put(id, student);
        System.out.println("Student record added successfully!");
    }

    private void removeStudentRecord() {
        System.out.print("Enter the ID of the student to remove: ");
        String id = scanner.nextLine();
        if (studentRecords.remove(id) != null) {
            System.out.println("Student record removed successfully!");
        } else {
            System.out.println("No student found with the given ID.");
        }
    }

    private void searchStudentRecord() {
        System.out.print("Enter the ID of the student to search: ");
        String id = scanner.nextLine();
        Student student = studentRecords.get(id);
        if (student != null) {
            System.out.println("Student Record Found: " + student);
        } else {
            System.out.println("No student found with the given ID.");
        }
    }

    private void displayStudentRecords() {
        if (studentRecords.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            System.out.println("Student Records:");
            for (Student student : studentRecords.values()) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        SchoolIDDetector detector = new SchoolIDDetector();
        detector.run();
    }
}
