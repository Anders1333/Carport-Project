/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( name = "FrontController", urlPatterns = { "/FrontController" } )
public class FrontController extends HttpServlet {

    /**
     Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    
    /*
      Denne metode checker hvilken command der er blevet sendt fra forms (eks."login")
      * Derefter kører den den gældende servlet for commanden. 
      * Hvis command ikke findes, smides der en exception og man sendes tilbage til forsiden.
     */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {
            Command action = Command.from( request );
            // "action.execute" becomes eks. "register.execute"
            String view = action.execute( request, response );
            // This execution has a return value. for register it is "role + page".
            request.getRequestDispatcher( "/WEB-INF/" + view + ".jsp" ).forward( request, response );
            // So we end up in the page for which role the user is registered as.
        } catch ( CarportException ex ) {
            request.setAttribute( "error", ex.getMessage() );
            request.getRequestDispatcher( "index.jsp" ).forward( request, response );
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     Handles the HTTP <code>GET</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Handles the HTTP <code>POST</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        processRequest( request, response );
    }

    /**
     Returns a short description of the servlet.

     @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
