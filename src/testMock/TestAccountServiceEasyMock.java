package testMock;

import static org.junit.Assert.assertEquals;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.verify;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import appforTestMock.Account;
import appforTestMock.AccountManager;
import appforTestMock.AccountService;


public class TestAccountServiceEasyMock
{
    private AccountManager mockAccountManager;

    @Before
    public void setUp()
    {
        mockAccountManager = createMock("mockAccountManager", AccountManager.class );
    }

    @Test
    public void testTransferOk()
    {
        Account senderAccount = new Account( "1", 200 );
        Account beneficiaryAccount = new Account( "2", 100 );

        mockAccountManager.updateAccount( senderAccount );
        mockAccountManager.updateAccount( beneficiaryAccount );

        expect( mockAccountManager.findAccountForUser( "1" ) ).andReturn( senderAccount );
        expect( mockAccountManager.findAccountForUser( "2" ) ).andReturn( beneficiaryAccount );
        replay( mockAccountManager );

        AccountService accountService = new AccountService();
        accountService.setAccountManager( mockAccountManager );
        accountService.transfer( "1", "2", 50 );

        assertEquals( 150, senderAccount.getBalance() );
        assertEquals( 150, beneficiaryAccount.getBalance() );
    }

    @After
    public void tearDown()
    {
        verify( mockAccountManager );
    }
}