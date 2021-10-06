package crud;

import java.sql.SQLException;

public interface UserCRUD <T>{
    public void createAccount(String name, String user_name,String password, float balance) throws SQLException;
    public T checkLogIn(String  user_name, String password) throws SQLException;

    /**
     * here I have created an interface that needs to be implements in the user dao
     * which used to create a customer account and also check for user logins .
     */
}
