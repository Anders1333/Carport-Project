/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Carport;
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
        double degree = Integer.parseInt(request.getParameter("degree"));

       
        Carport carport = new Carport(length, width, height, degree);
        
       request.setAttribute("carport", carport);
       
//         Carport carport = DomainFacade.calculateMaterials(length,width,height,degree);
//          
//         request.setAttribute("width",width);
//         request.setAttribute("height",height);
//         request.setAttribute("carport", carport);
//         HttpSession session = request.getSession();
//         session.setAttribute("totalprice",carport.getPrice());

        
      
//        double totalPrice = DomainFacade.calculateBox(length, width, height);
//        session.setAttribute("totalprice", totalPrice);
        return "offerpage";
    }

}
