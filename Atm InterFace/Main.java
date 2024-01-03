import java.util.*;
public class Main {
    public static void main(String[] args) {
       
      BankAccount userAccount = new BankAccount(10000);
      ATM atm = new ATM(userAccount);
      atm.start();
  
    }
}


