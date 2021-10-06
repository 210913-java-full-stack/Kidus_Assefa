package models;
public class User {
    private int customer_id;
    private String name;
    private String user_name;
    private String password;
    private float balance;

    public User(String name, String username, String password, float balance) {
    }

    /**
     * a model for customer information that is a getter and setter methods
     *
     */

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public User(String name, String user_name, String password)
    {
        //this.customer_id = customer_id;
        this.name = name;
        this.user_name = user_name;
        this.password = password;
    }

    public User(String user_name, String password)
    {
        //this.customer_id = customer_id;
        //this.name = name;
        this.user_name = user_name;
        this.password = password;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}