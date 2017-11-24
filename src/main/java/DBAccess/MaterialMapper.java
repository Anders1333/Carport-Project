/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AndersHC
 */
public class MaterialMapper {
    
    public static double getPrice(int id) throws CarportException{
         try {
            Connection con = Connector.connection();
            String SQL = "SELECT Material_price from Materials WHERE Material_id = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, id );
            
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                double materialPrice = rs.getFloat("Material_price");
               return materialPrice;
            } else {
                throw new CarportException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static Order getSingleOrder(int orderId) throws CarportException {
        
            try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE Order_id = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, orderId );
            
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
             Order order = new Order( 
                     rs.getInt("Length"),
                     rs.getInt("Width"),
                     rs.getInt("Height"),
                     rs.getDouble("Roof_Incline"));
                    
                     
               return order;
            } else {
                throw new CarportException( "No order with that ID" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new CarportException(ex.getMessage());
        }
        
       
    }
}
