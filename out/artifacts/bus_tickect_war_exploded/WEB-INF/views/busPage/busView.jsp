
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp"%>




<div
        class="bg-image"
        style="
    background-image: url('https://images.pexels.com/photos/258447/pexels-photo-258447.jpeg?auto=compress&cs=tinysrgb&w=800');
    height: 100vh;
    background-size: cover;




  "
>
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
                        <a class="dropdown-item" href="/">Home</a>
                        <a class="dropdown-item" href="/pay/view">Payment View</a>
                        <a class="dropdown-item" href="/transaction/view">Transaction View </a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/details/view">User Deatails views</a>
                    </div>
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
















<h1 style="text-align:center;color: blueviolet">Bus View Page</h1>
<%--<%--%>
<%--    BusDao dao=new BusDao();--%>
<%--    List<Bus> bus=dao.getAllBuses();--%>
<%--    request.setAttribute("bus",bus);--%>
<%--%>--%>


    <div class="container">
        <div class="text-primary ">
            <a href="/bus/buscreate" class="btn btn-primary btn-sm">Create<i class="fa fa-plus"></i>
            </a></div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Bus Name</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${bus}" var="bus">
            <tr>
                <td class="text-primary">${bus.getBid()}</td>
                <td class="text-primary">${bus.getBusName()}</td>
                <td class="text-primary"><a href="/bus/busedit?bid=${bus.getBid()}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i> </a></td>
                <td class="text-primary"><a href="/bus/busdelete?bid=${bus.getBid()}"  class="btn btn-danger btn-sm" onclick="myfunction()"><i class="fa fa-trash"></i> </a></td>


            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</div>

<script>
    function myfunction() {
        var result=confirm("Are you sure you want to delete this bus!");
        return result;

    }
</script>
<%@ include file="footer.jsp"%>

