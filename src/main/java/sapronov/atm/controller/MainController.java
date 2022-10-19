package sapronov.atm.controller;

import org.springframework.security.crypto.bcrypt.BCrypt;
import sapronov.atm.model.User;
import sapronov.atm.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainController", value = "/MainController")
public class MainController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        String passwordHash = BCrypt.hashpw(password,BCrypt.gensalt());
//      BCrypt.checkpw(password, passwordHash);
        User user = new User(username, passwordHash);
        userService.saveUser(user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/main-view.jsp");
        requestDispatcher.forward(req, resp);
    }
}
