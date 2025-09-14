package ExceptionsPackage;

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

/*
 * Key Points:
 * 1. Checked exceptions must be caught or declared with throws
 * 2. Unchecked exceptions (RuntimeException) don't require explicit handling
 * 3. finally block always executes, regardless of whether exception occurs
 * 4. try-with-resources automatically closes resources implementing AutoCloseable
 * 5. Multiple catch blocks are evaluated in order - specific exceptions first
 * 6. throw keyword is used to explicitly throw an exception
 * 7. throws keyword declares that a method may throw certain exceptions
 * 8. Custom exceptions should extend Exception (checked) or RuntimeException (unchecked)
 * 9. Exception chaining preserves original exception information
 * 10. Never catch Exception or Throwable unless you have a specific reason
 *
 * Exception Types:
 * - Checked: IOException, SQLException, ClassNotFoundException
 * - Unchecked: NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException
 *
 * Best Practices:
 * - Handle exceptions at appropriate level
 * - Don't suppress exceptions without good reason
 * - Use specific exception types rather than generic Exception
 * - Clean up resources properly (use try-with-resources when possible)
 * - Log exceptions for debugging
 * - Don't use exceptions for control flow
 * - Provide meaningful error messages
 * - Consider exception chaining when rethrowing
 */