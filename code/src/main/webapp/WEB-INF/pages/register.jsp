<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="includes/header.jsp" %>
<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:forEach>
</c:if>
<h2>Register</h2>
<form method="post" action="./pages/register">
    <div class="form-group">
        <label for="firstname">First name</label>
        <input type="text" class="form-control" placeholder="Enter First Name" name="firstname" id="firstname" value="<c:if test="${not empty firstName}">${firstName}</c:if>">
    </div>
    <div class="form-group">
        <label for="lastname">Last name</label>
        <input type="text" class="form-control" placeholder="Enter Last Name" name="lastname" id="lastname" value="<c:if test="${not empty lastName}">${lastName}</c:if>">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" placeholder="Enter Email" name="email" id="email" value="<c:if test="${not empty email}">${email}</c:if>">
    </div>
    <div class="form-group">
        <label for="pwd">Password</label>
        <input type="password" class="form-control" placeholder="Enter Password" name="pwd" id="pwd">
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
</form>

<%@include file="includes/footer.jsp" %>
