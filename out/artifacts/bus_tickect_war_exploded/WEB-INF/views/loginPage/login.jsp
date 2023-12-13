<%@include file="header.jsp"%>
<%@include file="nav.jsp"%>

<div class="wrapper">
    <div class="form-box login">
        <h1>Login</h1>
        <p class="text-danger">${error}</p>
        <form action="/login" method="post">
            <div class="input-box">
            <span class="icon">
               <i class="fa-solid fa-envelope"></i>
            </span>

                <input type="email" id="email" name="email" required>
                <label>Email</label>
            </div>
            <div class="input-box">
            <span class="icon">
               <i class="fa-solid fa-key"></i>
            </span>
                <input type="password" id="password" name="password" required>
                <label>Password</label>
            </div>
            <button type="submit" class="btn">Login</button>
            <div>
                <a href="/forgotPassword" class="text-warning">Forgot Password ?</a>
            </div>
        </form>
    </div>
</div>

<%@include file="footer.jsp"%>