package viewManager;
import models.Account;
import models.User;
import registration.SignIn;
import registration.SignUp;
import registration.SignUpForBankAccount;
import transactions.DepositMoney;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
public class BankMain {

    private static int accountHolder=0;

    public static User user;
    public static Account account;
    private static String name;

    public static void mainVew() throws SQLException, IOException {
        Scanner sc = new Scanner(System.in);
        String holder = "";

        boolean running = true;
        while (true) {
            System.out.println("\n\n========---- USER CREDENTIAL MENU ---=========");
            System.out.println("===-Choice lists ");
            System.out.println("--1). Sign up for new account");
            System.out.println("--2). SignIn");
            System.out.println("--0). Exit");
            System.out.println("Enter your choice ");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    //Register the user.
                    if (SignUp.SignUpForAccount()) {

                        while (running) {
                            System.out.println("======LOGGED IN======\nEnter Selection:\n\n--1). Create new bank account" +
                                    "\n--2). Make deposit \n--3). Make withdrawal \n-- 4).Check for balances \n--0). Go back");

                            System.out.println("Enter your selection: ");
                           input=sc.nextLine();
                            switch (input) {
                                case "1":
                                    SignUpForBankAccount.newBankAccount(accountHolder);
                                    break;
                                case "2":
                                    DepositMoney.deposit(accountHolder);
                                    break;
                                case "3":
                                    DepositMoney.withdraw();
                                    break;
                                case "4":
                                        DepositMoney.checkBalance(name);
                                    break;

                                case "0":
                                    running = false;
                                    break;
                                default:
                                    System.out.println("you entered invalid key please select the correct input.");
                            }
                        }
                    } else {
                        System.out.println("Unable to create account. Please try one more time .");
                        SignUp.SignUpForAccount();

                        while (running) {
                            System.out.println("======LOGGED IN======\nEnter Selection:\n\n--1). Create new bank account" +
                                    "\n--2). Make deposit \n--3). Make withdrawal \n--4). Check for balances \n--0). Go back");

                            System.out.println("Enter your selection: ");
                            input=sc.nextLine();
                            switch (input) {
                                case "1":
                                    SignUpForBankAccount.newBankAccount(accountHolder);
                                    break;
                                case "2":
                                    DepositMoney.deposit(accountHolder);
                                    break;
                                case "3":
                                    DepositMoney.withdraw();
                                    break;
                                case "4":
                                    DepositMoney.checkBalance(name);
                                    break;
                                case "0":
                                    running = false;
                                    break;
                                default:
                                    System.out.println("you entered invalid key please select the correct input.");
                            }
                        }
                    }
                case "2":
                    holder = SignIn.SignInGo();
                    if ((holder != null)) {
                        System.out.println("- ========--W-E-L-C-M-E-======  " + holder);

                        System.out.println("======================================");
                        while (running) {
                            System.out.println("====== ENJOY !!! =====\n\n1). Create new bank account \n2). Make Deposit \n3). Make Withdraw. \n4). Check for balances \n0).Exit.");

                            System.out.println("Enter your choice");
                            input=sc.nextLine();

                            switch (input) {
                                case "1":
                                    SignUpForBankAccount.newBankAccount(accountHolder);

                                    break;
                                case "2":
                                    // make deposit
                                    DepositMoney.deposit(accountHolder);
                                    break;
                                case "3":
                                    //Withdraw funds
                                    DepositMoney.withdraw();
                                    break;
                                case "4":
                                    DepositMoney.checkBalance(name);
                                    break;
                                case "0":
                                    running=false;
                                    break;

                                default:
                                    System.out.println("Invalid input! Please type one of the numbers from the list.");
                            }

                        }
                        break;

                    } else {
                        System.out.println("sign in failed.");

                            running = false;
                            System.out.println("Invalid input! Please type one of the numbers from the list.");
                            break;
                        }
                case "0":
                    System.exit(0);
                        break;
                    }

            }

        }

    }



