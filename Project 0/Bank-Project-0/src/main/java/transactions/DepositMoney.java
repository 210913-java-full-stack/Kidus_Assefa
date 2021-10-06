package transactions;
import dao.BankDao;
import models.Account;
import myList.MyList;
import utils.ConnectionManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Scanner;

public class DepositMoney {
    private static int account;
    private static int customer_id;
static NumberFormat curr= NumberFormat.getCurrencyInstance();


    public static void deposit(int account_id) throws SQLException, IOException {

        boolean success;
        float amount = 0;
        Account ac = new Account();

        BankDao dao = new BankDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number to deposit: ");
        account=scanner.nextInt();
        System.out.println("How much would you like to deposit ? : ");
        amount = scanner.nextFloat();
        boolean isExists = dao.CheckAccount(account,ac.getAccount_id());
        success = dao.makeDeposit(account, amount);
        if (success)
            System.out.println("Deposit successful  " + curr.format(amount));
    }
    public static void checkBalance(String name) throws SQLException, IOException {

        System.out.println("-----Account lists-----");

        try{
            Connection con= ConnectionManager.getConnection();
            MyList<Account> accList;
            BankDao dao = new BankDao(con);
        accList = dao.getAccountByName(name);
        for(int i =0; i < accList.size(); i++) {

            System.out.println((accList.get(i)));
        }
    } catch (SQLException | IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("-----------------------------");
    }


    public static void withdraw() throws SQLException, IOException {
        float amount = 0;
        Scanner scanner = new Scanner(System.in);
        BankDao dao = new BankDao();
        System.out.println("Enter an account number to withdraw : ");
        account = scanner.nextInt();
        System.out.println("How much would you like to withdraw ? : ");
        amount = scanner.nextFloat();
        boolean isExists = dao.CheckAccount(account, customer_id);

//        if(isExists)

//        else

        scanner.nextLine();
        boolean success = dao.makeWithdraw(account, amount);
        if (success)
            System.out.println("Withdrawal successful " + curr.format(amount));
    }
}