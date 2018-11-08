<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp" %>

<%
    String user = null;
    if (session.getAttribute("user") != null) {
        user = (String) session.getAttribute("user");
    }
%>
<h2>Welcome to the gamification API ${user}</h2>
<c:choose>
    <c:when test="${user != null}">
        <a href="pages/logout"><h3>Logout</h3></a>
    </c:when>
    <c:otherwise>
        <a href="pages/login"><h3>Log in</h3></a>
        <a href="pages/register"><h3>Register</h3></a>
    </c:otherwise>
</c:choose>

<%@include file="includes/footer.jsp" %>