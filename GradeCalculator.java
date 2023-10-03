import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Student Grade Calculator =====");

        // Input grades for various components
        double assignmentsGrade = inputGrade("Assignments");
        double quizzesGrade = inputGrade("Quizzes");
        double midtermGrade = inputGrade("Midterm Exam");
        double finalExamGrade = inputGrade("Final Exam");

        // Define your grading scale here
        // For example, a scale with corresponding grade ranges and letter grades
        double[] gradeRanges = {90, 80, 70, 60};
        String[] letterGrades = {"A", "B", "C", "D", "F"};

        // Calculate the overall course grade
        double finalGrade = calculateFinalGrade(assignmentsGrade, quizzesGrade, midtermGrade, finalExamGrade, gradeRanges, letterGrades);

        // Display the final course grade and letter grade
        System.out.println("Final Course Grade: " + finalGrade);
        System.out.println("Letter Grade: " + determineLetterGrade(finalGrade, gradeRanges, letterGrades));

        scanner.close();
    }

    private static double inputGrade(String componentName) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your grade for " + componentName + ": ");
        return scanner.nextDouble();
    }

    private static double calculateFinalGrade(double assignments, double quizzes, double midterm, double finalExam,
                                              double[] gradeRanges, String[] letterGrades) {
        // Define weights for different components if needed
        double assignmentsWeight = 0.2;
        double quizzesWeight = 0.2;
        double midtermWeight = 0.3;
        double finalExamWeight = 0.3;

        // Calculate the weighted average
        double weightedAverage = (assignments * assignmentsWeight) +
                                 (quizzes * quizzesWeight) +
                                 (midterm * midtermWeight) +
                                 (finalExam * finalExamWeight);

        return weightedAverage;
    }

    private static String determineLetterGrade(double finalGrade, double[] gradeRanges, String[] letterGrades) {
        for (int i = 0; i < gradeRanges.length; i++) {
            if (finalGrade >= gradeRanges[i]) {
                return letterGrades[i];
            }
        }
        return letterGrades[letterGrades.length - 1]; // Default to the lowest grade if no range is matched
    }
}
