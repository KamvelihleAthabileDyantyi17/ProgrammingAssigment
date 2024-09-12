import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class MainTest {

    private Main mainApp;

    @BeforeEach
    public void setUp() {
        mainApp = new Main();
    }

    @Test
    public void testSaveStudent() {
        mainApp.captureStudent("S001", "Kv", 16, "Kv@example.com", "CAT");
        assertNotNull(mainApp.searchStudent("S001"), "Student should be saved and retrievable.");
    }

    @Test
    public void testSearchStudent() {
        mainApp.captureStudent("S002", "Vk", 16, "jane.doe@example.com", "Science");
        assertNotNull(mainApp.searchStudent("S002"), "Student should be found.");
    }

    @Test
    public void testDeleteStudent() {
        mainApp.captureStudent("S003", "Jim Doe", 16, "jim.doe@example.com", "History");
        mainApp.deleteStudent("S003");
        assertThrows(NoSuchElementException.class, () -> {
            mainApp.searchStudent("S003");
        }, "Student should be deleted and not found.");
    }

    @Test
    public void testStudentNotFound() {
        assertNull(mainApp.searchStudent("NonExistentID"), "Searching for a non-existent student should return null.");
    }

    @Test
    public void testStudentAgeValid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Main.captureStudent("S004", "Jack Doe", 15, "jack.doe@example.com", "English");
        });
        assertEquals("Age must be 16", exception.getMessage(), "Age validation should fail for invalid age.");
    }

    @Test
    public void testStudentAgeInvalid() {
        Main.captureStudent("S005", "Jill Doe", 16, "jill.doe@example.com", "Physics");
        assertDoesNotThrow(() -> {
            Main.captureStudent("S006", "Joe Doe", 16, "joe.doe@example.com", "Biology");
        }, "Age validation should pass for valid age.");
    }
}
