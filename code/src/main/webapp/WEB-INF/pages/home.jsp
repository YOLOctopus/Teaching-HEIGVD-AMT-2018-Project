<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp" %>

<h1>Welcome to the gamification API</h1>
<hr>
<c:if test="${admin}">
    <div class="alert alert-warning" role="alert">
        You are logged in as an administrator
    </div>
</c:if>

<%@include file="includes/footer.jsp" %>