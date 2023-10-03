import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Calculator Application =====");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the calculator.");
                scanner.close();
                System.exit(0);
            }

            if (choice >= 1 && choice <= 4) {
                double result = performOperation(choice);
                System.out.println("Result: " + result);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static double performOperation(int choice) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        switch (choice) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    System.out.println("Error: Division by zero.");
                    return Double.NaN; // Indicate an error result
                }
            default:
                return 0;
        }
    }
}

