<%@include file="includes/header.jsp" %>

<h1 class="d-inline">Profile</h1>
<hr />

Email : ${user.getEmail()} <br/>
Name  : ${user.getFirstName()} ${user.getLastName()}
<form method="get" action="pages/resetpassword">
    <input type="hidden" name="userId" value="${user.getId()}">
    <button type="submit" class="btn btn-danger">Reset password</button>
</form>

<%@include file="includes/footer.jsp" %>

