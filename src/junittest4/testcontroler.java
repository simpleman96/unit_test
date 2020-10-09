package junittest4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import app2.DefaultController;
import app2.ErrorResponse;
import app2.Request;
import app2.RequestHandler;
import app2.Response;

public class testcontroler {
    private DefaultController controller;

    private Request request;

    private RequestHandler handler;

    @Before
    public void initialize()
        throws Exception
    {
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();

        controller.addHandler( request, handler );
    }

    @Test
    public void testAddHandler()
    {
        RequestHandler handler2 = controller.getHandler( request );
        assertSame( "Controller.getHandler must return the samplehandler", handler2, handler );
    }

    @Test
    public void testProcessRequest()
    {
        Response response = controller.processRequest( request );
        assertNotNull( "Must not return a null response", response );
        assertEquals( "", new SampleResponse(), response );
    }

    @Test
    public void testProcessRequestAnswersErrorResponse()
    {
        SampleRequest request = new SampleRequest( "testError" );
        SampleExceptionHandler handler = new SampleExceptionHandler();
        controller.addHandler( request, handler );
        Response response = controller.processRequest( request );

        assertNotNull( "Must not return a null response", response );
        assertEquals( ErrorResponse.class, response.getClass() );
    }

    @Test( expected = RuntimeException.class )
    public void testGetHandlerNotDefined()
    {
        SampleRequest request = new SampleRequest( "testNotDefined" );

        controller.getHandler( request );
    }

    @Test( expected = RuntimeException.class )
    public void testAddRequestDuplicateName()
    {
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();

        controller.addHandler( request, handler );
    }

    @Test( timeout = 130 )
    @Ignore( value = "Skip for now" )
    public void testProcessMultipleRequestsTimeout()
    {
        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleHandler();
        for ( int i = 0; i < 99999; i++ )
        {
            request = new SampleRequest( String.valueOf( i ) );
            controller.addHandler( request, handler );
            response = controller.processRequest( request );
            assertNotNull( response );
            assertNotSame( ErrorResponse.class, response.getClass() );
        }
    }

    //implement inners
    private class SampleRequest implements Request {
        private static final String DEFAULT_NAME = "Test";

        private String name;

        public SampleRequest( String name )
        {
            this.name = name;
        }

        public SampleRequest()
        {
            this( DEFAULT_NAME );
        }

        public String getName()
        {
            return this.name;
        }
    }

    private class SampleExceptionHandler implements RequestHandler {
        public Response process( Request request )
            throws Exception
        {
            throw new Exception( "error processing request" );
        }
    }

    private class SampleResponse implements Response {
        private static final String DEFAULT_NAME = "Test";

        private String name;

        public String getName()
        {
            return this.name;
        }

        public SampleResponse( String name )
        {
            this.name = name;
        }

        public SampleResponse()
        {
            this( DEFAULT_NAME );
        }

        public boolean equals( Object object )
        {
            boolean result = false;
            if ( object instanceof SampleResponse )
            {
                result = ( (SampleResponse) object ).getName().equals( getName() );
            }
            return result;
        }

        public int hashCode()
        {
            return this.name.hashCode();
        }
    }

    private class SampleHandler implements RequestHandler {
        public Response process( Request request )
            throws Exception
        {
            return new SampleResponse();
        }
    }
}