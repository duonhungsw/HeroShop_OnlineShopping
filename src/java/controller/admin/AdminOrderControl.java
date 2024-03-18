
package controller.admin;

import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Order;

@WebServlet(name="AdminOrderControl", urlPatterns={"/adminOrder"})
public class AdminOrderControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        OrderDAO dao = new OrderDAO();
        List<Order> list = dao.get_All_Order();
        request.setAttribute("listOrders",list);
        request.getRequestDispatcher("manageOrder.jsp").forward(request, response);
    } 
}
