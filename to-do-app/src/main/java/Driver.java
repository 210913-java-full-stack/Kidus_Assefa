import models.ToDoItem;
import utl.PrintView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        // View command line arguments passed to app
        for(int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        // scanner object
        Scanner sc= new Scanner(System.in);

        // list to do list Items

        List<ToDoItem> toDoList = new LinkedList<>();

        ToDoItem newItem1 = new ToDoItem("Build a to do list");
        toDoList.add(newItem1);

        ToDoItem newItem2 = new ToDoItem("Debug the new to do list");
        toDoList.add(newItem2);

        ToDoItem newItem3 = new ToDoItem("enjoy your new to do list!");
        toDoList.add(newItem3);
        boolean running= true;
        while (running) {
            PrintView.printMyView("===Main Menu===\n Enter Selections:\n 1. To view to do Items \n 2 . To coming soon \nq. quit");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i + ") " + toDoList.get(i).getToDoText());

                    }
                    System.out.print("=============================");

                    break;
                case "2":
                    for (int i = 0; i < toDoList.size(); i++) {
                        PrintView.printMyView(i + ") " + toDoList.get(i).getToDoText());

                    }
                    System.out.print("enter item number to mark completed ");
                   String choice= sc.nextLine();
                    toDoList.get(Integer.parseInt(choice)).setComplete(true);
                    System.out.println("\n Item #"+choice +" completed 1");
                    break;
                //this is output our list
                case "Q":
                case "q":
                    running=false;
                    break;

            }

        }
    }
}