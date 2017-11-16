package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.CarportException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws CarportException {
        String username = request.getParameter( "username" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( username, password );
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        return user.getRole() + "page";
    }

}
