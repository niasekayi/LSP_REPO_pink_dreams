package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

/**
 * JUnit 5 test cases for GradeCalculator.
 * 
 * Tests cover:
 * - average() calculation
 * - letterGrade() conversion
 * - isPassing() logic
 * - Boundary value conditions
 * - Exception handling for invalid scores
 */
@DisplayName("GradeCalculator Tests")
public class GradeCalculatorTest {

    private GradeCalculator calculator;

    /**
     * Set up test fixture before each test.
     */
    @BeforeEach
    public void setUp() {
        calculator = new GradeCalculator();
    }

    /**
     * Test average() calculation with normal scores.
     */
    @Test
    @DisplayName("Calculate average of three valid scores")
    public void testAverageCalculation() {
        double result = calculator.average(80, 90, 100);
        assertEquals(90.0, result, 0.001);
    }

    /**
     * Test letterGrade() conversion for grade A.
     */
    @Test
    @DisplayName("Convert average to letter grade A")
    public void testLetterGradeA() {
        String result = calculator.letterGrade(95.0);
        assertEquals("A", result);
    }

    /**
     * Test isPassing() returns true for passing average.
     */
    @Test
    @DisplayName("Determine if average is passing")
    public void testIsPassingTrue() {
        boolean result = calculator.isPassing(75.0);
        assertTrue(result);
    }

    /**
     * Boundary value test: average of exactly 60 (passing threshold).
     */
    @Test
    @DisplayName("Boundary test: average at passing threshold (60)")
    public void testBoundaryPassingThreshold() {
        double result = calculator.average(60, 60, 60);
        assertEquals(60.0, result);
        assertTrue(calculator.isPassing(result));
        assertEquals("D", calculator.letterGrade(result));
    }

    /**
     * Boundary value test: average of exactly 90 (A grade threshold).
     */
    @Test
    @DisplayName("Boundary test: average at A grade threshold (90)")
    public void testBoundaryAGradeThreshold() {
        double result = calculator.average(90, 90, 90);
        assertEquals(90.0, result);
        assertTrue(calculator.isPassing(result));
        assertEquals("A", calculator.letterGrade(result));
    }

    /**
     * Exception test: score below valid range (negative score).
     */
    @Test
    @DisplayName("Exception test: negative score throws IllegalArgumentException")
    public void testNegativeScoreThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-5, 80, 90);
        });
    }

    /**
     * Exception test: score above valid range (exceeds 100).
     */
    @Test
    @DisplayName("Exception test: score above 100 throws IllegalArgumentException")
    public void testScoreAbove100ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(80, 101, 90);
        });
    }

    /**
     * Additional test: letterGrade F for failing average.
     */
    @Test
    @DisplayName("Convert average to letter grade F")
    public void testLetterGradeF() {
        String result = calculator.letterGrade(45.0);
        assertEquals("F", result);
    }

    /**
     * Additional test: isPassing returns false for failing average.
     */
    @Test
    @DisplayName("Determine if average is failing")
    public void testIsPassingFalse() {
        boolean result = calculator.isPassing(45.0);
        assertFalse(result);
    }
}
