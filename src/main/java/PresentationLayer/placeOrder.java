/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DD
 */
public class placeOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String street = request.getParameter("street");
        String streetNr = request.getParameter("streetNr");
        String floor = request.getParameter("floor");
        String city = request.getParameter("city");
        String zip = request.getParameter("zip");
        String country = request.getParameter("country");

        if(DomainFacade.checkAddress(user) == null) {

            DomainFacade.saveAddress(
                    user,
                    street,
                    streetNr,
                    floor,
                    city,
                    zip,
                    country);
        }

        return "invoicepage";

    }

}
