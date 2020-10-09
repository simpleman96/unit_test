package appforTestMock;

public class AccountService
{
    /**
     * The account manager implementation to use.
     */
    private AccountManager accountManager;

    /**
     * A setter method to set the account manager implementation.
     * 
     * @param manager
     */
    public void setAccountManager( AccountManager manager )
    {
        this.accountManager = manager;
    }

    /**
     * A transfer method which transfers the amount of money 
     * from the account with the senderId to the account of
     * beneficiaryId.
     * 
     * @param senderId
     * @param beneficiaryId
     * @param amount
     */
    public void transfer( String senderId, String beneficiaryId, long amount )
    {
        Account sender = this.accountManager.findAccountForUser( senderId );
        Account beneficiary = this.accountManager.findAccountForUser( beneficiaryId );

        sender.debit( amount );
        beneficiary.credit( amount );
        this.accountManager.updateAccount( sender );
        this.accountManager.updateAccount( beneficiary );
    }
}