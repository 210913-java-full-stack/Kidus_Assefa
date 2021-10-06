package registration;
import dao.UserDAO;
import utils.ConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SignIn {
    static String username;
    static String password;
    static Scanner sc = new Scanner(System.in);

    /**
     * this validating username and password combination if the username and password combination is match the one
     * in the bank customer table it will sign in to the menu to make the necessary thing on the account which is
     * checking balance make deposit make withdraw to the account
     *
     * @return
     */
    public static String SignInGo()
    {
        System.out.println("Enter username:");
        username = sc.nextLine();
        System.out.println("Enter password:");
        password = sc.nextLine();
        try{
            Connection conn = ConnectionManager.getConnection();
            UserDAO dao = new UserDAO(conn);

            if(dao.checkLogIn(username,password) != null)
            {
                System.out.println("sign in successful");

                return username;
            }

        } catch (IOException |  SQLException e) {
            System.out.println(e.getMessage());
            return username;
        }
        return null;
    }
}
