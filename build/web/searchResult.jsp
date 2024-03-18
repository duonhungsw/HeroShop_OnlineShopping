
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="dal.ProductDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />
        <link rel="stylesheet" href="css/menu.css"/>
        <link rel="stylesheet" href="css/home.css"/>
    </head>
    <body>
        <div id="menu">
            <%@include file="menu.jsp" %>
        </div>
        <div class="clr"></div>
        <div id="banner">
            <div class="box-left">
                <h2>
                    <span>QUẦN ÁO</span>
                    <br>
                    <span>THỜI THƯỢNG</span>
                </h2>
                <p>Chào mừng đến với shop quần áo của chúng tôi, 
                    nơi bạn có thể tìm thấy những sản phẩm thời trang
                    chất lượng và phong cách độc đáo!</p>

                <a href="home">
                    <a href="home">
                        <button>Mua ngay</button>
                    </a>
                </a>
            </div>

        </div>
        <section id="product_1" class="section-p1"> 
            <h2>Sản phẩm nổi bật</h2>
            <p>Áo bóng đá bản Player đương đại</p>        
            <div class="container"> 
                <c:forEach var="c" items="${listP}">
                    <div class="pro">
                        <a href="detail?pid=${c.id}">
                            <img src="${c.thumbnail}" alt=""></a>
                        <div class="des">
                            <h5><a style="color: black" href="detail?pid=${c.id}">${c.title}</a></h5>

                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h4>${c.price}</h4>
                        </div>
                        <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
                    </div>
                </c:forEach>
            </div>                
        </section>

        <div id="pagination"> 
            <c:forEach begin="1" end="${end}" var="i">
                <a id="${i}" href="search?index=${i}&txtSearch=${save}">${i}</a> 
            </c:forEach>
<!--            <a href="#"><i class="fal fa-long-arrow-alt-right"></i></a>-->
        </div>

        <div id="footer">
            <%@include file="footer.jsp" %>
        </div>
        <script>
            document.getElementById('${index}').style.color = "red";
        </script>
        <script src="js/Jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
