/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.DomainFacade;
import FunctionLayer.Order;
import FunctionLayer.PacklistObject;
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
public class MaterialMapperTest {

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
    public void testSaveOrders() throws CarportException {
        Carport carport = new Carport(300, 300, 300, 25, 60);
        User user = new User("Jonas", "fun", "33345678", "fun@email.com", "customer", "N");
        MaterialMapper.saveOrder(carport, user);
    }

    @Test(expected = CarportException.class)
    public void testGetMatiralWithWrongId() throws CarportException {
        MaterialMapper.getMaterial(777, 78, 9);
    }

}
