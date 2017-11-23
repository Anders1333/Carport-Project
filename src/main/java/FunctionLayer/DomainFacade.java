package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.UserMapper;
import FunctionLayer.CarportCalculator;
import java.util.ArrayList;

/**
 * The purpose of DomainFacade is to...
 *
 * @author kasper
 */
public class DomainFacade {

    public static User login(String username, String password) throws CarportException {
        return UserMapper.login(username, password);
    }

    public static User createUser(String username, String email, String password, String phone) throws CarportException {
        User user = new User(username, email, password, phone, "customer");
        UserMapper.createUser(user);
        return user;
    }

    
    //------------------------------------------
     public static Carport calculateMaterials(int length, int width,  int height,double degree) throws CarportException {
        Carport carport = CarportCalculator.CalculateMaterials(length, width, height,degree);
        
        return carport;
    }

     
    public static ArrayList<User> getUsers() throws CarportException{
        
        ArrayList<User> userList = UserMapper.getUsers();
        
        
        return userList;
    }
    
    
    public static ArrayList<Order> getOrdersForUser (String username) throws CarportException{
        ArrayList<Order> Orders = UserMapper.getOrdersForUser(username);
        return Orders;
    }

    public static Order getSingleOrder(int orderId) throws CarportException {
        
        Order order = MaterialMapper.getSingleOrder(orderId);
        
        return order;
    }

   

}
