<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/public/header.jsp"%>

<%@ page import="app.daos.ScheduleDao" %>
<%@ page import="app.models.Schedule" %>
<%@ page import="java.util.Date" %>
<h1 style="text-align:center;color: blueviolet">Schedule Edit Page</h1>
<%
    int sid=Integer.parseInt(request.getParameter("sid"));
    ScheduleDao dao=new ScheduleDao();
    Schedule schedule=dao.getScheduleById(sid);
    request.setAttribute("schedule",schedule);
%>

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
                    <a class="nav-link" href="logout">Logout</a>
                </div>


            </div>
        </div>
    </nav>


    <div class="container col-md-6 offset-md-3">
    <form action="/schedule/edit" method="post">
        <%--        <div class="form-group">--%>
        <%--            <label for="bid">Id</label>--%>
        <%--            <input type="text" disabled="disabled" class="form-control" id="bid" name="bid" value="${bus.getBid()}">--%>
        <%--        </div>--%>
        <div class="form-group">

            <input type="text" hidden="hidden" class="form-control" id="hsid" name="hsid" value="${schedule.getSid() }">
        </div>

        <div class="form-group">
            <label class="text-primary" for="price">Price</label>
            <input type="text" class="form-control " id="price" name="price" value="${schedule.getPrice()}">
        </div>
            <div class="form-group">
                <label for="date" class="text-primary"  >Select Date:</label>
                <div class="col-md-4">
                    <input type="date" class="form-control " id="date" name="date" value="${schedule.getDate()}" >
                    <script>
                        const date=document.getElementById("date");
                        const currentDate=new Date().toISOString().split('T')[0];
                        date.setAttribute('min',currentDate);
                        date.addEventListener('input',function(){
                            if(date.value< currentDate){
                                date.value=currentDate;
                            }
                        });
                    </script>
                </div>
                <div class="form-group">
                    <label for="departureTime" class="text-primary">Departure Time:</label>
                    <div class="col-md-4">
                        <input type="text" class="form-control" id="departureTime" name="departureTime" value="${schedule.getDepartureTime()}">
                    </div>
                </div>
            <div class="form-group">
                <label for="bid" class="text-primary" >Bus Id</label>
                <input type="text" class="form-control" id="bid" name="bid" value="${schedule.getBid()}">
            </div>
            <div class="form-group">
                <label for="rid" class="text-primary" >Route Id</label>
                <input type="text" class="form-control" id="rid" name="rid" value="${schedule.getRid()}">
            </div>

        <button type="submit" class="btn btn-primary" onclick="myfunction()">Edit</button>
            </div>
    </form>

</div>
</div>
<script>
    function myfunction() {
        var result=confirm("Successfully Update!");
        return result;

    }
</script>
<%@ include file="/WEB-INF/views/public/footer.jsp"%>



