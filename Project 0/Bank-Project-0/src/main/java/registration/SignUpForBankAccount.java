package registration;
import dao.BankDao;
import models.Account;
import utils.ConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SignUpForBankAccount {
    static float balance;
    static int account_id;
    static Scanner sc = new Scanner(System.in);

    /** this will also check the connection is valid or not
     *
     *
     * **/

    public static boolean newBankAccount(float balance) {
        System.out.println("Enter Initial deposit balance :" );
        balance = Float.parseFloat(sc.nextLine());

        try {
            Connection conn = ConnectionManager.getConnection();
            BankDao bankDAO = new BankDao(conn);
            Account getAccount = new Account();
            bankDAO.createNewAccount(account_id, balance);

            System.out.println("You successfully created account id and your Id is :"+ getAccount.getAccount_id() );
            return true;

        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
