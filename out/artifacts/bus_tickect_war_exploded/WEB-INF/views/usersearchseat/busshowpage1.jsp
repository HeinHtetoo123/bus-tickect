
<%@ page import="app.daos.BusDao" %>
<%@ page import="app.models.Bus" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/public/header.jsp"%>

<h1 style="text-align:center;color: blueviolet">Bus Show  View Page</h1>

<%
    int  seateno= Integer.parseInt(request.getParameter("seateno"));
    session.setAttribute("seateno", seateno);
    int rid = Integer.parseInt(request.getParameter("rid"));
    RouteDao dao1 = new RouteDao();
    Route route = dao1.getRouteById(rid);
    request.setAttribute("route", route);
%>

<%
    int selectedSeatNo = Integer.parseInt(request.getParameter("seateno"));
    System.out.println(selectedSeatNo);
%>



    <c:forEach items="${schedules}" var="schedule">

    <div class="card text-center">
        <div class="card-body">

           <div>
                    <p class="text-primary" hidden="hidden">${schedule.getSid()}</p>
                    <p class="text-primary"> Bus Name : ${schedule.getBus().getBusName()}</p>
                    <p class="text-primary"> Start : ${schedule.getRoute().getStart()}</p>
                    <p class="text-primary"> End : ${schedule.getRoute().getEnd()}</p>
                    <p class="text-primary"> Price : ${schedule.getPrice()}</p>
                    <p class="text-primary">Date : ${schedule.getDate()}</p>
                    <p class="text-primary" >Start  Time : ${schedule.getDepartureTime()}</p>
               <p class="text-primary"> Total amount : ${seateno * schedule.getPrice()}</p>




           </div>

            <a href="/seathht?sid=${schedule.getSid()}" class="btn btn-primary">Go somewhere</a>
        </div>

    </div>
    </c:forEach>








    </div>

    <%@ include file="/WEB-INF/views/public/footer.jsp"%>


<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ include file="/WEB-INF/views/public/header.jsp"%>--%>
<%--<div class="main_contents">--%>
<%--    <div id="sub_content">--%>
<%--        <c:if test="${not empty schedules}">--%>
<%--            <table class="table">--%>
<%--                <thead class="thead-dark">--%>
<%--                <tr>--%>
<%--                    <th>Schedule ID</th>--%>
<%--                    <th>Price</th>--%>
<%--                    <th>Date</th>--%>
<%--                    <th>Departure Time</th>--%>
<%--                    <th>Start Location</th>--%>
<%--                    <th>End Location</th>--%>
<%--                    <th>Bus Number</th>--%>
<%--                    <th>Details</th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <tbody>--%>
<%--                <c:forEach items="${schedules}" var="schedule">--%>
<%--                    <tr>--%>
<%--                        <td>${schedule.sid}</td>--%>
<%--                        <td>${schedule.price}</td>--%>
<%--                        <td>${schedule.date}</td>--%>
<%--                        <td>${schedule.departureTime}</td>--%>
<%--                        <td>${schedule.getRoute().getStart()}</td>--%>
<%--                        <td>${schedule.getRoute().getEnd()}</td>--%>
<%--                        <td>${schedule.getBus().getBusName()}</td>--%>
<%--                        <td><a href="/seathht?sid=${schedule.getSid()}">Search Seat</a> </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--                </tbody>--%>
<%--            </table>--%>
<%--        </c:if>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<%@ include file="/WEB-INF/views/public/footer.jsp"%>--%>
