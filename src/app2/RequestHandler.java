package app2;

public interface RequestHandler
{
    Response process( Request request ) throws Exception;
}