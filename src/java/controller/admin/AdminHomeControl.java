

package controller.admin;

import dal.AccountDAO;
import dal.OrderDAO;
import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Order;
import model.Product;
import model.User;

@WebServlet(name="AdminHomeControl", urlPatterns={"/adminHome"})
public class AdminHomeControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AccountDAO dao = new AccountDAO();
        List<User> accountList = dao.getAllAccount();
        
        OrderDAO orderDAO = new OrderDAO();
        List<Order> listOrders = orderDAO.get_All_Order();
        
        ProductDAO productDAO = new ProductDAO();
        List<Product> listProducts = productDAO.getAll();
        
        request.setAttribute("listAccounts", accountList);
        request.setAttribute("listOrders", listOrders);
        request.setAttribute("listProducts", listProducts);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
        
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AccountDAO dao = new AccountDAO();
        List<User> accountList = dao.getAllAccount();
        
        OrderDAO orderDAO = new OrderDAO();
        List<Order> listOrders = orderDAO.get_All_Order();
        
        ProductDAO productDAO = new ProductDAO();
        List<Product> listProducts = productDAO.getAll();
        
        request.setAttribute("listAccounts", accountList);
        request.setAttribute("listOrders", listOrders);
        request.setAttribute("listProducts", listProducts);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
        
    } 

}
