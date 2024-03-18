
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
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.util.List;
import model.Cart;
import model.CartProduct;
import model.Order;
import model.OrderDetails;
import model.User;


@WebServlet(name="CheckOutControl", urlPatterns={"/checkOut"})
public class CheckOutControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc= (User) session.getAttribute("account");
        CartDAO cartDAO = new CartDAO();
        Cart c  = cartDAO.get_Cart_By_Id(acc.getId());
        List<CartProduct> listCart  =cartDAO.get_CartProduct_By_Cid(c);
        int totalMoney = cartDAO.totalMoneyCart(c);
        request.setAttribute("total", totalMoney);
        request.setAttribute("listCP", listCart);
        request.getRequestDispatcher("checkOut.jsp").forward(request, response);
    }
    
}
