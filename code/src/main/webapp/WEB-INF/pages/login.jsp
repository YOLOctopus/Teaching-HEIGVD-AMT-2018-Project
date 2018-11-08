<%@include file="includes/header.jsp" %>
<c:if test="${not empty error}">
    <div class="alert alert-danger" role="alert">
            ${error}
    </div>
</c:if>
<h2>Please log in :</h2>
<form method="post" action="./pages/login">
    <p>Email : <input type="email" name="email"/> <p/>
    <p>Password : <input type="password" name="pwd"/> <p/>
    <input type="submit" value="Log in">
</form>

<%@include file="includes/footer.jsp" %>
