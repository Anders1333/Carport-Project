package FunctionLayer;

import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String username, String password ) throws CarportException {
        return UserMapper.login( username, password );
    } 

    public static User createUser( String username,String email, String password, String phone ) throws CarportException {
        User user = new User(username,email, password,phone, "customer");
        UserMapper.createUser( user );
        return user;
    }

}
