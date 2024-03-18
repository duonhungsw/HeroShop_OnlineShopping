package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Email;

@WebServlet(name="FeedbackControl", urlPatterns={"/feedback"})
public class FeedbackControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       request.getRequestDispatcher("feedback.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       String name = request.getParameter("name");
       String subject = request.getParameter("subject");
       String note  =request.getParameter("note");
       String nguoinhan = "herooreh03@gmail.com";
       
       if(subject == null || note == null){
           request.setAttribute("Error", "Exist");
           request.getRequestDispatcher("feedback.jsp").forward(request, response);
       }else{
       Email email = new Email();
       boolean feedback = email.sendMail(nguoinhan, subject, note);
       response.sendRedirect("feedback");
       }
    } 
}
