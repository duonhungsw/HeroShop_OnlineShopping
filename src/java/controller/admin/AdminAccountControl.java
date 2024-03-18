package controller.admin;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.User;

@WebServlet(name="AdminAccountControl", urlPatterns={"/adminAccount"})
public class AdminAccountControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        AccountDAO dao = new AccountDAO();
        List<User> accountList = dao.getAllAccount();
        request.setAttribute("listAccounts", accountList);
        request.getRequestDispatcher("manageAccount.jsp").forward(request, response);
    } 

}
