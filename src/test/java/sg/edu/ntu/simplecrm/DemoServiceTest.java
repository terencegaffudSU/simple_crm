package sg.edu.ntu.simplecrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoServiceTest {
    DemoService demoService;

    @BeforeEach
    public void init() {
        System.out.println("Before each test");
        demoService = new DemoService();
    }


    @Test
    public void testAdd() {
        // Setup

        // define expected result
        // int expectedResult = 8;

        // // Execute
        // int actualResult = demoService.add(3,5);

        // Assert 
        assertEquals(8, demoService.add(3,5), "3 + 5 should be 8.");
    }

    @Test 
    public void testSubtract() {
        // setup
        int expectedResult = 2;

        // execute
        int actualResult = demoService.subtract(5, 3);

        // Assert
        assertEquals(expectedResult, actualResult, "5 - 3 should be 2.");
    }

    @Test
    public void testMultiply() {
        // Setup
        int expectedResult = 15;
        
        // Execute
        int actualResult = demoService.multiply(3, 5);

        // Assert
        assertEquals(expectedResult, actualResult, "5 * 3 should be 15");
    }

    @Test
    public void testDivide() {
        // Given
        int expectedResult = 3;

        // When
        int actualResult = demoService.divide(15, 5);

        // Then
        assertEquals(expectedResult, actualResult, "15 / 5 should be 3");
        
        // Extra
        assertThrows(ArithmeticException.class, () -> demoService.divide(5, 0));
    }

    @Test
    public void testIsEven() {
        assertTrue(demoService.isEven(10021202));
        assertFalse(demoService.isEven(8293));
    }
}
