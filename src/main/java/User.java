
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {
    /**
     * The first name of the user
     */
    private String firstName;
    /**
     * The last name of the user
     */
    private String LastName;
    /**
     * The ID number of the user
     */
    private String uid;
    /**
     * The MD5 hash of the users pin
     */
    private byte pinHash[];
    /**
     * The list of accounts for this user
     */
    private ArrayList<Account> accounts;

    /**
     * Create a new user
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param pin the user's account pin
     * @param theBank theBank the bank object that the user is a customer of
     */
    public User(String firstName, String lastName, String pin,Bank theBank){
        //set user's name
        this.firstName = firstName;
        this.LastName = lastName;
      //store the pin's MD5 hash ,rather than the original value, for security reasons

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //getting the memory of the bytes of our pin
            this.pinHash = md.digest(pin.getBytes());
        }catch (NoSuchAlgorithmException e ){
            //TODO Auto-generated catch block
            System.out.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        //get a new, unique ID for the user
        this.uid = theBank.getNewUserUID();

        //empty list of accounts
        this.accounts = new ArrayList<Account>();

        //print a log message
        System.out.printf("New user %s, %s with ID %s created.\n", lastName,firstName, this.uid);
    }

    /**
     * Add an account for the user
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    public String getUID(){
        return this.uid;
    }
    
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * prinnt the summaty for the accounts for the user
     */
    public void printAccountsSummary(){
        System.out.printf("\n\n%s's accounts summary", this.firstName);
        for (Account account : this.accounts) {
            System.out.printf("%d) %s\n", account.getSummaryLine());
        }
        System.out.println();
    }

    /**
     * Check whether a given pin matches the true user pin
     * @param aPin the pin to check
     * @return whether the pin is valid or not
     */
    public boolean validatePin(String aPin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return  MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
            //getting the memory of the bytes of our pin
//            this.pinHash = md.digest(aPin.getBytes());
        }catch (NoSuchAlgorithmException e ){
            //TODO Auto-generated catch block
            System.out.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }


}
