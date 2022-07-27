import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank theBank = new Bank("Bank of FNB");
        //add a user to the bank, which also creates a savings account
        User aUser = theBank.addUser("Kamogelo", "Kungwane","5050");
        //add a checking account for the user
        Account Acc = new Account("checking", aUser,theBank);
        aUser.addAccount(Acc);
        theBank.addAccount(Acc);

        User curUser;
        while(true){
            //stay in the login prompt until successful login
            curUser = ATM.mainMenuPrompt(theBank, scanner);

            //stay in main menu until user quits
            ATM.printUserMenu(curUser, scanner);
        }
    }

    public static User mainMenuPrompt(Bank theBank,Scanner scanner){
        String userID;
        String pin;
        User authUser;

        do {
            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.print("Enter user ID: ");
            userID = scanner.nextLine();
            System.out.print("Enter pin: ");
            pin = scanner.nextLine();

            //try to get the user object corresponding to the ID  and pin combo
            authUser = theBank.userlogin(userID,pin);
            if(authUser == null){
                System.out.println("Incorrect user ID/pin, please try again. ");
            }
        }while(authUser == null);//continue looping until successful login
        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner scanner){
        //print a summary of the user's accounts
        theUser.printAccountsSummary();
        int choice;

        do {
            System.out.printf("Welcome %s, what would like to do? ", theUser.getFirstName());
            System.out.println(" 1) Show account transaction history  ");
            System.out.println(" 2) Withdraw ");
            System.out.println(" 3) Deposit  ");
            System.out.println(" 4) Transfer  ");
            System.out.println(" 5) Quit! ");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            if(choice < 1 || choice > 5){
                System.out.println("Invalid choice, please input 1-5 ");
            }
        }while(choice < 1 || choice > 5);

        switch(choice){
            case 1:
                ATM.showTransactHistory(theUser, scanner);
                break;
            case 2:
                ATM.withdrawFunds(theUser, scanner);
                break;
            case 3:
                ATM.depositFunds(theUser, scanner);
                break;
            case 4:
                ATM.tranferFunds(theUser, scanner);
                break;
        }
        // redisplay this menu unless the user wants to quit
        if(choice != 5){
            ATM.printUserMenu(theUser, scanner);
        }


    }
    private static void showTransactHistory(User theUser, Scanner scanner) {

    }
    private static void withdrawFunds(User theUser, Scanner scanner) {

    }
    private static void depositFunds(User theUser, Scanner scanner) {
    }
    private static void tranferFunds(User theUser, Scanner scanner) {
    }








}
