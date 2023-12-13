
    <%@ page import="app.daos.ScheduleDao" %>
    <%@ page import="app.models.Schedule" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="/WEB-INF/views/public/header.jsp"%>
    <style>
        .seat-button {
            padding: 10px;
            cursor: pointer;
            margin: 5px;
        }

        .seat-available {
            background-color: blue;
            color: white;
        }

        .seat-booked {
            background-color: red;
            color: white;
            cursor: not-allowed;
        }

        .seat-list {
            display: grid;
            grid-template-columns: repeat(4, 1fr);
            grid-gap: 10px;
        }

        .seat-item {
            text-align: center;
        }
    </style>
    </head>
    <body>
        <%
            int sid = Integer.parseInt(request.getParameter("sid"));
            ScheduleDao dao = new ScheduleDao();
            Schedule schedule = dao.getScheduleById(sid);
            request.setAttribute("schedule", schedule);
            int no=(Integer) session.getAttribute("seateno");
        %>
    <div class="seat-form">
        <div class="d-flex justify-content-center">
            <h1 class="form-header" >Seat Booking</h1>

        </div>
        <p class="m-4">Please select <%= no %> Seat(s)</p>
        <form action="/details/create" method="get" onsubmit="return validateForm()">
            <ul class="seat-list">
                <c:forEach items="${seats}" var="seat">
                    <div class="form-check">
                        <label class="form-check" id="seat${seat.seid}" name="selectedSeats" value="${seat.seid}">
                            <c:set var="status" value="seat-available" />
                            <c:forEach items="${seatd}" var="seatdd">
                                <c:if test="${seat.seid eq seatdd.seid}">
                                    <c:set var="status" value="seat-booked" />
                                </c:if>
                            </c:forEach>
                            <button class="seat-button ${status}" type="button" id="seid${seat.seid}" name="selectedSeats" value="${seat.seid}" onclick="toggleSeat(this)" <c:if test="${status eq 'seat-booked'}">disabled</c:if>>
                                Seat No: ${seat.capacity}
                            </button>
                        </label>
                    </div>
                </c:forEach>
            </ul>
            <div  class="m-4" id="selected-seats">
            </div>
            <button class="next-button btn btn-primary m-4" type="submit">NEXT</button>
            <input type="hidden" name="selectedSeatIds" id="selectedSeatIds" />
            <input type="hidden" name="sid" value="${schedule.getSid()}" />
        </form>
    </div>

    <script>
        var selectedSeatNo = '<%=  no %>';
        var selectedSeats = [];
        function toggleSeat(button) {
            var seatId = button.value;

            if (button.classList.contains('seat-available')) {
                if (selectedSeats.length >= selectedSeatNo) {
                    alert('Please select exactly <%= (Integer) session.getAttribute("seateno") %> seats before proceeding.');
                } else {
                    button.classList.remove('seat-available');
                    button.classList.add('seat-booked');
                    selectedSeats.push(seatId);
                    updateSelectedSeats();
                }
            } else {
                button.classList.remove('seat-booked');
                button.classList.add('seat-available');
                var index = selectedSeats.indexOf(seatId);
                if (index !== -1) {
                    selectedSeats.splice(index, 1);
                }
                updateSelectedSeats();
            }

            document.getElementById('selectedSeatIds').value = selectedSeats.join(",");
        }

        function updateSelectedSeats() {
            var selectedSeatsElement = document.getElementById('selected-seats');
            selectedSeatsElement.innerHTML = "Selected Seats: " + selectedSeats.join(", ");
        }

        function validateForm() {
            if (selectedSeats.length < selectedSeatNo || selectedSeats.length > 4) {
                alert('Please select exactly <%= (Integer) session.getAttribute("seateno") %> seats before proceeding.');
                return false;
            }
            return true;
        }
    </script>
<%@include file="/WEB-INF/views/public/footer.jsp"%>