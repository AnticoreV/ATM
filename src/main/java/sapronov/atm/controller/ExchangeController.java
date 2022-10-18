package sapronov.atm.controller;

import sapronov.atm.model.CurrencyRate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ExchangeController", value = "/ExchangeController")
public class ExchangeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrencyRate currencyRate = new CurrencyRate();
        PrintWriter writer = resp.getWriter();
        writer.write(currencyRate.getCurrency());
    }
}
