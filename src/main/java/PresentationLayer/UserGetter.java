/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        HttpSession session = request.getSession();
        session.setAttribute( "userList", userList );
        
        return "employeepage";
    }
    
}
