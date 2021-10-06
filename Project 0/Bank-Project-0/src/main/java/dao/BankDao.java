package dao;
import crud.BankCRUD;
import models.Account;
import myList.MyList;
import utils.ConnectionManager;
import java.io.IOException;
import java.sql.*;

public class BankDao implements BankCRUD {
    private Connection conn;

    public BankDao() throws SQLException, IOException {
        conn = ConnectionManager.getConnection();

    }

    public BankDao(Connection conn) {
        this.conn = conn;
    }

    /**
     * getting the greatest account_id from bank_ account table . it instantiates the new account_id to zero to find the
     * greatest account_id from the table and it will check it  and assign the next account id.
     * @return
     * @throws SQLException
     */
    public int getGreatestAccountId() throws SQLException {
        int newAccountID = 0;
        String sql = "SELECT account_id FROM bank_accounts";
        PreparedStatement searchAccount = conn.prepareStatement(sql);
        ResultSet rs = searchAccount.executeQuery();

        while (rs.next()) {
            newAccountID = rs.getInt("account_id");
        }
        //System.out.println("DEBUG - Account ID: " + newAccountID);
        return newAccountID;
    }

    /**
     * this creates a new bank account to the user who have already registered as a user it will check the greatest
     * account id and when new account id comes it will increment by one and assign the account id, and it will assign
     * the necessary values to the columns in the table which is the main bank account table and the junction table
     * will get the value from the user
     * */
    @Override
    public void createNewAccount(int customer_id, float balance) throws SQLException {

        try {
            int newId = getGreatestAccountId();
            newId++;

            String sql = "INSERT INTO bank_accounts (account_id, balance) VALUES(?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newId);
            pstmt.setDouble(2, balance);

            pstmt.executeUpdate();

            sql = "INSERT INTO accounts_customers (customer_id, account_id) VALUES(?, ?)";
            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            pstmt2.setInt(1, customer_id);
            pstmt2.setInt(2, newId);

            pstmt2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * getting the account by name which is customer name that registered as a customer . so to get the customer name
     * there need to be joined all three tables I have created for this purpose
     *
     *
     */
    public MyList<Account> getAccountByName(String name) throws SQLException {


            String sqlList = "SELECT ba.account_id, ba.balance FROM bank_accounts ba " +
                    "JOIN accounts_customers ac ON ac.account_id = ba.account_id " +
                    "JOIN bank_customers bc ON bc.customer_id = ac.customer_id WHERE bc.name = ?";
            PreparedStatement psList = conn.prepareStatement(sqlList);
            psList.setString(1, name);
            ResultSet rs = psList.executeQuery();

        MyList<Account> myList = new MyList<>();

            while (rs.next()) {
                Account accountList = new Account(
                        rs.getInt("account_id"),
                        rs.getFloat("balance"));
                myList.add(accountList);

            }


        return myList;
    }

    /**
     *To perform the deposit function it needs to implement a deposit method with passed argument that need
     * in this case the table who have information about account and balance has to be updated to perform deposit
     *
     */

    @Override
    public boolean makeDeposit(int account_id, float amount) throws SQLException {

        if (amount > 0) {
            String sql = "UPDATE bank_accounts " +
                    "SET balance = (balance + ?)" +
                    "WHERE account_id = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql);
            pstmt2.setDouble(1, amount);
            pstmt2.setInt(2, account_id);

            pstmt2.executeUpdate();

            return true;
        } else
            //System.out.println("Amount is less than or equal to 0 exiting program");
        return false;
    }

    @Override
    public boolean makeWithdraw(int account_id, float amount) throws SQLException {
        float balance;
        if (amount > 0) {
            String sql = "SELECT balance from bank_accounts WHERE account_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, account_id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            balance = rs.getInt("balance");
            if (balance >= amount) {
                sql = "UPDATE bank_accounts " +
                        "SET balance = (balance - ?)" +
                        "WHERE account_id = ?";
                PreparedStatement pstmt2 = conn.prepareStatement(sql);
                pstmt2.setDouble(1, amount);
                pstmt2.setInt(2, account_id);

                pstmt2.executeUpdate();
                return true;
            } else
                System.out.println("no enough balance");
        } else {
            System.out.println("not valid amount");
        }
        return false;
    }

    /**
     * check the account is exists or not with the provided arguments in the method and if exist it will return true
     * else it will return false
     */
    @Override
    public boolean CheckAccount(int account_id, int customer_id) throws SQLException {
        String sql = "SELECT account_id, customer_id FROM accounts_customers WHERE account_id = ? AND customer_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, customer_id);
        pstmt.setInt(2, account_id);
        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) {
            return false;
        } else
            return true;
    }

    public boolean validWithdraw(int account_id, float amount) throws SQLException {
        String sqlCheck = "SELECT balance FROM bank_accounts WHERE account_id = ?";
        PreparedStatement psCheck = conn.prepareStatement(sqlCheck);
        psCheck.setInt(1,account_id);
        ResultSet rs = psCheck.executeQuery();
        while(rs.next())
        {
            //get current balance
            double currentBalance = rs.getFloat("balance");
            if(currentBalance >= amount)
            {
                System.out.println("allowed withdraw");
                return true;
            }
            else
            {
                System.out.println("withdraw not allowed");
                return false;
            }
        }

        return false;
    }



}
