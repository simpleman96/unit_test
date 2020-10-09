package appforTestMock;

public class Account
{
    /**
     * The id of the account.
     */
    private String accountId;

    /**
     * The balance of the account.
     */
    private long balance;

    /**
     * A constructor.
     * 
     * @param accountId
     * @param initialBalance
     */
    public Account( String accountId, long initialBalance )
    {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    /**
     * Withdraw the amount from the account.
     * 
     * @param amount
     */
    public void debit( long amount )
    {
        this.balance -= amount;
    }

    /**
     * Add the amount of money in the account.
     * 
     * @param amount
     */
    public void credit( long amount )
    {
        this.balance += amount;
    }

    /**
     * What's the balance of the account?
     * 
     * @return
     */
    public long getBalance()
    {
        return this.balance;
    }
}