<%--
    Document   : forgotpassword
    Created on : 28.10.2018
    Author     : Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
    Goal       : This page asks for an email address then send a mail in order to change the password
--%>

<%@include file="includes/header.jsp" %>

<c:choose>
    <c:when test="${not empty email}">
        An email has been sent to ${email}. Follow the instructions within to reset your password.
    </c:when>
    <c:otherwise>
        <form method="post" action="pages/forgotpassword">
            <div class="form-group">
                <label for="email">Enter your email</label>
                <input class="form-control" id="email" type="text" name="email">
            </div>
            <button type="submit" class="btn btn-primary">Send</button>
        </form>
    </c:otherwise>
</c:choose>


<%@include file="includes/footer.jsp" %>