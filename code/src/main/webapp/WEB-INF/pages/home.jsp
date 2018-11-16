<%--
    Document   : home
    Created on : 28.10.2018
    Author     : Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
    Goal       : Homepage of the website
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp" %>

<h1>Welcome to the gamification API</h1>
<hr/>
<c:if test="${admin}">
    <div class="alert alert-warning" role="alert">
        You are logged in as an administrator
    </div>
</c:if>

<%@include file="includes/footer.jsp" %>