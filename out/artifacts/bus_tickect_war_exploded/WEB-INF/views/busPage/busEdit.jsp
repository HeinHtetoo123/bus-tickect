<%@ include file="header.jsp"%>
<%@ page import="app.daos.BusDao" %>
<%@ page import="app.models.Bus" %>
<%@ page import="java.util.Date" %>


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
                    <a class="nav-link" href="/logout">Logout</a>
                </div>


            </div>
        </div>
    </nav>

















    <h1 style="text-align:center;color: blueviolet">Bus Edit Page</h1>
<%
    int bid=Integer.parseInt(request.getParameter("bid"));
    BusDao dao=new BusDao();
    Bus bus=dao.getBusById(bid);
    request.setAttribute("bus",bus);
%>



<div class="container col-md-6 offset-md-3">
    <form action="/bus/busedit" method="post">
        <div class="form-group">
            <label class="text-info" for="bid">Id</label>
            <input type="text" disabled="disabled" class="form-control" id="bid" name="bid" value="${bus.getBid()}">
        </div>
        <div class="form-group">

            <input type="text" hidden="hidden" class="form-control" id="hbid" name="hbid" value="${bus.getBid() }">
        </div>


        <div class="form-group">
            <label class="text-info" for="busName">Bus Name</label>
            <input type="text" class="form-control" id="busName" name="busName" value="${bus.getBusName()}">
        </div>
        <button type="submit" class="btn btn-primary" onclick="myfunction()">Update</button>
    </form>
</div>
</div>
</div>
<script>
    function myfunction() {
        var result=confirm("Successfully Update!");
        return result;

    }
</script>
<%@ include file="footer.jsp"%>

