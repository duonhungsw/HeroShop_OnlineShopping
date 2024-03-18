package controller.admin;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;

@WebServlet(name="AdminCategoryControl", urlPatterns={"/adminCategory"})
public class AdminCategoryControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> listCategories = categoryDAO.getAllCategory();
        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("manageCategory.jsp").forward(request, response);
    } 

}
