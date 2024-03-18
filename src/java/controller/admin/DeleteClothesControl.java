package controller.admin;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet(name="DeleteClothesControl", urlPatterns={"/deleteClothes"})
public class DeleteClothesControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       ProductDAO productDAO = new ProductDAO();
       String id_draw = request.getParameter("id");
       int id;
        try {
            id = Integer.parseInt(id_draw);
            productDAO.deleteCartProduct(id);
            response.sendRedirect("adminClothes");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    } 

}
