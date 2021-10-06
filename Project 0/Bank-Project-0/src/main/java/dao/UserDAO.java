package dao;
import crud.UserCRUD;
import models.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements UserCRUD{
    private static int customer_id;
    private  int account_id;
    private static Connection con;

    BankDao dao = new BankDao();

    public UserDAO(Connection con) throws SQLException, IOException {
        this.con=con;
    }

    /**
     * Getting account by account id from account-customers table which is the connector table to bank account table and
     * bank customer table
     * It gets the greatest customer id from the table that holds the customer information
     */
    public int getGreatestCustomerId() throws SQLException {
        int new_id=0;
        String sql = "SELECT customer_id FROM bank_customers";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            new_id = rs.getInt("customer_id");
        }
        return  new_id;
    }

    /**
     * Creating a logic to a user can register to a new account which is a new customer account
     * it will get the highest account id and increments by one
     */
    @Override
    public void createAccount(String name, String user_name, String password, float balance) throws SQLException {
        try {

            account_id = dao.getGreatestAccountId();
            account_id++;
            customer_id = getGreatestCustomerId();
            customer_id++;

            String sql = "INSERT INTO bank_accounts (account_id, balance) VALUES (?,?)";
            PreparedStatement insertBankAccounts = con.prepareStatement(sql);
            insertBankAccounts.setInt(1, account_id);
            insertBankAccounts.setDouble(2, balance);
           insertBankAccounts.executeUpdate();

            sql = "INSERT INTO accounts_customers (customer_id, account_id) VALUES (?, ?)";
            PreparedStatement insertAccountCustomer = con.prepareStatement(sql);
            insertAccountCustomer.setInt(1, customer_id);
            insertAccountCustomer.setInt(2, account_id);

            insertAccountCustomer.executeUpdate();

            sql = "INSERT INTO bank_customers VALUES (?, ?, ?, ?)";
            PreparedStatement insertCustomers = con.prepareStatement(sql);
            insertCustomers.setInt(1,customer_id);
            insertCustomers.setString(2, name);
            insertCustomers.setString(3, user_name);
            insertCustomers.setString(4,password);
            insertCustomers.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * check for logins when a customer try to log in this is the first thing get checked because if the customer
     * provide invalid information to the user_name and password field it will check and throw an error log in
     *
     */


    @Override
    public Object checkLogIn(String user_name, String password) throws SQLException {
        User signIn;
        String sql = "SELECT * FROM bank_customers WHERE user_name = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user_name);
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            System.out.println("There is no account associated with "+ user_name);
        }

        /**
         *   //mapping user_name and password combination
         */
        sql = "SELECT * FROM bank_customers WHERE (user_name = ?) AND (password = ?)";
        PreparedStatement preparedGetStmt = con.prepareStatement(sql);
        preparedGetStmt.setString(1, user_name);
        preparedGetStmt.setString(2, password);

        ResultSet resultSet = preparedGetStmt.executeQuery();

/**
 * if the specified username and password matches, and it contains the customer information matched it will log in
 */
        if (resultSet.next()) {
            signIn = new User(
                            resultSet.getString("name"),
                            resultSet.getString("user_name"),
                            resultSet.getString("password"));


            return signIn;
        }
        return null;
    }
    private boolean checkString(String str) {
        boolean valid = true;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <='Z')) {
                valid = false;
                break;
            }
        }
        return valid;
    }
    }






