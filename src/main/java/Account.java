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
}
