import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    // Attributes of the Student class
    private int id;
    private String name;
    private int age;
    private String grade;

    // Constructor
    public Student(int id, String name, int age, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Main method to demonstrate serialization and deserialization
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] students = {
                new Student(1, "Alice Johnson", 20, "A"),
                new Student(2, "Bob Smith", 19, "B"),
                new Student(3, "Charlie Brown", 21, "C"),
                new Student(4, "Daisy Miller", 22, "A")
        };

        // Serialize the students array to a JSON file
        try (FileWriter writer = new FileWriter("students.json")) {
            Gson gson = new Gson();
            gson.toJson(students, writer); // Convert the students array to JSON and write it to a file
            System.out.println("Students written to students.json");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Deserialize the students array from the JSON file
        try (FileReader reader = new FileReader("students.json")) {
            Gson gson = new Gson();
            Student[] loadedStudents = gson.fromJson(reader, Student[].class); // Read and convert JSON back to Student objects

            // Print the entire array of students as a JSON string using Gson
            System.out.println("\nStudents");
            String jsonOutput = gson.toJson(loadedStudents); // Convert the loaded students array back to a JSON string
            System.out.println(jsonOutput);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
