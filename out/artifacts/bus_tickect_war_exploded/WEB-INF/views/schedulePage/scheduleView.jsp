
<%@ page import="app.daos.ScheduleDao" %>
<%@ page import="app.models.Schedule" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Schedule View</title>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

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

<h1 style="text-align:center;color: blueviolet">Schedule View Page</h1>
<%
    ScheduleDao dao=new ScheduleDao();
    List<Schedule> schedule=dao.getAllSchedules();
    request.setAttribute("schedule",schedule);
%>



<%--<div--%>
<%--        class="bg-image"--%>
<%--        style="--%>
<%--    background-image: url('https://images.pexels.com/photos/258447/pexels-photo-258447.jpeg?auto=compress&cs=tinysrgb&w=800');--%>
<%--    height: 100vh;--%>
<%--    background-size: cover;--%>



<%--  "--%>
<%-->--%>
    <nav class="navbar navbar-expand-lg m-4 navbar-dark bg-dark">

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




<div class="main_contents m-4">
    <div id="sub_content">
        <form class="row ml-4 mt-3 ms-2" action="/date/search" method="post">

            <label for="date" class="col-md-1 col-form-label text-primary " >Select Date:</label>
            <div class="col-md-2">
                <input type="date"  class="form-control " id="date" name="date"  >
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

            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3 " >Search</button>

            </div>
            <div class="col-auto">
                <button type="button" class="btn btn-secondary " onclick="location.href = '/scheduleCreatePage/schedulecreate';">
                    Add
                </button>

            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-danger mb-3" onclick="location.href = '/schedule/view';">All Show</button>
            </div>



        </form>





            <div class="container col-md-8 offset-md-2">

                <table id="example" class="display">
                <thead >
                <tr>
                    <th scope="col ">SID</th>
                    <th scope="col">Price</th>
                    <th scope="col">Date</th>
                    <th scope="col">Departure Time</th>
                    <th scope="col">Start</th>
                    <th scope="col">End</th>
                    <th scope="col">Bus No</th>
<%--                    <th scope="col">UPDATE</th>--%>
                    <th scope="col">DELETE</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${schedules}" var="schedule">
                    <tr>
                        <td class="text-warning">${schedule.getSid()}</td>
                        <td class="text-warning">${schedule.getPrice()}</td>
                        <td class="text-warning">${schedule.getDate()}</td>
                        <td class="text-warning">${schedule.getDepartureTime()}</td>
                        <td class="text-warning">${schedule.getRoute().getStart()}</td>
                        <td class="text-warning">${schedule.getRoute().getEnd()}</td>
                        <td class="text-warning">${schedule.getBus().getBusName()}</td>

<%--                        <td>--%>
<%--                            <button type="submit" class="btn btn-success  " onclick="location.href = '/schedule/edit?sid=${schedule.getSid()}';">--%>
<%--                                Update--%>
<%--                            </button>--%>
<%--                        </td>--%>
                        <td> <button type="submit" class="btn btn-secondary mb-3" onclick="location.href = '/schedule/delete?sid=${schedule.getSid()}'; return myfunction();">
                            Delete</button></td>

                    </tr>

                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<script>
    function myfunction() {
        var result=confirm("Are you sure you want to delete this schedule!");
        return result;

    }
</script>
</body>

</html>



