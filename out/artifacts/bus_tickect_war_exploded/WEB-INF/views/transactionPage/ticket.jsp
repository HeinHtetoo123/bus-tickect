<%@ include file="/WEB-INF/views/public/header.jsp"%>
<%@ page import="app.daos.BookingDao" %>
<%@ page import="app.daos.DetailsDao" %>
<%@ page import="app.models.Booking" %>
<%@ page import="app.models.Details" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    int  tid= Integer.parseInt(request.getParameter("tid"));
    DetailsDao dao=new DetailsDao();
    Details detail=dao.getDetailsByTid(tid);
    request.setAttribute("detail",detail);
    BookingDao dao1=new BookingDao();
    List<Booking> booking=dao1.getSeatsBybdid(detail.getBdid());
    request.setAttribute("booking",booking);
%>


<div class="payment-form m-4">

    <h1 style="text-align:center;color: blueviolet">Ticket Details</h1>
    <form action="/" method="post">
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="name" class="col-md-2 col-form-label">Passenger Name:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="name" name="name" value="${detail.getName()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="email" class="col-md-2 col-form-label">Email:</label>
            <div class="col-md-4">
                <input type="email" class="form-control" id="email" name="email" value="${detail.getEmail()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="phone" class="col-md-2 col-form-label">Phone:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="phone" name="phone" value="${detail.getPhone()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="totalPrice" class="col-md-2 col-form-label">Total Price:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="totalPrice" name="totalPrice" value="${detail.getTotalPrice()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="sid" class="col-md-2 col-form-label">Bus No:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="sid" name="sid" value="${detail.getSchedule().getBus().getBusName()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="sid" class="col-md-2 col-form-label">Start:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="sid1" name="sid" value="${detail.getSchedule().getRoute().getStart()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="sid" class="col-md-2 col-form-label">End:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="sid2" name="sid" value="${detail.getSchedule().getRoute().getEnd()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="sid" class="col-md-2 col-form-label">Departure Time:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="sid3" name="sid" value="${detail.getSchedule().getDepartureTime()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
            <div class="col-md-2"></div>
            <label for="paid" class="col-md-2 col-form-label">Payment Type:</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="paid" name="paid" value="${detail.getPayment().getPaymentType()}" readonly>
            </div>
        </div>
        <div class="row mb-4">
        <div class="col-md-2"></div>
        <label for="bdid" class="col-md-2 col-form-label">Selected Seat:</label>
        <div class="col-md-4" id="bdid" name="bdid">
            <c:forEach items="${booking}" var="seat">
                ${seat.seid  }
            </c:forEach>
        </div>
        </div>

        <div class="row mb-4">
            <div class="col-md-2"></div>
            <button type="submit" class="btn btn-success" value="booking">Back home</button> &nbsp;
        </div>
    </form>
</div>

<%@ include file="/WEB-INF/views/public/footer.jsp"%>
