<%--
    Document   : changeowner
    Created on : 28.10.2018
    Author     : Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
    Goal       : Asks an email address to give application rights to an other user
--%>

<%@include file="includes/header.jsp" %>

<c:choose>
    <c:when test="${not empty application}">
        The ${application.getName()} ownership has been given to you.
    </c:when>
    <c:when test="${not empty email}">
        An email has been sent to ${email}. The application ownership will be handled to this user as soon as he accepts it.
    </c:when>
    <c:otherwise>
        <form method="post" action="pages/changeowner">
            <div class="form-group">
                <label for="email">Enter your email</label>
                <input class="form-control" id="email" type="text" name="email">
            </div>
            <input type="hidden" name="giver" value="${user}">
            <input type="hidden" name="appId" value="${id}">
            <button type="submit" class="btn btn-primary">Send</button>
        </form>
    </c:otherwise>
</c:choose>

<%@include file="includes/footer.jsp" %>