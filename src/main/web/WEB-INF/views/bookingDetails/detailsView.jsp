<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.daos.DetailsDao" %>
<%@ page import="app.models.Details" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Details </title>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        >
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
    <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.js"></script>

    <script>
        $(document).ready(function () {

            $('#example').DataTable({

            });
        });
    </script>
</head>
<body>
<%
    DetailsDao dao=new DetailsDao();
    List<Details> details=dao.getAllDetails();
    request.setAttribute("details",details);
%>
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
                <a class="nav-link" href="/logout">Logout</a>
            </div>


        </div>
    </div>
</nav>



<h1 style="text-align: center; color: blueviolet;">Booking Details</h1>

<div class="container col-md-8 offset-md-2">

    <table id="example" class="display">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Passenger Name</th>
            <th scope="col">Email</th>
            <th scope="col">Phone</th>
            <th scope="col">Bus No</th>
            <th scope="col">Start</th>
            <th scope="col">End</th>
            <th scope="col">Departure Time</th>
            <th scope="col">Payment Type</th>
            <th scope="col">Total Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${details}" var="detail">
            <tr>
                <td>${detail.getBdid()}</td>
                <td>${detail.getName()}</td>
                <td>${detail.getEmail()}</td>
                <td>${detail.getPhone()}</td>
                <td>${detail.getSchedule().getBus().getBusName()}</td>
                <td>${detail.getSchedule().getRoute().getStart()}</td>
                <td>${detail.getSchedule().getRoute().getEnd()}</td>
                <td>${detail.getSchedule().getDepartureTime()}</td>
                <td>${detail.getPayment().getPaymentType()}</td>
                <td>${detail.getTotalPrice()}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
</body>
</html>
