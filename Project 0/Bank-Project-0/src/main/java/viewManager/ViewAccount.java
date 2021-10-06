package viewManager;

import dao.BankDao;
import models.Account;
import myList.MyList;
import utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.NumberFormat;

public class ViewAccount {

     static NumberFormat curr = NumberFormat.getCurrencyInstance();
    public static void printMyView(Account account)
    {
        int view = account.getAccount_id();
        System.out.printf(view + " ||  " + curr.format(account.getBalance()));
    }

    /**
     * getting the accounts by using my
     * @param name
     */
    public static void printAccountList(String name)
    {
        System.out.println("---accounts---");

        try{

            Connection conn = ConnectionManager.getConnection();
            BankDao dao = new BankDao(conn);
            MyList<Account> accounts;
            accounts = dao.getAccountByName(name);

            for(int i = 0; i<accounts.size();i++)
            {

                ViewAccount.printMyView(accounts.get(i));
            }

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("========================");
    }

}
