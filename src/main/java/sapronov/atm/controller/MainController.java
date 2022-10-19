package sapronov.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCrypt;
import sapronov.atm.model.User;
import sapronov.atm.service.UserService;
import sapronov.atm.util.JwtUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "MainController", value = "/MainController")
public class MainController extends HttpServlet {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        String passwordHash = BCrypt.hashpw(password,BCrypt.gensalt());
//      BCrypt.checkpw(password, passwordHash);
        User user = new User(username, passwordHash);
        userService.saveUser(user);

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUser_name(), user.getPassword());
        authenticationManager.authenticate(token);
        String jwtToken = jwtUtil.generate(user.getUser_name());


//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/main-view.jsp");
//        requestDispatcher.forward(req, resp);
    }
}
