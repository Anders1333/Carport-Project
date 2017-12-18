
package DBAccess;

import FunctionLayer.Carport;
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


    /**
     * This method returns a single order from a given orderID.
     * @param orderId
     * @return Order
     * @throws CarportException 
     */
    public static Order getSingleOrder(int orderId) throws CarportException {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE Order_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Order order = new Order(
                        rs.getInt("Length"),
                        rs.getInt("Width"),
                        rs.getInt("Height"),
                        rs.getDouble("Roof_Incline"),
                        rs.getInt("shedDepth"));

                return order;
            } else {
                throw new CarportException("No order with that ID");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }

    }

    
    /**
     * This method saves a Users order in the database. The order consists of 
     * the measurements given by the user on the InputPage, along with a
     * calculated price and the users Username.
     * @param carport
     * @param user
     * @throws CarportException 
     */
    public static void saveOrder(Carport carport, User user) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Orders "
                    + "(User_name, Price, Length, Width, Height, Roof_Incline, shedDepth) "
                    + "VALUES (?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setDouble(2, 100);
            ps.setInt(3, carport.getLength());
            ps.setInt(4, carport.getWidth());
            ps.setInt(5, carport.getHeight());
            ps.setDouble(6, carport.getDegree());
            ps.setInt(7, carport.getShedDepth());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException("Kunne ikke placere din order");
        }

    }
    /**
     * This method creates a PackListObject from a given materials ID, amount and length 
     * @param materialId
     * @param amount
     * @param length
     * @return PackListObject
     * @throws CarportException 
     */
    public static PacklistObject getMaterial(int materialId, int amount, double length) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Materials WHERE Material_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, materialId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                String name = rs.getString("Material_name");
                String unit = rs.getString("Material_unit");
                String description = rs.getString("Material_description");
                double price = Math.ceil(rs.getDouble("Material_price") * amount * (length / 100));

                PacklistObject po = new PacklistObject(name, length, amount, unit, description, price);

                return po;

            } else {
                throw new CarportException("Could not get material info from Id: " + materialId);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }

    }

}
