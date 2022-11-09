package sapronov.atm.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ValidationController", value = "/api")
public class ValidationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("user_name");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher;
        if(username.length() > 16
                || username.length() < 2
                || password.length() > 16
                || password.length() < 8){
            requestDispatcher = req.getRequestDispatcher("/view/register.jsp");
        }
        else{
            requestDispatcher = req.getRequestDispatcher("/api/home");
        }
        requestDispatcher.forward(req, resp);
    }
}
