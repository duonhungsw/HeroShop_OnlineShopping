package controller;

import dal.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet(name = "signupController", urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");


        LoginDAO ldb = new LoginDAO();

        User user = ldb.checkUser(name);
        if (user == null) {
            // Create new User
            user = new User();
            user.setFullname(name);
            user.setPassword(pass);
            user.setEmail(email);
            user.setPhone_number(phone);
            user.setAddress(address);
            user.setRole(1);
            // Signup user
            ldb.signup(user);
            response.sendRedirect("login");
        } else {
            request.getRequestDispatcher("signup").forward(request, response);
        }
        }
    }

