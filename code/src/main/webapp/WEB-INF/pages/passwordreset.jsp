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
                <input class="form-control" id="newPassword" type="password" name="newPassword">
            </div>
            <div class="form-group">
                <label for="passwordRepeat">Repeat password</label>
                <input class="form-control" id="passwordRepeat" type="password" name="passwordRepeat">
            </div>
            <input type="hidden" name="userId" value="${userId}">
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </c:when>
    <c:when test="${success}">
        <div class="alert alert-success" role="alert">
            Password successfully reset.
        </div>
    </c:when>
</c:choose>


<%@include file="includes/footer.jsp" %>