package appforTestMock;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class DefaultAccountManager1 implements AccountManager {
/**
 * Logger instance.
 */
private static final Log LOGGER = LogFactory.getLog( DefaultAccountManager1.class );

/**
 * Finds an account for user with the given userID.
 * 
 * @param
 */
public Account findAccountForUser( String userId )
{
    LOGGER.debug( "Getting account for user [" + userId + "]" );
    ResourceBundle bundle = PropertyResourceBundle.getBundle( "technical" );
    String sql = bundle.getString( "FIND_ACCOUNT_FOR_USER" );

    // Some code logic to load a user account using JDBC
    // []
    return null;
}

/**
 * Updates the given account.
 * 
 * @param
 */
public void updateAccount( Account account )
{
    // Perform database access here
}
}