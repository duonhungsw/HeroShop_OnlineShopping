package controller.client;

import dal.CartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="DeleteProductCart", urlPatterns={"/deleteProductCart"})
public class DeleteProductCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        CartDAO cart = new CartDAO();
        int id;
        try {
            id = Integer.parseInt(id_draw);
            cart.deleteCartProduct(id);
            response.sendRedirect("cart");
        } catch (Exception e) {
        }
    } 
}
