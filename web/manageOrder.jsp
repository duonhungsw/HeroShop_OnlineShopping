<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="components/adminHeadComponent.jsp" %>
    </head>
    <body class="sb-nav-fixed">
        <!-- Admin navbar -->
        <%@include file="components/adminNavBarComponent.jsp" %>
        <div id="layoutSidenav">
            <!-- Admin Slidenav -->
            <%@include file="components/adminSlideNavComponent.jsp" %>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Orders</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">All current orders in system</li>
                        </ol>

                        <!-- Clothes table -->
                        <div class="card mb-4">
                            <div class="card-header fw-bold">
                                <i class="bi bi-table"></i>
                                All Clothes Table

                            </div>
                            <div class="card-body">
                                <table id="plantsTable" style="width: 100%">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Note</th>
                                            <th>Total Price</th>
                                            <th>Acc Id</th>
                                            <th>Phone</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Note</th>
                                            <th>Total Price</th>
                                            <th>Acc Id</th>
                                            <th>Phone</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${requestScope.listOrders}" var="LO">
                                            <c:if test="${LO.status.id == 1}">
                                                <c:set var="id" value="${LO.id}"/>
                                                <tr>
                                                    <td>${id}</td>
                                                    <td>${LO.fullname}</td>
                                                    <td>${LO.note}</td>
                                                    <td>${LO.total_money}</td>
                                                    <td>${LO.user.id}</td>
                                                    <td>${LO.phone_number}</td>
                                                    <td>
                                                        <span class="text-warning">Processing</span>
                                                    </td>
                                                    <td>
                                                        <a href="updateStatus?id=${id}">
                                                            <button type="button" class="btn btn-success">
                                                                <i class="bi bi-check-square"></i> 
                                                                Xác nhận
                                                            </button>
                                                        </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <a href="#" onclick="doDelete('${id}')">
                                                            <button type="button" class="btn btn-danger">
                                                                <i class="bi bi-trash"></i> Delete
                                                            </button>
                                                        </a>
                                                    </td>

                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="bi bi-table"></i>
                                Orders table
                            </div>
                            <div class="card-body">
                                <table id="ordersTable">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Note</th>
                                            <th>Total Price</th>
                                            <th>Acc Id</th>
                                            <th>Phone</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Name</th>
                                            <th>Note</th>
                                            <th>Total Price</th>
                                            <th>Acc Id</th>
                                            <th>Phone</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                        <c:forEach items="${requestScope.listOrders}" var="LO">
                                            <c:if test="${LO.status.id == 2}">
                                                <c:set var="id" value="${LO.id}"/>
                                                <tr>
                                                    <td>${id}</td>
                                                    <td>${LO.fullname}</td>
                                                    <td>${LO.note}</td>
                                                    <td>${LO.total_money}</td>
                                                    <td>${LO.user.id}</td>
                                                    <td>${LO.phone_number}</td>
                                                    <td>
                                                        <span class="text-primary">Completed</span>
                                                    </td>
                                                    <td>
                                                        <a href="#" onclick="doDelete('${id}')">
                                                            <button type="button" class="btn btn-danger">
                                                                <i class="bi bi-trash"></i> Delete
                                                            </button>
                                                        </a>
                                                    </td>

                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                </main>
                <!-- Footer -->
                <jsp:include page="components/adminFooter.jsp"></jsp:include>
            </div>
        </div>
        <script type="text/javascript">
            function doDelete(id) {
                if (confirm("Are you sure to delete id " + id)) {
                    window.location = "deleteOrder?id=" + id;
                }
            }
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>