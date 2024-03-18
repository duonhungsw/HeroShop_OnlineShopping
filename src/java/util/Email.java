package util;

import jakarta.mail.Authenticator;
import jakarta.activation.DataContentHandler;
import jakarta.activation.DataSource;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.sql.Date;
import java.util.Properties;

public class Email {

    //email: herooreh03@gmail.com
    //pass: otya kyhd mfbf oplf
    static final String from = "herooreh03@gmail.com";
    static final String password = "otyakyhdmfbfoplf";

    public static boolean sendMail(String to, String tieude, String noidung) {
        // Properties :  khai bao cac thuoc tinh
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
        props.put("mail.smtp.port", "587"); // TLS 587 SSL 465 SSL Va TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // tao Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, password);
            }

        };

        //Phien lam viec
        Session session = Session.getInstance(props, auth);

        //gui email
//        final String to = "hunglqde170467@fpt.edu.vn";
        MimeMessage msg = new MimeMessage(session);
        try {
            //Kieu noi dung
            msg.addHeader("Content-type", "text/Html; charset=UTF-8");

            //Nguoi gui
            msg.setFrom(from);

            //Nguoi nhan
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            //Tieu de email
            msg.setSubject(tieude+ " " + System.currentTimeMillis());

            //Quy dinh ngay gui
            msg.setSentDate(new java.util.Date());

            //Quy dinh email nhan phan hoi
            //Noi dung
            msg.setContent(noidung, "text/html; charset=UTF-8");

            //Gui email
            Transport.send(msg);
            System.out.println("Gui thanh cong");
            return true;
        } catch (Exception e) {
            System.out.println("Gap loi");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        //gui cc va gui bcc
        Email.sendMail("ddhung2003@gmail.com", "Test thôi nha", "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<title>W3.CSS</title>\n"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "<link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
                + "<body>\n"
                + "\n"
                + "<div class=\"w3-container w3-red\">\n"
                + "  <p>Dương ĐỨC hÙNG</p>\n"
                + "</div>\n"
                + "\n"
                + "<div class=\"w3-container w3-green\">\n"
                + "  <p>Hello W3.CSS Layout.</p>\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html>");
    }

}
