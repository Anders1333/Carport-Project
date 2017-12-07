/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportCalculator;
import FunctionLayer.CarportException;
import FunctionLayer.Order;
import FunctionLayer.PacklistObject;
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
                     rs.getDouble("Roof_Incline"),
                     rs.getInt("shedDepth"));
                    
                     
               return order;
            } else {
                throw new CarportException( "No order with that ID" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new CarportException(ex.getMessage());
        }
        
       
    }

    public static void saveOrder(Carport carport, User user) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders "
                    + "(User_name, Price, Status, Length, Width, Height, Roof_Incline, shedDepth) "
                    +   "VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setDouble(2, 100);
            ps.setString(3, "generated");
            ps.setInt(4, carport.getLength());
            ps.setInt(5, carport.getWidth());
            ps.setInt(6, carport.getHeight());
            ps.setDouble(7, carport.getDegree());
            ps.setInt(8, carport.getShedDepth());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException("Kunne ikke placere sdin order");
        }
    
    
    }

    public static PacklistObject getMaterial(int materialId,int amount,double length) throws CarportException {
            try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Materials WHERE Material_id = ?;";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setInt( 1, materialId );
            
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
               
                String name = rs.getString("Material_name");
                String unit = rs.getString("Material_unit");
                String description = rs.getString("Material_description");
                double price = Math.ceil(rs.getDouble("Material_price")*amount*(length/100)) ;
                
                PacklistObject po = new PacklistObject(name,length,amount,unit,description,price);
                
                return po;
                
            } else {
                throw new CarportException( "Could not get material info from Id: "+ materialId );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new CarportException(ex.getMessage());
        }
        
    }


   

   

    
}
