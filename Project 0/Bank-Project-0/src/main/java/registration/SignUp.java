package registration;
import dao.UserDAO;
import models.User;
import utils.ConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUp {
    static String name;
    static String username;
    static String password;
    static float balance;

    static Scanner sc = new Scanner(System.in);


    /**
     * sign up for an account containing the following information if the connections is valid then it will return
     *  account created message
     *  else it will throw an error because the connection is not valid connection
     */
    public static boolean SignUpForAccount() {


        System.out.println("MAKE SURE YOU ENTER VALID INPUT FOR EACH AND EVERY FIELD");
        System.out.println("Enter your name:");
        name = sc.nextLine();
        System.out.println("Enter username:");
        username= sc.nextLine();
        System.out.println("Enter password:");
        password = sc.nextLine();
        System.out.println("Enter your initial balance: ");
        balance=Integer.parseInt(sc.nextLine());
        try {
            Connection conn = ConnectionManager.getConnection();
            UserDAO dao = new UserDAO(conn);
            dao.createAccount(name,username,password,balance);
            System.out.println("Customer account successfully created "+name);
            return true;

        } catch (SQLException | IOException e) {
            System.out.println("Unable to create account ");
             e.printStackTrace();
            return false;
        }
    }

}


