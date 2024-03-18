package controller.client;

import dal.CartDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.OrderDetails;
import model.Status;

@WebServlet(name="PurchaseControl", urlPatterns={"/purchase"})
public class PurchaseControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        OrderDAO dao = new OrderDAO();
        List<Status> list = dao.getAllStatus();
        request.setAttribute("listStatus", list);
        request.getRequestDispatcher("purchase.jsp").forward(request, response);
    } 
}
