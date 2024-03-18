package controller.admin;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;

@WebServlet(name = "AddCategoryControl", urlPatterns = {"/addCategory"})
public class AddCategoryControl extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cateName = request.getParameter("cName");
        CategoryDAO categoryDAO = new CategoryDAO();
        Category c = new Category();
        c.setName(cateName);
        categoryDAO.insert_Category(c);
        response.sendRedirect("adminCategory");
    }

}
