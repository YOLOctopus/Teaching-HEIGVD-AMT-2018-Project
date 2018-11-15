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
<h2>Login</h2>
<form method="post" action="./pages/login">
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" placeholder="Enter Email" name="email" id="email">
    </div>
    <div class="form-group">
        <label for="pwd">Password</label>
        <input type="password" class="form-control" placeholder="Enter Password" name="pwd" id="pwd">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>
<a href="pages/forgotpassword">Forgot password?</a>

<%@include file="includes/footer.jsp" %>
