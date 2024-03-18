<%-- 
    Document   : feedback
    Created on : Jan 25, 2024, 10:23:42 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/feedback.css"/>
        <style>
            #contact-details{
                margin-top: 120px;
                margin-left: 50px;
            }
            .info{

            }
            #form-detais button {
                width: 191px;
                height: 40px;
                margin-top:41px;
                background:#1d1a1a;
                border:none;
                outline:none;
                color:#fff;
                font-weight: bold;
                transition:0.4s;
            }
            #form-detais button:hover {
                background:orange;
            }
        </style>
    </head>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>
        <section id="contact-details" class="section-p1">
            <div class="details">
                <span>GET IN TOUCH</span>
                <h2>Visit ont of our agency locations or contact us today</h2>
                <h3>Head Offices</h3>
                <div class="info">
                    <li>
                        <i class="fa-solid fa-map-pin"></i>
                        <p>Phan tu, Ngu Hanh Son,Da Nang</p>
                    </li>
                    <li>
                        <i class="far fa-envelope"></i>
                        <p style="text-transform: none;">Contact: herooreh03@gmail.com</p>
                    </li>
                    <li>
                        <i class="far fa-clock"></i>
                        <p>Monday to Sunday: 9.00am to 16.pm</p>
                    </li>
                </div>
            </div>

            <div class="map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3834.374423452137!2d108.24442529999999!3d16.046048600000002!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314217640973a58f%3A0xd5f5fcfb83084e22!2zUGhhbiBU4bupLCBN4bu5IEFuLCBOZ8WpIEjDoG5oIFPGoW4sIMSQw6AgTuG6tW5nIDU1MDAwMCwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1706153910904!5m2!1svi!2s" width="600" height="450" style="border:0;"
                        allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
        </section>

        <section id="form-detais">
            <form action="feedback" method="post">
                <span>LEAVE A MESSAGE</span>
                <h2>We love to hear from you</h2>
                <h1>${requestScope.Error}</h1>
                <input type="text" name="name" placeholder="Your Name" style="text-transform: none;">
                <input type="text" name="email" placeholder="Send to" style="text-transform: none;">
                <input type="text" name="subject" placeholder="Subject" style="text-transform: none;">
                <textarea name="note"  cols="30" row="10" placeholder="Your Message"></textarea>
                <button class="normal">Submit</button>
            </form>
            <div class="people">
                <div>
                    <p><span>John Doe</span>Serior Marketing Manager <br> Phone 12345<br> Email: ddhung2003@gmail.com</p>
                </div>
                <div>
                    <p><span>John Doe</span>Serior Marketing Manager <br> Phone 12345<br> Email: ddhung2003@gmail.com</p>
                </div>
                <div>
                    <p><span>John Doe</span>Serior Marketing Manager <br> Phone 12345<br> Email: ddhung2003@gmail.com</p>
                </div>
            </div>
        </section>
        <div>
            <%@include file="footer.jsp" %>
        </div> 
    </body>
</html>
