package FunctionLayer;

import DBAccess.UserMapper;
import FunctionLayer.CarportCalculator;

/**
 * The purpose of DomainFacade is to...
 * @author kasper
 */
public class DomainFacade {

    public static User login( String username, String password ) throws CarportException {
        return UserMapper.login( username, password );
    } 

    public static User createUser( String username,String email, String password, String phone ) throws CarportException {
        User user = new User(username,email, password,phone, "customer");
        UserMapper.createUser( user );
        return user;
    }
    
    public static double calculateBox (int length, int width, int height) throws CarportException{
        return CarportCalculator.CalculatePrice(length, width, height);   
    }

}
