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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurrencyRate currencyRate = new CurrencyRate();
        PrintWriter writer = response.getWriter();
        writer.write(currencyRate.getCurrency());
    }
}
