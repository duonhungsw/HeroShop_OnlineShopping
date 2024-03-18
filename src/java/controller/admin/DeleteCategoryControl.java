package controller.admin;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="DeleteCategoryControl", urlPatterns={"/deleteCategory"})
public class DeleteCategoryControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        int id;
        CategoryDAO categoryDAO  =new  CategoryDAO();
        try {
            id = Integer.parseInt(id_draw);
            categoryDAO.delete_Category(id);
            response.sendRedirect("adminCategory");
        } catch (Exception e) {
        }
    } 

}
