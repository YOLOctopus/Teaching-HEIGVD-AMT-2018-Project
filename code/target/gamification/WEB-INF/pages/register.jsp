<%@include file="includes/header.jsp" %>

<h2>Fill in the form bellow :</h2>
<form method="post" action="./registerconfirmation">
    <p>First name : <input type="text" name="firstname"/> <p/>
    <p>Last name : <input type="text" name="lastname"/> <p/>
    <p>Email : <input type="email" name="email"/> <p/>
    <p>Password : <input type="password" name="pwd"/> <p/>
    <input type="submit" value="Register">
</form>

<%@include file="includes/footer.jsp" %>
