<%@ page import="java.util.Date" %>
<%@ include file="header1.jsp"%>
<script src="https://kit.fontawesome.com/6105f9aae4.js" crossorigin="anonymous"></script>
<div
        class="bg-image"
        style="
    background-image: url('https://images.pexels.com/photos/258447/pexels-photo-258447.jpeg?auto=compress&cs=tinysrgb&w=800');
    height: 100%;
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
                    <a class="nav-link" href="/logout">Logout</a>
                </div>


            </div>
        </div>
    </nav>




    <div class="container w-50%  ">
    <form action="/admin/admincreate" method="post">
        <h2 class="col-md-6 offset-md-2 mb-5 mt-4 text-primary" >Admin Registration</h2>

        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="name" class="col-md-2 col-form-label text-primary ">Name:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="name" name="name" >
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="email" class="col-md-2 col-form-label text-primary">Email:</label>
            <div class="col-md-4">
                <input type="email" class="form-control" id="email" name="email" >
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="password" class="col-md-2 col-form-label text-primary">Password:</label>
            <div class="col-md-4">
                <input type="password" class="form-control" id="password" name="password" >
            </div>
        </div>
        <div class="row mb-4">
         <div class="col-md-5"></div>



            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >
                Create
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
                            Successful adder!
                        </div>
                        <div class="modal-footer">
                            <button type="reset" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">OK</button>
                        </div>
                    </div>
                </div>
            </div>




        </div>
</form>
</div>
</div>
</div>



<%@ include file="footer1.jsp"%>
