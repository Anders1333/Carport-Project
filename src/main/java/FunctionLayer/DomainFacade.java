package FunctionLayer;

import DBAccess.UserMapper;
import FunctionLayer.CarportCalculator;

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

    public static double calculateBox(int length, int width, int height) throws CarportException {
        return CarportCalculator.CalculatePrice(length, width, height);
    }

    public static double getRoofHypotenuse(int length, int width, double degree) throws CarportException {
        return CarportCalculator.getRoofHypotenuse(length, width, degree);

    }

    public static double getRoofArea(double roofWidth, int length) throws CarportException {
        return CarportCalculator.getRoofArea(roofWidth, length);
    }

    public static int getVerticalPoles(int length) throws CarportException {
        return CarportCalculator.getVerticalPoles(length);

    }

    public static int getHorizontalPoles(int length, int width) throws CarportException {
        return CarportCalculator.getHorizontalPoles(length, width);
    }

}
