package PresentationLayer;

import FunctionLayer.CarportException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws CarportException {
        String msg = "Unknown command";
        throw new CarportException( msg );
    }

}
