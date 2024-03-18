package controller.admin;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet(name="adminInfoControl", urlPatterns={"/adminInfo"})
public class AdminInfoControl extends HttpServlet {
    private static final String  ADMIN_PAGE="admininfo.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
        } catch (Exception e) {
            log("Error at AdminInfo: " +e.toString());
        }
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            User acc = (User) session.getAttribute("account");
            AccountDAO accountDAO = new AccountDAO();
            request.getRequestDispatcher(ADMIN_PAGE).forward(request, response);
        } catch (Exception e) {
        }
        
    }
}
