
package controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Email;

@WebServlet(name="SendMailControl", urlPatterns={"/sendMail"})
public class SendMailControl extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("sendMail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String nguoinhan = request.getParameter("emailTo");
        String tieude = request.getParameter("subject");
        String noidung = request.getParameter("note");
        
        Email email = new Email();
        boolean sendSuccess =email.sendMail(nguoinhan, tieude, noidung);
        if(sendSuccess ){
            request.setAttribute("success", "Da gui");
        }else{
                request.setAttribute("error", "Gửi email không thành công");
        }
        request.getRequestDispatcher("sendMail.jsp").forward(request, response);
    }


}
