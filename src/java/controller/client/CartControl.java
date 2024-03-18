package controller.client;

import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Cart;
import model.CartProduct;
import model.User;

@WebServlet(name = "CartControl", urlPatterns = {"/cart"})
public class CartControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("account");

        if (acc == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        CartDAO cartDAO = new CartDAO();
        Cart c = cartDAO.get_Cart_By_Id(acc.getId());

        List<CartProduct> cartProducts = cartDAO.get_CartProduct_By_Cid(c);
        
        int totalMoney = cartDAO.totalMoneyCart(c);
        
        request.setAttribute("total", totalMoney);
        request.setAttribute("list", cartProducts);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }
    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        Cart c = cartDAO.get_Cart_By_Id(1021);
        int totalMoney = cartDAO.totalMoneyCart(c);
        System.out.println(totalMoney);
    }
}
