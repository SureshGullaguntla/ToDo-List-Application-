package todo.list;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import todo.list.task;


public class main {
	
    private static final Scanner scanner = new Scanner(System.in);
	    private static final List<task> tasks = new ArrayList<>();

	    public static void main(String[] args) {
	        boolean exit = false;
	        while (!exit) {
	            printMenu();
	            int choice = getUserChoice();
	            switch (choice) {
	                case 1 -> createTask();
	                case 2 -> viewTasks();
	                case 3 -> updateTask();
	                case 4 -> markTaskCompleted();
	                case 5 -> deleteTask();
	                case 6 -> {
	                    System.out.println("Exiting application. Goodbye!");
	                    exit = true;
	                }
	                default -> System.out.println("Invalid choice! Please select a valid option.");
	            }
	            System.out.println();
	        }
	        scanner.close();
	    }

	    private static void printMenu() {
	        System.out.println("=== To-Do List Menu ===");
	        System.out.println("1. Create Task");
	        System.out.println("2. View Tasks");
	        System.out.println("3. Update Task");
	        System.out.println("4. Mark Task as Completed");
	        System.out.println("5. Delete Task");
	        System.out.println("6. Exit");
	        System.out.print("Enter your choice: ");
	    }

	    private static int getUserChoice() {
	        try {
	            return scanner.nextInt();
	        } catch (InputMismatchException e) {
	            scanner.nextLine(); // clear invalid input
	            return -1;
	        }
	    }

	    private static void createTask() {
	        scanner.nextLine(); // Consume newline
	        System.out.print("Enter the task description: ");
	        String description = scanner.nextLine().trim();
	        if (description.isEmpty()) {
	            System.out.println("Task description cannot be empty.");
	            return;
	        }
	        tasks.add(new task(description));
	        System.out.println("Task added successfully.");
	    }

	    private static void viewTasks() {
	        if (tasks.isEmpty()) {
	            System.out.println("No tasks available.");
	            return;
	        }
	        System.out.println("Your Tasks:");
	        for (task task : tasks) {
	            System.out.println(task);
	        }
	    }

	    private static task findTaskById(int id) {
	        for (task task : tasks) {
	            if (task.getId() == id) {
	                return task;
	            }
	        }
	        return null;
	    }

	    private static void updateTask() {
	        if (tasks.isEmpty()) {
	            System.out.println("No tasks available to update.");
	            return;
	        }
	        viewTasks();
	        System.out.print("Enter the Task ID to update: ");
	        int id = getUserChoice();
	        if (id <= 0) {
	            System.out.println("Invalid Task ID.");
	            return;
	        }
	        task task = findTaskById(id);
	        if (task == null) {
	            System.out.println("Task with ID " + id + " not found.");
	            return;
	        }
	        scanner.nextLine(); // Consume newline
	        System.out.print("Enter the new description: ");
	        String newDescription = scanner.nextLine().trim();
	        if (newDescription.isEmpty()) {
	            System.out.println("Description cannot be empty.");
	            return;
	        }
	        task.setDescription(newDescription);
	        System.out.println("Task updated successfully.");
	    }

	    private static void markTaskCompleted() {
	        if (tasks.isEmpty()) {
	            System.out.println("No tasks available to mark completed.");
	            return;
	        }
	        viewTasks();
	        System.out.print("Enter the Task ID to mark as completed: ");
	        int id = getUserChoice();
	        if (id <= 0) {
	            System.out.println("Invalid Task ID.");
	            return;
	        }
	        task task = findTaskById(id);
	        if (task == null) {
	            System.out.println("Task with ID " + id + " not found.");
	            return;
	        }
	        if (task.isCompleted()) {
	            System.out.println("Task is already marked as completed.");
	            return;
	        }
	        task.setCompleted(true);
	        System.out.println("Task marked as completed.");
	    }

	    private static void deleteTask() {
	        if (tasks.isEmpty()) {
	            System.out.println("No tasks available to delete.");
	            return;
	        }
	        viewTasks();
	        System.out.print("Enter the Task ID to delete: ");
	        int id = getUserChoice();
	        if (id <= 0) {
	            System.out.println("Invalid Task ID.");
	            return;
	        }
	        task task = findTaskById(id);
	        if (task == null) {
	            System.out.println("Task with ID " + id + " not found.");
	            return;
	        }
	        tasks.remove(task);
	        System.out.println("Task deleted successfully.");
	    }
	}
