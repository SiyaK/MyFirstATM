import java.util.ArrayList;
import java.util.Random;

public class Bank {
    /**
     * The name of the user
     */
    private String name;

    /**
     *
     */
    private ArrayList<User> user;
    /**
     *
     */
    private ArrayList<Account> accounts;

    /**
     * Create a new Bank object with empty lists of users and accounts
     * @param name the name of the bank
     */
    public Bank(String name){
        this.name = name;
        this.user = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }
    public String getName() {
        return name;
    }

    /**
     * Generate a new universally ID for a user
     * @return the uid
     */
    public String getNewUserUID(){
    //initialize
        String uid ;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;
        //keep doing something once until a condition becomes false
        //while we don't have a unique uid keep generating a new one
        //continue looping until we get a unique ID
        do {
            //generate the pin
            uid = "";
            for(int c = 0;c < len; c++){
                uid += ((Integer)rng.nextInt(10)).toString();
            }

            // check to make sure its unique
            nonUnique = false;
            for (User u: this.user){
                if (uid.compareTo(u.getUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }

        }while(nonUnique);

        return uid;
    }

    public String getNewAccountUID(){
        //initialize
        String uid ;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;
        //keep doing something once until a condition becomes false
        //while we don't have a unique uid keep generating a new one
        //continue looping until we get a unique ID
        do {
            //generate the pin
            uid = "";
            for(int c = 0;c < len; c++){
                uid += ((Integer)rng.nextInt(10)).toString();
            }

            // check to make sure its unique
            nonUnique = false;
            for (Account a: this.accounts){
                if (uid.compareTo(a.getUID1()) == 0){
                    nonUnique = true;
                    break;
                }
            }

        }while(nonUnique);

        return uid;
    }

    /**
     * Add an account
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    /**
     * Create a new user of the bank
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param pin the user's pin
     * @return the user's object
     */
    public User addUser(String firstName, String lastName, String pin){
        //when we want to create another user
        //create a new object and add it to our list
        User newUser = new User(firstName,lastName,pin,this);
        this.user.add(newUser);

        //create savings account for the user and add to user and bank accounts list

        Account newAccount = new Account("Savings", newUser,this);
        newUser.addAccount( newAccount);
        this.addAccount(newAccount);
        return newUser;
    }

    /**
     * Get the user object associated with a particular userID and pin
     * if they are valid
     * @param userID the UID of the user to login
     * @param pin pin of the user
     * @return the user object, if the login is successful, or null, if it is not
     */
    public User userlogin(String userID, String pin){
        //search through the list of users
        for (User u: this.user){
            //check user ID is correct
            if(u.getUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }
        //if we haven't found the user or have an incorrect pin
        return  null;
    }

}
