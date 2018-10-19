<%--
  Created by IntelliJ IDEA.
  User: samuel
  Date: 10/18/18
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Fill in the form bellow :</h2>
<form method="post" action="RegistrationConfirmationServlet">
    <p>Application name : <input type="text" name="appname"/> <p/>
    <p>Username : <input type="text" name="usrname"/> <p/>
    <p>Password : <input type="password" name="pwd"/> <p/>
    <p>Email : <input type="password" name="email"/> <p/>
    <input type="submit" value="Log in">
</form>

</body>
</html>
