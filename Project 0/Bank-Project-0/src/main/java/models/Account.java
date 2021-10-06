package models;

public class Account {
    private int account_id;
    private float balance;


    public Account(int account_id)
    {
        this.account_id = account_id;
        this.balance = 0;
    }

    public Account(int account_id, float balance)
    {
        this.account_id = account_id;
        this.balance = balance;
    }

    public Account(float balance)
    {
        this.balance = balance;
    }

    public Account() {

    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    /**
     * models for account information which is getter and setter
     */
}