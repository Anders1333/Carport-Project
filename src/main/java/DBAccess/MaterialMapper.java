/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
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
    
    public static double getMeterPrice(int id) throws CarportException{
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
}
