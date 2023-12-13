<%@ include file="header1.jsp"%>

<%@ page import="app.daos.AdminDao" %>
<%@ page import="app.models.Admin" %>
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
                        <a class="dropdown-item" href="#">Something else here</a>
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





    <h1 class="bg-secondary text-center mb-0 " >Admin Edit Page</h1>


<%
    int id=Integer.parseInt(request.getParameter("id"));
    AdminDao dao=new AdminDao();
    Admin admin=dao.getAdminById(id);
    request.setAttribute("admin",admin);
%>
<div class="container col-md-6 offset-md-3">
    <form action="/adminedit" method="post">
        <div class="form-group">
            <label class="text-info" for="id">Id</label>
            <input type="text" disabled="disabled" class="form-control" id="id" name="id" value="${admin.getId()}">
        </div>
        <div class="form-group">

            <input type="text" hidden="hidden" class="form-control" id="hid" name="hid" value="${admin.getId() }">
        </div>


        <div class="form-group">
            <label class="text-info" for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${admin.getName()}">
        </div>
        <div class="form-group">
            <label class="text-info" for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="${admin.getEmail()}">
        </div>
        <div class="form-group">
            <label class="text-info" for="password">Password</label>
            <input type="text" class="form-control" id="password" name="password" value="${admin.getPassword()}">
        </div>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Update
        </button>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                      Successfully Update!
                    </div>
                    <div class="modal-footer">
                        <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</div>
</div>
<%@ include file="footer1.jsp"%>
