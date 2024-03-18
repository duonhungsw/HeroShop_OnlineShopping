

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
import model.Order;
import model.OrderDetails;

@WebServlet(name="BillControl", urlPatterns={"/bill"})
public class BillControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAO();
        Order order = orderDAO.getBillOrder();
        
        CartDAO cartDAO  =new CartDAO();
        List<OrderDetails> list = cartDAO.getBillDetailses();
        request.setAttribute("order", order);
        request.setAttribute("list", list);
        request.getRequestDispatcher("bill.jsp").forward(request, response);
    } 


}
