<%@ page import="app.daos.AdminDao" %>
<%@ page import="app.models.Admin" %>
<%@ page import="app.models.Login" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header1.jsp"%>
<script src="https://kit.fontawesome.com/6105f9aae4.js" crossorigin="anonymous"></script>

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



<h1 class="bg-secondary text-center mb-0 " >Admin View Page</h1>

<%--<%--%>
<%--    AdminDao dao=new AdminDao();--%>
<%--    List<Admin> admins=dao.getAllAdmins();--%>
<%--    request.setAttribute("admins",admins);--%>



<%--%>--%>
    <%
        String email = (String) session.getAttribute("adminEmail");
        String password = (String) session.getAttribute("password");
        AdminDao dao = new AdminDao();
        Login login = new Login(email, password);
        Admin admin = dao.getLogin(login);
        request.setAttribute("admin", admin);
    %>

<%--<div--%>
<%--        class="bg-image"--%>
<%--        style="--%>
<%--    background-image: url('data:image/jpeg;base64,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');--%>
<%--    height: 100%;--%>
<%--    background-size: cover;--%>



<%--  "--%>
<%-->--%>

    <div class="text-primary ">
        <a href="/admin/admincreate" class="btn btn-primary btn-sm">Create<i class="fa fa-plus"></i>
        </a></div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Email</th>
            <th scope="col">Edit</th>


        </tr>
        </thead>
        <tbody>

            <tr>
                <td class="text-primary" >${admin.getId()}</td>
                <td class="text-primary">${admin.getName()}</td>
                <td class="text-primary">${admin.getEmail()}</td>
                <td><a href="/adminedit?id=${admin.getId()}" class="btn btn-warning btn-sm"><i class="fa fa-edit"></i> </a></td>

                <th>

                   <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                       <div class="modal-dialog" role="document">
                           <div class="modal-content">
                               <div class="modal-header">
                                   <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                   <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                       <span aria-hidden="true">&times;</span>
                                   </button>
                               </div>
                               <div class="modal-body">
                                   ...
                               </div>
                               <div class="modal-footer">
                                   <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                   <button type="submit" class="btn btn-primary">Save changes</button>
                               </div>
                           </div>
                       </div>
                   </div>

               </th>
            </tr>

        </tbody>
    </table>

</div>
</div>


<%@ include file="footer1.jsp"%>
