<%@include file="includes/header.jsp" %>

<form action="pages/application" method="post">

    <input type="text" value="${application.getName()}" name="name"><br/>
    <textarea class="form-control" rows="5" id="description">${application.getDescription()}</textarea>
</form>

<%@include file="includes/footer.jsp" %>