<%@include file="includes/header.jsp" %>

<h1 class="d-inline">Profile</h1>
<hr />

Email : ${user.getEmail()} <br/>
Name  : ${user.getFirstName()} ${user.getLastName()}
<form method="post" action="pages/forgotpassword">
    <input type="hidden" name="email" value="${user.getEmail()}">
    <button type="submit" class="btn btn-danger">Reset password</button>
</form>

<%@include file="includes/footer.jsp" %>

