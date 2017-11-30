/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndersHC
 */
public class PackListGetter extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {

        int orderId = Integer.parseInt(request.getParameter("orderId"));
//        

        Order order = DomainFacade.getSingleOrder(orderId);
        Carport Carport = new Carport(order.getLength(), order.getWidth(), order.getHeight(), order.getRoofIncline(), order.getShedDepth());

        request.setAttribute("carport", Carport);

        return "packlistpage";
    }

}
