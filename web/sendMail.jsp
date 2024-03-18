<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/adminHeadComponent.jsp" %>
        <title>Manage Account</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 600px;
                margin: 120px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-group {
                margin-bottom: 20px;
            }

            .form-group label {
                display: block;
                font-weight: bold;
            }

            .form-group input[type="text"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .form-group input[type="submit"] {
                padding: 10px 20px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .form-group input[type="submit"]:hover {
                background-color: #0056b3;
            }
        </style>
    </head>

    <body class="sb-nav-fixed">
        <!-- Admin navbar -->
        <%@include file="components/adminNavBarComponent.jsp" %>
        <div id="layoutSidenav">
            <!-- Admin Slidenav -->
            <%@include file="components/adminSlideNavComponent.jsp" %>
            <div class="container">
                <h2>Gửi Email</h2>
                <form action="sendMail" method="post">
                    <div class="form-group">
                        <label for="emailTo">Người Nhận:</label>
                        <input type="text" name="emailTo" id="emailTo">
                    </div>
                    <div class="form-group">
                        <label for="subject">Tiêu Đề:</label>
                        <input type="text" name="subject" id="subject">
                    </div>
                    <div class="form-group">
                        <label for="note">Nội Dung:</label>
                        <input type="text" name="note" id="note">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Gửi">
                    </div>
                    <%-- Kiểm tra nếu có thông báo thành công --%>
                    <% if (request.getAttribute("success") != null) { %>
                    <div class="alert alert-success">
                        <% out.println(request.getAttribute("success")); %>
                    </div>
                    <% } %>

                    <%-- Kiểm tra nếu có thông báo lỗi --%>
                    <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger">
                        <% out.println(request.getAttribute("error")); %>
                    </div>
                    <% }%>

                </form>


            </div>
        </div>
        <script type="text/javascript">

        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
