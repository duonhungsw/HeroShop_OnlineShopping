package controller.admin;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Category;
import model.Product;
@WebServlet(name="AdminClothesControl", urlPatterns={"/adminClothes"})
public class AdminClothesControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session  =request.getSession();
        ProductDAO productDAO = new ProductDAO();
        List<Product> listProducts = productDAO.getAll();
        List<Category> listCategories = productDAO.getAllCategory();
        
        session.setAttribute("listCategories", listCategories);
        request.setAttribute("listProducts", listProducts);
        request.getRequestDispatcher("manageClothes.jsp").forward(request, response);
    } 


}
