<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.daos.BusDao" %>
<%@ page import="java.util.List" %>
<%@ page import="app.models.Bus" %>
<%@ page import="app.daos.RouteDao" %>
<%@ page import="app.models.Route" %>
<%@ include file="/WEB-INF/views/public/header.jsp"%>
<%
    BusDao dao=new BusDao();
    List<Bus> buses=dao.getAllBuses();
    request.setAttribute("buses",buses);
%>
<%
    int rid=Integer.parseInt(request.getParameter("rid"));
    RouteDao dao1=new RouteDao();
    Route route=dao1.getRouteById(rid);
    request.setAttribute("route",route);
%>
<div class="main_contents">
    <div id="sub_content">
        <form action="/schedule/create" method="post">
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Schedule Registration</h2>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="price" class="col-md-2 col-form-label">Price:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="price" name="price">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="date" class="col-md-2 col-form-label">Select Date:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="date" name="date" value="${dat}" >
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="departureTime" class="col-md-2 col-form-label">Departure Time:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="departureTime" name="departureTime">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="rid" class="col-md-2 col-form-label">Start:</label>
                <div class="col-md-4">
                    <select class="form-control" id="rid" name="rid">

                        <option value="${route.rid}">${star}</option>

                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="rid" class="col-md-2 col-form-label">End:</label>
                <div class="col-md-4">
                    <select class="form-control" id="rid1" name="rid">

                        <option value="${route.rid}">${en}</option>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="bid" class="col-md-2 col-form-label">Bus No:</label>
                <div class="col-md-4">
                    <select class="form-control" id="bid" name="bid">
                        <c:forEach items="${buses}" var="bus">
                            <option value="${bus.bid}">${bus.busName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <button type="submit" value="create" onclick="myfunction()">Create</button>
            </div>
        </form>
    </div>
</div>
<script>
    function myfunction() {
        var result=confirm("Successfully Create!");
        return result;

    }
</script>
<%@ include file="/WEB-INF/views/public/footer.jsp"%>