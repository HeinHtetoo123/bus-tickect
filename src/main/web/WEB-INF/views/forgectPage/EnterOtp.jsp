<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Include necessary CSS and JS libraries -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" >
</head>
<body>

<div class="container justify-content-center">

    <div class="form-group row">
        <div class="col-md-2"></div>
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3>
                            <i class="fa fa-lock fa-4x"></i>
                        </h3>
                        <h2 class="text-center">Enter OTP</h2>
                        <c:if test="${not empty message}">
                            <p class="text-danger ml-1">${message}</p>
                        </c:if>
                        <div class="panel-body">
                            <form id="register-form" action="/EnterOtp" role="form" autocomplete="off"
                                  class="form" method="post">
                                <c:if test="${not empty email}">
                                    <input type="hidden" name="email" value="${email}" />
                                </c:if>
                                <div class="form-group">
                                    <div class="col-md-2"></div>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                        <input id="opt" name="otp" placeholder="Enter OTP" class="form-control" type="text" required="required">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input name="recover-submit" class="btn btn-primary" value="Reset Password" type="submit">
                                </div>
                                <input type="hidden" class="hide" name="token" id="token" value="">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
     ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        ></script>
</body>
</html>