package PresentationLayer;

import FunctionLayer.DomainFacade;
import FunctionLayer.CarportException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws CarportException {
        String username = request.getParameter( "username");
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String email = request.getParameter( "email" );
        String phone = request.getParameter( "phone");
        
       
        if ( password1.equals( password2 ) ) {
            User user = DomainFacade.createUser( username,email, password1,phone, "N" );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new CarportException( "The two passwords did not match" );
        }
    }

}
