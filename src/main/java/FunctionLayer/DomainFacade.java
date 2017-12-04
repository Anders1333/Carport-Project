package FunctionLayer;

import DBAccess.MaterialMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;


public class DomainFacade {

    public static User login(String username, String password) throws CarportException {
        return UserMapper.login(username, password);
    }

    public static User createUser(String username, String email, String password, String phone, String generated) throws CarportException {
        User user = new User(username, email, password, phone, "customer", generated);
        UserMapper.createUser(user);
        
        return user;
    }

    

    public static ArrayList<User> getUsers() throws CarportException {

        ArrayList<User> userList = UserMapper.getUsers();

        return userList;
    }

    public static ArrayList<Order> getOrdersForUser(String username) throws CarportException {
        ArrayList<Order> Orders = UserMapper.getGeneratedOrders(username);
        
        return Orders;
    }

    public static Order getSingleOrder(int orderId) throws CarportException {

        Order order = MaterialMapper.getSingleOrder(orderId);
        return order;
    }

    public static double getTotalPrice(Carport carport) throws CarportException {
        return 100;
    
    }

    public static void saveOrder(User user, Carport carport) throws CarportException {
        MaterialMapper.saveOrder(carport, user);
        UserMapper.updateHas_Generated(user);
    
    
    }

}
