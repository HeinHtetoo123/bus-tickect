<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.daos.ScheduleDao" %>
<%@ page import="app.models.Schedule" %>
<%@ page import="app.daos.SeatDao" %>
<%@ page import="app.models.Seat" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="app.daos.PaymentDao" %>
<%@ page import="app.models.Payment" %>
<%@ include file="/WEB-INF/views/public/header.jsp"%>
<%
    int sid=Integer.parseInt(request.getParameter("sid"));
    ScheduleDao dao=new ScheduleDao();
    Schedule schedule=dao.getScheduleById(sid);
    request.setAttribute("schedule",schedule);
%>
<%
    String selectedSeatIdsStr = request.getParameter("selectedSeatIds");
    String[] selectedSeatIdArray = selectedSeatIdsStr.split(",");

    List<Seat> selectedSeats = new ArrayList<>();
    SeatDao dao1 = new SeatDao();

    for (String seatIdStr : selectedSeatIdArray) {
        try {
            int seid = Integer.parseInt(seatIdStr);
            Seat seat = dao1.getSeatsById(seid);
            selectedSeats.add(seat);
        } catch (NumberFormatException e) {

        }
    }

    request.setAttribute("selectedSeats", selectedSeats);
    session.setAttribute("selectedSeatIdsStr", selectedSeatIdArray);
%>
<%
    PaymentDao dao2=new PaymentDao();
    List<Payment> payments=dao2.getAllPayment();
    request.setAttribute("payment",payments);
%>
<%
    int no = (Integer) session.getAttribute("no");
%>
<div class="main_contents">
    <div id="sub_content">
        <form action="/details/create" method="post">
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Details Registration</h2>
<%--            <div class="row mb-4">--%>
            <div class="form-group row">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Passenger Name:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="email" class="col-md-2 col-form-label">Email:</label>
                <div class="col-md-4">
                    <input type="email" class="form-control" id="email" name="email" required >
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="phone" class="col-md-2 col-form-label">Phone:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="phone" name="phone" required>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="totalPrice" class="col-md-2 col-form-label">Total Price:</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="totalPrice" name="totalPrice" value="${schedule.getPrice() * seateno}">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="sid" class="col-md-2 col-form-label">Bus No:</label>
                <div class="col-md-4">
                    <select class="form-control" id="sid" name="sid" >
                        <option value="${schedule.sid}">${schedule.getBus().getBusName()}</option>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="sid" class="col-md-2 col-form-label">Start:</label>
                <div class="col-md-4">
                    <select class="form-control" id="sid1" name="sid" >
                        <option value="${schedule.sid}">${schedule.getRoute().getStart()}</option>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="sid" class="col-md-2 col-form-label">End:</label>
                <div class="col-md-4">
                    <select class="form-control" id="sid2" name="sid" >
                        <option value="${schedule.sid}">${schedule.getRoute().getEnd()}</option>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="sid" class="col-md-2 col-form-label">Departure Time:</label>
                <div class="col-md-4">
                    <select class="form-control" id="sid3" name="sid" >
                        <option value="${schedule.sid}">${schedule.getDepartureTime()}</option>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="paid" class="col-md-2 col-form-label">Payment Type:</label>
                <div class="col-md-4">
                    <select class="form-control" id="paid" name="paid" >
                        <c:forEach items="${payment}" var="payment">
                            <option value="${payment.paid}">${payment.paymentType}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="selectedSeatIds" class="col-md-2 col-form-label">Selected Seat Number:</label>
                <div class="col-md-4" id="selectedSeatIds" name="selectedSeatIds">
                    <c:forEach items="${selectedSeats}" var="seat">
                        ${seat.capacity}
                    </c:forEach>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <button type="submit" class="btn btn-primary" value="booking">Booking</button> &nbsp;
                <a  href="/" class="btn btn-danger" value="booking">Cancel</a> &nbsp;&nbsp;
<%--                <a href="/" class="cancel-button"><button type="button" class=" btn-danger" value="cancel"> Cancel</button></a>--%>
            </div>
        </form>
    </div>
</div>

<%@ include file="/WEB-INF/views/public/footer.jsp"%>

