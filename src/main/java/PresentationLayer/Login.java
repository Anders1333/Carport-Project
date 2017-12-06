package PresentationLayer;

import FunctionLayer.DomainFacade;
import FunctionLayer.CarportException;
import FunctionLayer.User;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws CarportException {

        HttpSession session = request.getSession();
        request.setAttribute("currentPath", "index.jsp");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DomainFacade.login(username, password);
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());

        //Generate List of users if employee is logging in//
        if ("employee".equalsIgnoreCase(user.getRole())) {
            ArrayList<User> userList = DomainFacade.getUsers();
            request.setAttribute("userList", userList);
        }

        return user.getRole() + "page";

    }
}
