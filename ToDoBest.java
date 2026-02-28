import java.util.Scanner;
import java.util.ArrayList;

public class ToDoBest  {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        
        while (true) {
            System.out.println("===== Welcome to <ToDoBest> =====");
            System.out.println("1. Add Task");
            System.out.println("2. Show my Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            choice = input.nextInt();
            input.nextLine();
        
        switch(choice) {
            case 1: //add
                 System.out.print("What is your task ? ");
                    String task = input.nextLine();
                    tasks.add(task);
                     break;
            case 2:// show
            if (tasks.isEmpty()) {
                        System.out.println("No tasks to show ");
                    } else {
                        System.out.println("Your Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                break;
            case 3://delete
            if (tasks.isEmpty()) {
                        System.out.println("No tasks to delete.");
                    } else {
                        System.out.println("Your Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        System.out.print("Enter the number of the task to delete: ");
                        int index = input.nextInt();
                        input.nextLine();
                        if (index >= 1 && index <= tasks.size()) {
                            tasks.remove(index - 1);
                            System.out.println("Task deleted!");
                        } else {
                            System.out.println("Invalid task number!");
                        }
                    }
                break;
            case 4://exit
            System.out.println("Exiting!");
                    System.exit(0);
                break;
            default:
                System.out.println("invalid choise");
    }
    }
}
}