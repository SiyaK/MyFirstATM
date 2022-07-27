import java.util.ArrayList;

public class Account {
    /**
     * The name of the account
     */
    private String name;
    /**
     * The account ID number
     */
    private String uid;
    /**
     * The user object that owns this account
     */
    private User holder;
    /**
     * The list of transactions for the account
     */
    private ArrayList<Transaction> transactions;

    /**
     * Create a new account
     * @param name the name of the account
     * @param holder the user's object that holds this account
     * @param theBank the bank that issues the account
     */
    public  Account(String name, User holder, Bank theBank){
        //set the account name and holder
        this.name = name;
        this.holder = holder;

        //get new account UID
        this.uid = theBank.getNewAccountUID();

        //initialize transactions
        this.transactions = new ArrayList<Transaction>();

        //add to holder and bank lists
//        holder.addAccount(this);
//        theBank.addAccount(this);
    }

    /**
     * Get the account ID
     * @return the uid
     */
    public String getUID1(){
        return this.uid;
    }

    /**
     * Get the summary line for the account
     * @return the String summary
     */
    public String getSummaryLine(){
        //get the account's balance
        double balance =  this.getBalance();

        //format the summary line depending on whether the balance is negative
        if(balance >= 0){
            return String.format("%s : R%.02f : %s", this.uid,balance,this.name);
        }else{
            return String.format("%s : R(%.02f) : %s", this.uid,balance,this.name);
        }
    }

    /**
     * Get the balance of this account by adding the amounts of the transactions
     * @return the balance value
     */
    private double getBalance() {
        double balance = 0;
        for(Transaction transaction : this.transactions){
            balance += transaction.getAmounts();

        }
        return balance;
    }
}
