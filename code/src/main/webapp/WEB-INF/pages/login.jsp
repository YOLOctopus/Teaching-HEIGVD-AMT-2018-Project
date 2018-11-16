<%--
    Document   : login
    Created on : 28.10.2018
    Author     : Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
    Goal       : Login page
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp" %>
<c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
            ${error}
    </div>
</c:if>
<h1>Login</h1>
<hr/>
<form method="post" action="./pages/login">
    <div class="form-group">
        <label for="email">Email</label>
        <input id="email" type="email" class="form-control" placeholder="Enter Email" name="email">
    </div>
    <div class="form-group">
        <label for="pwd">Password</label>
        <input type="password" class="form-control" placeholder="Enter Password" name="pwd" id="pwd">
    </div>
    <button type="submit" class="btn btn-sm px-3 btn-primary" id="login-btn">Login</button>
    <a class="ml-2" id="forgot-password-link" href="pages/forgotpassword">Forgot password?</a>
</form>
<%@include file="includes/footer.jsp" %>
