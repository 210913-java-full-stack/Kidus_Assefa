import DAO.ToDoItemDAO;
import model.ToDoItem;
import util.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
public class Driver {
    public static void main(String[] args) {

        // View command line arguments passed to app
//        for(int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }

        //Scanner object bound to System.in, the console input
        //Scanner sc = new Scanner(System.in);

        /*List of ToDoItem objects
        Here we create a number of static to-do-items and store them into our list. Later we will re-design
        this to be more dynamic and persistent.
        */


        try {
            Connection conn = ConnectionManager.getConnection();

            ToDoItem newItem = new ToDoItem("Build a UI for our app");
            ToDoItemDAO dao = new ToDoItemDAO(conn);
            dao.save(newItem);


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


        //Main app loop
//        boolean running = true;
//        while(running) {
//            System.out.println("===MAIN MENU===\nEnter selection:\n\n1) View ToDo Items.\n2) Mark item complete.\nQ) Quit");
//            String input = sc.nextLine();
//
//            switch(input) {
//                case "1":
//                    System.out.println("========== To Do List: ==========");
//                    for(int i = 0; i < toDoList.size(); i++) {
//                        PrintView.printMyView(i, toDoList.get(i));
//                    }
//                    System.out.println("=================================");
//                    break;
//                case "2":
//                    //mark item complete method
//                    System.out.println("========== To Do List: ==========");
//                    for(int i = 0; i < toDoList.size(); i++) {
//                        PrintView.printMyView(i, toDoList.get(i));
//                    }
//                    System.out.print("\nEnter item number to mark complete: ");
//                    String choice = sc.nextLine(); //Or we could do sc.nextInt(); but then we need to consume the leftover newline character
//                    toDoList.get(Integer.parseInt(choice)).setComplete(true);
//
//                    System.out.println("\n Item #" + choice + " is complete!");
//
//                    break;
//                case "Q":
//                case "q":
//                    running = false;
//                    break;
//            }
//        }
    }
}