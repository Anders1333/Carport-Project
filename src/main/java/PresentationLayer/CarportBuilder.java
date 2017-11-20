/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AndersHC
 */
public class CarportBuilder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
           int length = Integer.parseInt(request.getParameter("length"));
           int width = Integer.parseInt(request.getParameter("width"));
           int height = Integer.parseInt(request.getParameter("height"));
           
          double totalPrice =  DomainFacade.calculateBox(length, width, height);
           
            HttpSession session = request.getSession();
            
            session.setAttribute("totalprice", totalPrice);
            
            return "offerpage";
    }
    
}
