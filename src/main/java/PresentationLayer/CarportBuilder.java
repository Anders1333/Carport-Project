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
        int shedChecked = Integer.parseInt(request.getParameter("toolshed"));
        Carport carport;
        
        if (shedChecked == 1) {
            int shedDepth = Integer.parseInt(request.getParameter("depth"));
            carport = new Carport(length, width, height, degree, shedDepth);
        } else {
            carport = new Carport(length, width, height, degree);

        }
        double totalPrice = DomainFacade.getTotalPrice(carport);
        
        request.setAttribute("carport", carport);
        request.setAttribute("totalPrice", totalPrice);
        return "offerpage";

    }
}
