package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import FunctionLayer.Order;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndersHC
 */
public class OrderGetter extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {
        request.setAttribute("currentPath", "/WEB-INF/employee.jsp");
        String username = request.getParameter("Username");
        ArrayList<Order> Orders = DomainFacade.getOrdersForUser(username);
        request.setAttribute("orderList", Orders);
        return "customerorderspage";
    }

}
