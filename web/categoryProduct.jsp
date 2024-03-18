

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/home.css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
    </head>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>
        <section id="product_1" class="section-p1">
            <div class="container" style="padding-top: 120px "> 
                <c:forEach var="c" items="${listCategory}">
                    <div class="pro">
                        <a href="detail?pid=${c.id}">
                            <img src="${c.thumbnail}" alt="">
                        </a>
                        <div class="des">
                            <h5><a style="color: black" href="detail?pid=${c.id}">${c.title}</a></h5>

                            <div class="star" style="display: flex; margin:0px auto; margin-top:17px;">
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                                <span>
                                    <img src="images/star.png" alt="">
                                </span>
                            </div>
                            <h4>${c.price}</h4>
                        </div>
                        <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
                    </div>
                </c:forEach>
            </div> 
        </section>
        <div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function closeDropdown() {
            var dropdown = document.getElementById("myDropdown");
            dropdown.getElementsByClassName("dropdown-content")[0].style.display = "none";
        }
    </script>
    <style>
        .section-p1{
            text-align: center;
        }

        .container{
            display: flex;
            justify-content: space-between;
            padding-top: 20px;
            flex-wrap: wrap;
        }

        .section-p1 .pro{
            width: 23%;
            min-width: 250px;
            padding: 10px 12px;
            border: 1px solid #cce7d0;
            border-radius: 25px;
            cursor: pointer;
            box-shadow: 20px 20px 30px rgba(0,0,0,0.02);
            margin: 15px 0;
            transition: 0.2 ease;
            position: relative;
        }

        .section-p1 .pro:hover{
            box-shadow: 20px 20px 30px rgba(0,0,0, 0.06);
        }
        .section-p1 .pro img{
            width: 100%;
            border-radius: 20px;
        }

        .section-p1 .pro .des{
            text-align: start;
            padding: 10px 0;
        }

        .section-p1 .pro .des span{
            color:chocolate;
            font-size: 12px;
        }

        .section-p1 .pro .des h5{
            padding-top: 7px;
            color: #1a1a1a;
            font-size: 14px;
        }

        .section-p1 .pro .des i{
            font-size: 12px;
            color:darksalmon ;
        }

        .section-p1.pro .des h4{
            padding-top: 7px;
            font-size: 15px;
            font-weight: 700;
            color: #088178;
        }

        .section-p1 .pro .cart{
            width: 40px;
            height: 40px;
            line-height: 40px;
            border-radius: 50px;
            background-color: #e8f6ea;
            font-weight: 500;
            color: #088178;
            border: 1px solid #cce7d0;
            position: absolute;
            bottom: 20px;
            right: 10px;
        }
    </style>
</html>
