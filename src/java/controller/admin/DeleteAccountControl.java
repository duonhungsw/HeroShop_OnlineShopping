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
@WebServlet(name="DeleteAccountControl", urlPatterns={"/delete"})
public class DeleteAccountControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String id_draw = request.getParameter("id");
        int id;
        AccountDAO accountDAO = new AccountDAO();
        try {
            id = Integer.parseInt(id_draw);
            accountDAO.delete_Account(id);
            response.sendRedirect("adminAccount");
        } catch (Exception e) {
        }
    } 
}
