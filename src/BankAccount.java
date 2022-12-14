import java.util.Scanner;

public class BankAccount {
    // Bank Account class
    // make a bank account class that has deposit and withdraw methods
    // asks user for input about which bank account they want to make changes to

    private int balance;

    /**
     * BankAccount constructor creates BankAccount object
     * @param accountBalance balance of the account
     */
    public BankAccount(int accountBalance) {
        balance = accountBalance;
    }

    /**
     * deposit method adds money to a bank account object and balance is updated
     * @param amount amount of money the user wants to deposit in the account
     */
    public void deposit(int amount) {
        balance+=amount;
    }

    /**
     * This method sends money from one bank account to another
     * @param amount amount of money that is to be sent to the other bank account
     * @param destination the bank account that the money will be transferred too
     */
    public void send(int amount, BankAccount destination) {
        destination.deposit(amount);
        balance-=amount;
    }

    /**
     * gets balance of the bank account
     * @return balance, balance of the bank account
     */
    public int getBalance() {
        return balance;
    }
    public static void main(String[] args) {
        System.out.println("This is a program simulating a Bank Account!");
        // creates necessary Scanners for input
        Scanner in = new Scanner(System.in);
        Scanner amount = new Scanner(System.in);
        // creates both BankAccount objects
        BankAccount accountOne = new BankAccount(1000);
        BankAccount accountTwo = new BankAccount(1000);
        // while loop with all code to ask for user input and run all BankAccount methods
        while (true) {
            // asks user whether they want to deposit money or send money
            System.out.println("Enter D to deposit money into your account, Enter S to send money to another account, Enter Q to quit");
            String input = in.next();
            // checks if user wants to deposit money into their account
            if (input.equals("D")) {
                System.out.println("How many dollars do you want to deposit in your account? Between 0 and 1000.");
                // initializes depositAmount variable
                int depositAmount;
                // checks if depositAmount is between 0 and 1000
                while (true) {
                    depositAmount = amount.nextInt();
                    if (depositAmount >= 0 && depositAmount <= 1000) {
                        break;
                    } else {
                        System.out.println("Bad input, input is not between 0 and 1000.");
                    }
                }
                accountOne.deposit(depositAmount);
                System.out.println("Success " + depositAmount + " dollars was deposited into accountOne making its new balance " + accountOne.getBalance() + " dollars");
            }
            // checks if user wants to send money to another account
            else if (input.equals("S")) {
                System.out.println("How many dollars do you want to transfer to another account? Between 0 and 1000.");
                // initializes depositAmount variable
                int transferAmount;
                // checks if transferAmount is between 0 and 1000
                while (true) {
                    transferAmount = amount.nextInt();
                    if (transferAmount >= 0 && transferAmount <= 1000) {
                        break;
                    } else {
                        System.out.println("Bad input, input is not between 0 and 1000.");
                    }
                }
                accountOne.send(transferAmount, accountTwo);
                // print statements so the user knows that the transfer was successful. 
                System.out.println("Success " + transferAmount + " dollars was transferred from accountOne to accountTwo making account 1's new balance " + accountOne.getBalance() + " dollars");
                System.out.println("Account 2's new balance is " + accountTwo.getBalance());
            }
            // checks if user wants to quit program
            else if (input.equals("Q")) {
                System.out.println("Quitting program");
                break;
            }
            // tells the user that input was not usable for this program
            else {
                System.out.println("Bad input, Input D to deposit money in your account or S to send money to another account");
            }
        }
    }
}
