import java.util.ArrayList;
import java.util.Scanner;

public class ToDo {
    private static ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== To-Do List Application =====");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Complete");
            System.out.println("3. View Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    markTaskAsComplete();
                    break;
                case 3:
                    viewTasks();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter due date: ");
        String dueDate = scanner.nextLine();

        Task task = new Task(title, description, dueDate, false);
        taskList.add(task);
        System.out.println("Task added successfully!");
    }

    private static void markTaskAsComplete() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the task to mark as complete: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < taskList.size()) {
            taskList.get(index).setCompleted(true);
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid index. No task found.");
        }
    }

    private static void viewTasks() {
        System.out.println("===== Task List =====");
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.println("Task #" + i);
            System.out.println("Title: " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Completed: " + (task.isCompleted() ? "Yes" : "No"));
            System.out.println("------------------------");
        }
    }

    private static void removeTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the index of the task to remove: ");
        int index = scanner.nextInt();

        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Invalid index. No task found.");
        }
    }
}

class Task {
    private String title;
    private String description;
    private String dueDate;
    private boolean isCompleted;

    public Task(String title, String description, String dueDate, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
