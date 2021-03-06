package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import FunctionLayer.PacklistObject;
import FunctionLayer.User;
import java.util.ArrayList;
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
        
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        double degree = Integer.parseInt(request.getParameter("degree"));
        int shedChecked = Integer.parseInt(request.getParameter("toolshed"));
        Carport carport = new Carport(length, width, height, degree);

        if (shedChecked == 1) {
            int shedDepth = Integer.parseInt(request.getParameter("depth"));
            carport.setShedDepth(shedDepth);
        }
        
        ArrayList<PacklistObject> PLO = DomainFacade.makePackList(carport);
        request.setAttribute("price", DomainFacade.getTotalPrice(PLO));
        request.setAttribute("carport", carport);
        
        if (user != null) {
            DomainFacade.saveOrder(user, carport);
        }

        return "offerpage";

    }
}
