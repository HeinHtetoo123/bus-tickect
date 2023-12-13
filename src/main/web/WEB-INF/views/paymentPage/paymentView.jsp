
<%--
  Created by IntelliJ IDEA.
  User: heinhtetoo
  Date: 14/11/2023
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="app.daos.PaymentDao" %>
<%@ page import="app.models.Payment" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/public/header.jsp"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
</head>
<body>
<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">

    <a class="navbar-brand" href="#">
        <img src="https://st.depositphotos.com/2853475/4646/i/450/depositphotos_46469821-stock-photo-touristic-buses.jpg" width="30" height="30" class="d-inline-block align-top" alt="" >
        Bus Ticket Booking System</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto mr-4">
            <h4 class="nav-link">Current Date:<%=new Date()%></h4>
        </ul>
        <div class="form-inline my-2 my-lg-0">
            <div class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Admin
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/adminview">Admin Detail</a>
                    <a class="dropdown-item" href="/pay/view">Payment View</a>
                    <a class="dropdown-item" href="/transaction/view">Transaction View </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/details/view">User Deatails views</a>
                </div>
            </div>
            <div class="nav-item active">
                <a class="nav-link" href="/bus/busview">Bus <span class="sr-only">(current)</span></a>
            </div>
            <div class="nav-item">
                <a class="nav-link" href="/route/routeview">Route</a>
            </div>
            <div class="nav-item">
                <a class="nav-link" href="/schedule/view">Schedule</a>
            </div>

            <div class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </div>


        </div>
    </div>
</nav>


<%
    PaymentDao dao=new PaymentDao();
    List<Payment> payments=dao.getAllPayment();
    request.setAttribute("payment",payments);
%>


<h1 style="text-align:center;color: blueviolet">Payment View Page</h1>
<div class="container col-md-6 offset-md-3">
    <div>
        <a href="/pay/create" class="btn btn-primary btn-sm">Create<i class="fa fa-plus"></i> </a>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Payment Type</th>
            <th scope="col">Details</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${payment}" var="payment">
            <tr>
                <td>${payment.getPaid()}</td>
                <td>${payment.getPaymentType()}</td>
                    <%--            <td><a href="/edit?aid=${admin.getAid()}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i> </a></td>--%>
                <td><a href="/pay/delete?paid=${payment.getPaid()}" class="btn btn-danger btn-sm" onclick="myfunction()"><i class="fa fa-trash"></i> </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
       ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        ></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
<script>
    function myfunction() {
        var result=confirm("Are you sure you want to delete this payment type!");
        return result;

    }
</script>
</body>
</html>
