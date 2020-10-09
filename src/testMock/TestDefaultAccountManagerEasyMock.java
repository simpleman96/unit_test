package testMock;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import appforTestMock.Account;
import appforTestMock.Configuration;
import appforTestMock.DefaultAccountManager2;



public class TestDefaultAccountManagerEasyMock
{
    private Log logger;

    private Configuration configuration;

    @Before
    public void setUp()
    {
        logger = createMock("logger", Log.class );
        configuration = createMock("configuration", Configuration.class );
    }

    @Test
    public void testFindAccountByUser()
    {
        expect( configuration.getSQL( "FIND_ACCOUNT_FOR_USER" ) ).andReturn( "SELECT .." );
        replay();
        
        DefaultAccountManager2 am = new DefaultAccountManager2( logger, configuration );
        
        @SuppressWarnings("unused")
        Account account = am.findAccountForUser( "1234" );

        // Perform asserts here
        // []
    }
}