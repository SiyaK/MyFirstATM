import java.util.Date;

public class Transaction {

    /**
     * The amount of this account
     */
    private double amounts;

    /**
     * The time and date of this transaction
     */
    private Date timestamp;
    /**
     * A memo for this transaction
     */
    private String memo;
    /**
     * The account in which the transaction was performed
     */
    private Account inAccount;

    /**
     * Create a new transaction
     * @param amounts the amount transact
     * @param inAccount the account the transaction belongs to
     */
     public Transaction(double amounts, Account inAccount){
         this.amounts = amounts;
         this.inAccount = inAccount;
         this.timestamp = new Date();
         this.memo = "";
     }

    /**
     * Create a new transaction
     * @param amounts the amount transact
     * @param memo the memo for the transaction
     * @param inAccount the account the transaction belongs to
     */
    public Transaction(double amounts, String memo,Account inAccount){
         // call the two-arg constructor first
        this(amounts,inAccount);
        //set the memo
        this.memo = memo;
    }
    public double getAmounts() {
        return this.amounts;
    }
}
