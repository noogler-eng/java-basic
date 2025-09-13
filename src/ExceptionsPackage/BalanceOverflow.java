package ExceptionsPackage;

public class BalanceOverflow extends Exception{
    private final float availableBalance;

    public BalanceOverflow(String msg, float balance){
        super(msg);
        this.availableBalance = balance;
    }

    public float getAvailableBalance(){
        return availableBalance;
    }
}
