package ExceptionsPackage;

import java.util.*;
import java.io.*;

public class BankAccount {
    float balance;

    // Exception is a checked exception in Java.
    // If you throw new Exception(...) inside a method, the method must either:
    // - Handle it with a try–catch inside the method, OR
    // - Declare it using throws Exception in the method signature.
    BankAccount(float amount){
        this.balance = amount;
        System.out.println("Constructor Called:  " + amount);
    }

    // this is run time exception, we can use throws
    // - If you don’t want to use throws every time, you can throw an unchecked exception:
    // RuntimeException
    // - Cleaner approach: use RuntimeException
    // - Now the caller can still use try–catch, but you don’t need throws in the method signature.
    public void withdraw(float amount) throws Exception{
        if(balance >= amount){
            balance -= amount;
            System.out.println("Withdraw successful. Remaining balance: " + balance);
        }else{
            throw new Exception("Insufficient Balance");
        }
    }

    public void deposit(float amount) throws BalanceOverflow{
        if(amount <= 2000.00){
            balance += amount;
            System.out.println("Deposit successful. Remaining balance: " + balance);
        }else{
            throw new BalanceOverflow("Balance overflow error", balance);
        }
    }
}
