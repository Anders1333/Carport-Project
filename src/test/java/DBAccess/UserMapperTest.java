/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import FunctionLayer.Order;
import FunctionLayer.User;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.smartcardio.CardNotPresentException;

/**
 *
 * @author jonas
 */
public class UserMapperTest {

    private static Connection testConnection;
    private static String USER = "testinguser";
    private static String USERPW = "try1try2tryAgain";
    private static String DBNAME = "useradminTest";
    private static String HOST = "46.101.253.149";

    @Before
    public void setUp() throws SQLException {
        try {
            // awoid making a new connection for each test
            if (testConnection == null) {
                String ur1 = String.format("jdbc:mysql://165.227.138.161:3306/CarportDBTest", HOST, DBNAME);
                Class.forName("com.mysql.jdbc.Driver");

                testConnection = DriverManager.getConnection(ur1, USER, USERPW);
                // Make mappers use test 
                Connector.setConnection(testConnection);
            }
            // reset test database
            try (Statement stmt = testConnection.createStatement()) {
                stmt.execute("drop table if exists Users");
                stmt.execute("create table Users like UsersTest");
                stmt.execute("insert into Users select * from UsersTest");
            }

        } catch (ClassNotFoundException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull(testConnection);
    }

    @Test
    public void testGetUsers() throws CarportException{
        ArrayList<User> userList = UserMapper.getUsers();
        assertNotEquals(userList, null);
    }
    @Test
    public void testGetGeneretedOrder() throws CarportException{
        ArrayList<User> userList = UserMapper.getUsers();
        assertNotEquals(userList, null);
    }
    
    @Test
    public void testLogin01() throws CarportException {
        // Can we log in
        User user = UserMapper.login("Thomas", "fun");
        assertTrue(user != null);
    }

    @Test(expected = CarportException.class)
    public void testLogin02() throws CarportException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login("Andreas", "larsen");
    }

    @Test
    public void testLogin03() throws CarportException {
        User user = UserMapper.login("Jonas", "fun");
        assertEquals("customer", user.getRole());
    }

    @Test
    public void testCreateUser01() throws CarportException {
        DomainFacade.createUser("JohannesFog", "fun@email.com", "CarportIsLife", "12345678", "N");
        User retrieved = UserMapper.login("JohannesFog", "CarportIsLife");
        assertEquals("customer", retrieved.getRole());
    }

    @Test(expected = CarportException.class)
    public void testCreateUserNull() throws CarportException {
        DomainFacade.createUser(null, null, null, null, null);
        User retrieved = UserMapper.login("JohannesFog", "CarportIsLife");
    }
    
    

}
