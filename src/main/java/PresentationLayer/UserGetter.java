
package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AndersHC
 */
public class UserGetter extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
       
        ArrayList<User> userList = DomainFacade.getUsers();
        request.setAttribute( "userList", userList );
        
        return "employeepage";
    }
    
}
