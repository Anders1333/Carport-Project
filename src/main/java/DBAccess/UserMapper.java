package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of UserMapper is to...
 *
 * @author AndersHC
 */
public class UserMapper {

    public static void createUser(User user) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (User_name, User_password, User_phone, User_email, User_role) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getRole());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static User login(String username, String password) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT User_role FROM Users "
                    + "WHERE User_name=? AND User_password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("User_role");

                User user = new User(username, password, role);

                return user;
            } else {
                throw new CarportException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException(ex.getMessage());
        }
    }

    public static ArrayList<User> getUsers() throws CarportException {

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Users WHERE User_role = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "customer");
            ResultSet rs = ps.executeQuery();
            ArrayList<User> userList = new ArrayList<>();

            while (rs.next()) {
                User user = new User(
                        rs.getString("User_name"),
                        rs.getString("User_email"),
                        rs.getString("User_password"),
                        rs.getString("User_phone"),
                        rs.getString("User_role"),
                        rs.getString("User_hasGenerated"));

                userList.add(user);
            }
            return userList;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException("Couldnt get Users");
        }

    }

    public static ArrayList<Order> getGeneratedOrders(String username) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM Orders WHERE User_name = ? and status = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, username);
            ps.setString(2, "generated");

            ResultSet rs = ps.executeQuery();
            ArrayList<Order> orderList = new ArrayList<>();

            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("Order_id"),
                        rs.getString("User_name"),
                        rs.getDouble("Price"),
                        rs.getString("Date"),
                        rs.getString("Status"));
                orderList.add(order);
            }
            return orderList;

        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException("Couldnt get Orders for " + username);
        }

    }

    public static void updateHas_Generated(User user) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE Users"
                    + "SET User_hasGenerated = 'Y'"
                    + "WHERE User_name = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, "Y");

        } catch (ClassNotFoundException | SQLException ex) {
            throw new CarportException("Something went wrong, please try again later.");
        }
    }

    public static void saveAddress(User user, String street, String streetNr, String floor, String city, String zip, String country) throws CarportException {
        try {

            Connection con = Connector.connection();
            String SQL = "INSERT INTO Addresses"
                    + "(User_name, Street, Streetnumber, Floor, City, Zip, Country)"
                    + "values (?,?,?,?,?,?,?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, street);
            ps.setString(3, streetNr);
            ps.setString(4, floor);
            ps.setString(5, city);
            ps.setString(6, zip);
            ps.setString(7, country);
            ps.execute();

        } catch (ClassNotFoundException | SQLException e) {
            throw new CarportException("Could not place your order, try again later");

        }

    }

    public static String checkAddress(User user) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "Select * FROM Addresses WHERE User_name = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("User_name");

            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new CarportException("Could not validate the Address");
        }

    }

}
