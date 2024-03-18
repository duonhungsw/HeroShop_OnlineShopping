package controller.client;

import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@WebServlet(name = "UpdateCartControl", urlPatterns = {"/updateQuantityCart"})
public class UpdateQuantiyCartControl extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Enumeration<String> parameterName = request.getParameterNames();
        while (parameterName.hasMoreElements()) {
            String paraName = parameterName.nextElement();
            if (paraName.startsWith("quantity_")) {
                CartDAO cartDAO = new CartDAO();
                
                int cartProductId = Integer.parseInt(paraName.substring("quantity_".length()));
                int quantityNew = Integer.parseInt(request.getParameter(paraName));
                cartDAO.updateQuantityCartProduct(quantityNew, cartProductId);

            }
        }
        response.sendRedirect("cart");
    }
    
}
