package sapronov.atm.controller;
import sapronov.atm.model.Account;
import sapronov.atm.model.Role;
import sapronov.atm.model.User;
import sapronov.atm.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        User user = new User("Ivan", "b32dib32q");
        userService.saveUser(user);
        Role role = new Role("Admin");
        user.setRole(role);
        Account account = new Account(3179);
        user.setAccount(account);
        userService.updateUser(user);
    }
}
