import java.util.*;

public class Main {
    // Scanner to read user input
    private static Scanner scanner = new Scanner(System.in);
    // Map to store student records with Student ID as the key
    private static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        // Main loop to display the initial prompt and handle menu launching
        while (true) {
            System.out.println("Student Management Application");
            System.out.println("****************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String choice = scanner.nextLine();
            if (!choice.equals("1")) {
                break; // Exit the application if user enters anything other than "1"
            }
            displayMenu(); // Show the menu
        }
    }

    // Method to display menu and handle user choices
    private static void displayMenu() {
        while (true) {
            System.out.println("Menu Items:");
            System.out.println("1) Capture a new student");
            System.out.println("2) Search for a student");
            System.out.println("3) Delete a student");
            System.out.println("4) Print Student report");
            System.out.println("5) Exit Application");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    captureStudent("S001", "John Doe", 16, "john.doe@example.com", "Mathematics"); // Call method to capture new student details
                    break;
                case "2":
                    searchStudent("NonExistentID"); // Call method to search for a student
                    break;
                case "3":
                    deleteStudent("S003"); // Call method to delete a student
                    break;
                case "4":
                    printStudentReport(); // Call method to print the student report
                    break;
                case "5":
                    System.out.println("Exiting application.");
                    System.exit(0); // Exit the application
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    // Method to capture details of a new student
    public static void captureStudent(String s001, String johnDoe, int i, String mail, String mathematics) {
        System.out.println("Enter Student ID:");
        String id = scanner.nextLine();

        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();

        int age;
        // Loop until a valid age is entered
        while (true) {
            System.out.println("Enter Student Age (must be 16 or older):");
            age = Integer.parseInt(scanner.nextLine());
            if (age >= 16) { // Change the condition to accept age equal to or greater than 16
                break; // Exit loop if age is valid
            } else {
                System.out.println("You have entered an incorrect student age. Please enter 16 or older.");
            }
        }


        System.out.println("Enter Student Email:");
        String email = scanner.nextLine();

        System.out.println("Enter Student Course:");
        String course = scanner.nextLine();

        // Create a new Student object and store it in the map
        Student student = new Student(id, name, age, email, course);
        students.put(id, student);
        System.out.println("Student details have been successfully captured.");
    }

    // Method to search for a student by ID
    public static Object searchStudent(String nonExistentID) {
        System.out.println("Enter Student ID to search:");
        String id = scanner.nextLine();
        Student student = students.get(id);
        if (student == null) {
            System.out.println("Student ID not found."); // ID does not exist
        } else {
            System.out.println(student); // Print student details
        }
        return null;
    }

    // Method to delete a student by ID
    public static void deleteStudent(String s003) {
        System.out.println("Enter Student ID to be deleted:");
        String id = scanner.nextLine();
        if (students.containsKey(id)) {
            System.out.println("Are you sure you want to delete this student ID? Type 'Yes' to delete.");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("Yes")) {
                students.remove(id); // Remove student from the map
                System.out.println("Student ID deleted.");
            } else {
                System.out.println("Deletion canceled.");
            }
        } else {
            System.out.println("Student ID not found."); // ID does not exist
        }
    }

    // Method to print a report of all students
    private static void printStudentReport() {
        if (students.isEmpty()) {
            System.out.println("No student records available."); // No students in the map
        } else {
            System.out.println("Student Report:");
            // Print details of each student in the map
            for (Student student : students.values()) {
                System.out.println(student);
            }
        }
    }

    // Inner class to represent a student
    static class Student {
        String id;
        String name;
        int age;
        String email;
        String course;

        // Constructor to initialize a student object
        Student(String id, String name, int age, String email, String course) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
            this.course = course;
        }

        // Method to return a string representation of the student
        @Override
        public String toString() {
            return "Student ID: " + id + "\n" +
                    "Name: " + name + "\n" +
                    "Age: " + age + "\n" +
                    "Email: " + email + "\n" +
                    "Course: " + course + "\n";
        }
    }
}
