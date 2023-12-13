<%@ page import="java.util.Date" %>
<%@include file="/WEB-INF/views/public/header.jsp"%>


<div
        class="bg-image"
        style="
    background-image: url('https://images.pexels.com/photos/258447/pexels-photo-258447.jpeg?auto=compress&cs=tinysrgb&w=800');
    height: 100vh;
    background-size: cover;



  "
>
    <nav class="navbar navbar-expand-lg  navbar-dark bg-dark ">

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



    <div class="p-2 flex-fill bd-highlight container">
    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <%
        RouteDao daop=new RouteDao();
        List<Route> routes= daop.getAllRoutes();
        request.setAttribute("route",routes);
    %>
    <form action="/schedule/schedulecreate1" method="post">
        <h3 class="text-primary">Search Trip</h3>

        <div class="form-group p-2 text-primary">
            <label for="rid">  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bus-front" viewBox="0 0 16 16">
                <path d="M5 11a1 1 0 1 1-2 0 1 1 0 0 1 2 0Zm8 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0Zm-6-1a1 1 0 1 0 0 2h2a1 1 0 1 0 0-2H7Zm1-6c-1.876 0-3.426.109-4.552.226A.5.5 0 0 0 3 4.723v3.554a.5.5 0 0 0 .448.497C4.574 8.891 6.124 9 8 9c1.876 0 3.426-.109 4.552-.226A.5.5 0 0 0 13 8.277V4.723a.5.5 0 0 0-.448-.497A44.303 44.303 0 0 0 8 4Zm0-1c-1.837 0-3.353.107-4.448.22a.5.5 0 1 1-.104-.994A44.304 44.304 0 0 1 8 2c1.876 0 3.426.109 4.552.226a.5.5 0 1 1-.104.994A43.306 43.306 0 0 0 8 3Z"/>
                <path d="M15 8a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1V2.64c0-1.188-.845-2.232-2.064-2.372A43.61 43.61 0 0 0 8 0C5.9 0 4.208.136 3.064.268 1.845.408 1 1.452 1 2.64V4a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1v3.5c0 .818.393 1.544 1 2v2a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5V14h6v1.5a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5v-2c.607-.456 1-1.182 1-2V8ZM8 1c2.056 0 3.71.134 4.822.261.676.078 1.178.66 1.178 1.379v8.86a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 11.5V2.64c0-.72.502-1.301 1.178-1.379A42.611 42.611 0 0 1 8 1Z"/>
            </svg > To </label>

            <select class="form-control" id="rid" name="rid">
                <c:forEach items="${route}" var="route">
                    <option value="${route.rid}">${route.start}</option>
                </c:forEach>
            </select>

        </div>

        <div class="form-group p-2 text-primary">
            <label for="rid">  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bus-front" viewBox="0 0 16 16">
                <path d="M5 11a1 1 0 1 1-2 0 1 1 0 0 1 2 0Zm8 0a1 1 0 1 1-2 0 1 1 0 0 1 2 0Zm-6-1a1 1 0 1 0 0 2h2a1 1 0 1 0 0-2H7Zm1-6c-1.876 0-3.426.109-4.552.226A.5.5 0 0 0 3 4.723v3.554a.5.5 0 0 0 .448.497C4.574 8.891 6.124 9 8 9c1.876 0 3.426-.109 4.552-.226A.5.5 0 0 0 13 8.277V4.723a.5.5 0 0 0-.448-.497A44.303 44.303 0 0 0 8 4Zm0-1c-1.837 0-3.353.107-4.448.22a.5.5 0 1 1-.104-.994A44.304 44.304 0 0 1 8 2c1.876 0 3.426.109 4.552.226a.5.5 0 1 1-.104.994A43.306 43.306 0 0 0 8 3Z"/>
                <path d="M15 8a1 1 0 0 0 1-1V5a1 1 0 0 0-1-1V2.64c0-1.188-.845-2.232-2.064-2.372A43.61 43.61 0 0 0 8 0C5.9 0 4.208.136 3.064.268 1.845.408 1 1.452 1 2.64V4a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1v3.5c0 .818.393 1.544 1 2v2a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5V14h6v1.5a.5.5 0 0 0 .5.5h2a.5.5 0 0 0 .5-.5v-2c.607-.456 1-1.182 1-2V8ZM8 1c2.056 0 3.71.134 4.822.261.676.078 1.178.66 1.178 1.379v8.86a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 11.5V2.64c0-.72.502-1.301 1.178-1.379A42.611 42.611 0 0 1 8 1Z"/>
            </svg > From </label>

            <select class="form-control" id="rid1" name="rid">
                <c:forEach items="${route}" var="route">
                    <option value="${route.rid}">${route.end}</option>
                </c:forEach>
            </select>

        </div>

        <label for="date" class="col-md-2 col-form-label text-primary" >Select Date:</label>
        <div class="col-md-4">
            <input type="date"  class="form-control" id="date" name="date" required >
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

        <button type="submit" class="m-3  btn btn-primary" value="create">NEXT</button>
    </form>
    </div>
</div>
<%@include file="/WEB-INF/views/public/footer.jsp"%>