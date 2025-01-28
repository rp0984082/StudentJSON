import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

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

    // toString method to display student details
    @Override
    public String toString() {
        return "id: " + id + "\nname: " + name + "\nage: " + age + "\ngrade: " + grade + "\n";
    }

    // Main method to demonstrate serialization and deserialization
    public static void main(String[] args) {
        // Create an array of Student objects
        Student[] students = {
                new Student(1, "Alice Johnson", 20, "A"),
                new Student(2, "Bob Smith", 19, "B"),
                new Student(3, "Charlie Brown ", 21, "C"),
                new Student(4, "Daisy Miller", 22, "A")
        };

        // Serialize the students array to a JSON file
        try (FileWriter writer = new FileWriter("students.json")) {
            Gson gson = new Gson();
            gson.toJson(students, writer); // Convert the students array to JSON and write it to a file
            System.out.println("Students data has been written to students.json");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        // Deserialize the students array from the JSON file
        try (FileReader reader = new FileReader("students.json")) {
            Gson gson = new Gson();
            Student[] loadedStudents = gson.fromJson(reader, Student[].class); // Read and convert JSON back to Student objects

            // Print details of each loaded student
            System.out.println("\nStudents from JSON:");
            for (Student student : loadedStudents) {
                System.out.println(student);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
