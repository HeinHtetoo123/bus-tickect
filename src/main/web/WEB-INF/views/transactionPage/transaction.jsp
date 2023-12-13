<%--<%@ include file="/WEB-INF/views/public/header.jsp"%>--%>
<%--<%@ page import="app.models.Schedule" %>--%>
<%--<%@ page import="app.daos.ScheduleDao" %>--%>
<%--<%@ page import="app.daos.DetailsDao" %>--%>
<%--<%@ page import="app.models.Details" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>

<%--<%--%>
<%--    String name=(String)session.getAttribute("name");--%>
<%--   String email=(String)session.getAttribute("email");--%>
<%--   String phone=(String)session.getAttribute("phone");--%>
<%--   int totalPrice=(Integer) session.getAttribute("totalPrice");--%>
<%--    int sid1=(Integer)session.getAttribute("sid");--%>
<%--    int paid=(Integer)session.getAttribute("paid");--%>

<%--    DetailsDao dao1=new DetailsDao();--%>
<%--    Details detail=dao1.getDetailsBy(name,email,phone,totalPrice,sid1,paid);--%>
<%--     request.setAttribute("detail",detail);--%>
<%--    System.out.println(detail.getBdid()+"JJHKJH");--%>
<%--      System.out.println(detail.getPaid());--%>
<%--%>--%>
<%--<div class="payment-form">--%>
<%--    <%--%>
<%--        int no = (Integer) session.getAttribute("no");--%>
<%--    %>--%>
<%--    <h1 class="form-header">Payment Details</h1>--%>

<%--    <form action="/transaction/create" method="post">--%>
<%--        <div class="row mb-4">--%>
<%--            <div class="col-md-2"></div>--%>
<%--            <label for="paid" class="col-md-2 col-form-label">Payment Type:</label>--%>
<%--            <div class="col-md-4">--%>
<%--                <select class="form-control" id="paid" name=paid" >--%>
<%--                    <option value="${detail.paid}">${detail.getPayment().getPaymentType()}</option>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row mb-2">--%>
<%--            <div class="col-md-2"></div>--%>
<%--            <label for="transactionNo" class="col-md-2 col-form-label">Transaction No:</label>--%>
<%--            <input type="text" id="transactionNo" name="transactionNo" class="form-control" placeholder="1111-2222-3333-4444" required>--%>
<%--        </div>--%>
<%--        <div class="row mb-4">--%>
<%--        <div class="col-md-2"></div>--%>
<%--        <label for="payName" class="col-md-2 col-form-label">Payment Account Name:</label>--%>
<%--        <input type="text" id="payName" name="payName" class="form-control"  required>--%>
<%--       </div>--%>
<%--        <div class="row mb-4">--%>
<%--            <div class="col-md-2"></div>--%>
<%--            <label for="payPhone" class="col-md-2 col-form-label">Payment Account Phone:</label>--%>
<%--            <input type="phone" id="payPhone" name="payPhone" class="form-control" required>--%>
<%--        </div>--%>
<%--        <div class="row mb-4">--%>
<%--            <div class="col-md-2"></div>--%>
<%--            <label for="amount" class="col-md-2 col-form-label">Payment Amount:</label>--%>
<%--            <input type="text" id="amount" name="amount" class="form-control" required>--%>
<%--        </div>--%>
<%--        <div class="row mb-4">--%>
<%--            <div class="col-md-2"></div>--%>
<%--            <label for="bdid" class="col-md-2 col-form-label"></label>--%>
<%--            <input type="text" id="bdid" name="bdid" class="form-control" value="${detail.getBdid()}" hidden="hidden">--%>
<%--        </div>--%>

<%--        <button class="submit-button" type="submit" onclick="confirmDelete()">OK </button>--%>

<%--    </form>--%>
<%--</div>--%>
<%--<script>--%>
<%--    function confirmDelete() {--%>
<%--        var confirmResult = confirm("Wait A Minute,if correct your ticket will be sent from email!");--%>
<%--        return confirmResult;--%>
<%--    }--%>
<%--</script>--%>
<%--<%@ include file="/WEB-INF/views/public/footer.jsp"%>--%>


<%@ include file="/WEB-INF/views/public/header.jsp"%>
<%@ page import="app.models.Schedule" %>
<%@ page import="app.daos.ScheduleDao" %>
<%@ page import="app.daos.DetailsDao" %>
<%@ page import="app.models.Details" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
    String name = (String) session.getAttribute("name");
    String email = (String) session.getAttribute("email");
    String phone = (String) session.getAttribute("phone");
    int totalPrice = (Integer) session.getAttribute("totalPrice");
    int sid1 = (Integer) session.getAttribute("sid");
    int paid = (Integer) session.getAttribute("paid");

    DetailsDao dao1 = new DetailsDao();
    Details detail = dao1.getDetailsBy(name, email, phone, totalPrice, sid1, paid);
    request.setAttribute("detail", detail);
    System.out.println(detail.getBdid() + "JJHKJH");
    System.out.println(detail.getPaid());
%>
<div class="payment-form">
    <div class="d-flex justify-content-center">
    <h1 class="form-header">Payment Details</h1>
    </div>
    <form action="/transaction/create" method="post">
        <div class="form-group row">
            <div class="col-md-2"></div>
            <label for="paid" class="col-md-2 col-form-label">Payment Type:</label>
            <div class="col-md-6">
                <select class="form-control" id="paid" name="paid">
                    <option value="${detail.paid}">${detail.getPayment().getPaymentType()}</option>
                </select>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-2"></div>
            <label for="transactionNo" class="col-md-2 col-form-label">Transaction No:</label>
            <div class="col-md-6">
                <input type="text" id="transactionNo" name="transactionNo" class="form-control" placeholder="1111-2222-3333-4444" required>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-2"></div>
            <label for="payName" class="col-md-2 col-form-label">Payment Account Name:</label>
            <div class="col-md-6">
                <input type="text" id="payName" name="payName" class="form-control" required>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-2"></div>
            <label for="payPhone" class="col-md-2 col-form-label">Payment Account Phone:</label>
            <div class="col-md-6">
                <input type="phone" id="payPhone" name="payPhone" class="form-control" required>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-md-2"></div>
            <label for="amount" class="col-md-2 col-form-label">Payment Amount:</label>
            <div class="col-md-6">
                <input type="text" id="amount" name="amount" class="form-control" required>
            </div>
        </div>
        <input type="text" id="bdid" name="bdid" value="${detail.getBdid()}" hidden="hidden">
        <div class="form-group row">
            <div class="col-md-2"></div>
            <div class="col-md-2"></div>
            <div class="col-md-6">
                <button class="btn btn-primary" type="submit" onclick="return confirmDelete()">OK</button>
            </div>
        </div>
    </form>
</div>

<script>
    function confirmDelete() {
        var confirmResult = confirm("Wait A Minute, if correct, your ticket will be sent to your email!");
        return confirmResult;
    }
</script>
<%@ include file="/WEB-INF/views/public/footer.jsp"%>
