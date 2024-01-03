import java.util.Scanner;

class BankAccount {
    public String Transcation="Transcation History \n1";
    private double balance; 
    int s=0;
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            
            balance += amount;
            s++;
            Transcation+=(""+s+": diposit="+amount+"  Total balance:"+balance+"\n");
            System.out.println("Money Deposited: " + amount);
        } else {
            System.out.println("Invalid amount for deposit!");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
             s++;
            Transcation+=(""+s+": withdraw="+amount+"  Total balance:"+balance+"\n");
            System.out.println("Money Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal!");
        }
    }
    public void transfer(double ac_no,double amount)
    {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
             s++;
            Transcation+=(""+s+": Transfer ="+amount+"  Total balance:"+balance+"Transfer account no="+ac_no+"\n");
            System.out.println("Money Transfered: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount for Transfer !!");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
       
            System.out.println("******** WELCOME TO ATM ********");
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Cash");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Show Trannscation");
            System.out.println("5. Transfer Ammount");
            System.out.println("6. Exit"); 
        
    }

    public void start() {
        System.out.println("Enter the Pin");
        int pin=scanner.nextInt();
        if(pin==7656)
        {
            int choice;
            do {
                showMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println(account.Transcation);
                        break;
                    case 5:
                        transfer();
                        break;
                    case 6:
                        System.out.println("Exiting ATM. Thank You!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option!");
                }
            } while (choice != 6);
        }
        else
        {
            System.out.println("Invalid pin \nPress 1.Try again \nPress 0.Exit");
            int choose=scanner.nextInt();
            if(choose==1)
            {
                start();
            }
        }
        
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }
    private void transfer(){
        System.out.println("Enter the Account Number");
        double ac_no=scanner.nextDouble();
         System.out.print("Enter Transfer amount: ");
        double amount=scanner.nextDouble();
        account.transfer(ac_no,amount);
    }
}






















