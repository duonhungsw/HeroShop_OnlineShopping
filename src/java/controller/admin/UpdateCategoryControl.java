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

@WebServlet(name="UpdateCategoryControl", urlPatterns={"/updateCategory"})
public class UpdateCategoryControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        int id;
        CategoryDAO categoryDAO  =new CategoryDAO();
        try {
            id  =Integer.parseInt(id_draw);
            Category c = categoryDAO.check_Category_By_Id(id);
            request.setAttribute("category", c);
            request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
            
        } catch (Exception e) {
        }
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        String nameC = request.getParameter("name");
        CategoryDAO categoryDAO  =new CategoryDAO();
        int id;
        try {
            id = Integer.parseInt(id_draw);
            Category cUpdate = new Category(id, nameC);
            categoryDAO.update_Category(cUpdate);
            response.sendRedirect("adminCategory");
        } catch (Exception e) {
        }
        
    }

}
