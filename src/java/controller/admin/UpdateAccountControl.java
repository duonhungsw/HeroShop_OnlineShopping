package controller.admin;

import dal.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "UpdateAccountControl", urlPatterns = {"/updateAccount"})
public class UpdateAccountControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        int id;
        AccountDAO accountDAO = new AccountDAO();
        try {
            id = Integer.parseInt(id_draw);
            User u = accountDAO.checkId(id);
            request.setAttribute("account", u);
            request.getRequestDispatcher("updateAccount.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_draw = request.getParameter("accountId");
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String role_draw = request.getParameter("role");
        int id, role;

        AccountDAO accountDAO = new AccountDAO();
        try {
            id = Integer.parseInt(id_draw);
            role = Integer.parseInt(role_draw);
            User unew = new User(id, name, pass, email, phone, address, role);
            accountDAO.updateAcconut(unew);
            response.sendRedirect("adminAccount");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
