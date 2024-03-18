package controller;

import dal.CartDAO;
import dal.LoginDAO;
import dal.ProductDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Cart;
import model.Category;
import model.Product;
import model.User;

@WebServlet(name = "signinController", urlPatterns = {"/login"})
public class SigninController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();
        int timeoutInSeconds = 1800;
        session.setMaxInactiveInterval(timeoutInSeconds);
        LoginDAO loginDAO = new LoginDAO();
        try {
            User user = loginDAO.login(name, pass);
            if (user == null) {
                request.setAttribute("exist", "Wrong username or password!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                session.setAttribute("account", user);
                CartDAO cart = new CartDAO();
                int userid = user.getId();
                if (user.getRole() == 0) {
                    response.sendRedirect("adminHome");
                } else if (user.getRole() == 1) {
                    ProductDAO dao = new ProductDAO();
                    List<Category> listC = dao.getAllCategory();
                    session.setAttribute("listC", listC);
                    response.sendRedirect("home");
                }
            }
        } catch (IOException e) {
            System.out.println(e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while logging in");
        }
    }
}
