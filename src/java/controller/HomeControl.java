package controller;

import dal.PaginationDAO;
import dal.ProductDAO;
import dal.SearchDAO;
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

@WebServlet(name = "HomeControl", urlPatterns = {"/home"})
public class HomeControl extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProductDAO dao = new ProductDAO();

        List<Product> listP = dao.getAll();  
        request.setAttribute("listP", listP);
        // gui tu user session cateList: de ma sau khi login hien het cate
        List<Category> listC = dao.getAllCategory();
        session.setAttribute("listC", listC);
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}

