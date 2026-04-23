package org.howard.edu.lsp.finalexam.question3;

/**
 * GradeCalculator computes grade averages and letter grades.
 */
public class GradeCalculator {

    /**
     * Calculates the average of three scores.
     *
     * @param score1 the first score
     * @param score2 the second score
     * @param score3 the third score
     * @return the average of the three scores
     * @throws IllegalArgumentException if any score is outside 0-100 range
     */
    public double average(int score1, int score2, int score3) {
        validateScore(score1);
        validateScore(score2);
        validateScore(score3);
        return (score1 + score2 + score3) / 3.0;
    }

    /**
     * Converts an average score to a letter grade.
     *
     * @param average the numerical average score
     * @return the corresponding letter grade
     */
    public String letterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    /**
     * Determines if an average score is passing (>= 60).
     *
     * @param average the numerical average score
     * @return true if the average is passing, false otherwise
     */
    public boolean isPassing(double average) {
        return average >= 60;
    }

    /**
     * Validates that a score is within the valid range [0, 100].
     *
     * @param score the score to validate
     * @throws IllegalArgumentException if the score is outside the valid range
     */
    private void validateScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }
    }
}
