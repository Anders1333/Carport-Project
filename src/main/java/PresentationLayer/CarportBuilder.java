
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

        
         Carport carport = DomainFacade.calculateMaterials(length,width,height,degree);
          
         request.setAttribute("width",width);
         request.setAttribute("height",height);
         request.setAttribute("carport", carport);
         HttpSession session = request.getSession();
         session.setAttribute("totalprice",carport.getPrice());

        return "offerpage";
    }

}
