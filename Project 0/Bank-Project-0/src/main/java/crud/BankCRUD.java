package crud;
import java.sql.SQLException;

public interface BankCRUD<T> {
    /**
     * getting account information through different arguments like accountId, customerId, customer name
     *
     * and also crud for new account, make deposit and make withdrawal functions of simple bank console app
     *
     * @return
     * @throws SQLException
     */

    public void createNewAccount(int customer_id, float balance) throws SQLException;
    public boolean makeDeposit(int account_id, float amount) throws SQLException;
    public boolean makeWithdraw(int account_id, float amount) throws SQLException;
    boolean CheckAccount(int account_id, int customer_id) throws SQLException;

//checking account if it is exist or not
}