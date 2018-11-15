<%--
    Document   : passwordreset
    Created on : 28.10.2018
    Author     : Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
    Goal       : Password reset page. The user must confirm his password in order to change it
--%>

<%@include file="includes/header.jsp" %>

<c:choose>
    <c:when test="${not empty userId}">
        <c:if test="${not empty error}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </c:if>
        <form action="pages/resetpassword" method="post">
            <div class="form-group">
                <label for="newPassword">New password</label>
                <input class="form-control" id="newPassword" type="password" name="newPassword" id="new-pwd">
            </div>
            <div class="form-group">
                <label for="passwordRepeat">Repeat password</label>
                <input class="form-control" id="passwordRepeat" type="password" name="passwordRepeat" id="repeat-pwd">
            </div>
            <input type="hidden" name="userId" value="${userId}">
            <button type="submit" class="btn btn-sm btn-primary" id="submit-btn">Submit</button>
        </form>
    </c:when>
    <c:when test="${success}">
        <div class="alert alert-success" role="alert">
            Password successfully reset.
        </div>
    </c:when>
</c:choose>


<%@include file="includes/footer.jsp" %>