<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="includes/header.jsp" %>

<div class="clearfix mb-2">
    <h1 class="d-inline mb-2">Users</h1>
</div>

<hr />

<div class="clearfix mb-2">
    <form class="form-inline d-inline float-left" method="get" action="pages/users">
        <input name="query" class="form-control form-control-sm w-100" type="text" placeholder="Search" aria-label="Search">
        <i class="fa fa-search" aria-hidden="true"></i>
    </form>

    <div class="dropdown d-inline float-right">
        <button class="btn btn-outline-primary btn-sm btn-right-w dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Users per page
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="pages/users?pagesize=5">5</a>
            <a class="dropdown-item" href="pages/users?pagesize=10">10</a>
            <a class="dropdown-item" href="pages/users?pagesize=20">20</a>
            <a class="dropdown-item" href="pages/users?pagesize=50">50</a>
        </div>
    </div>
</div>
<form action="pages/users" method="post">
    <c:if test="${not empty users}">
        <div class="list-group">
            <c:forEach items="${users}" var="client">
                <div class="list-group-item list-group-item-action">
                    <div class="clearfix">
                        <a class="list-title d-inline float-left" href="pages/applications?user=${client.getId()}">
                            <span>${client.getFirstName()} ${client.getLastName()}</span>
                        </a>
                        <div class="form-check d-inline float-right">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1" name="users" value="${client.getId()}">
                        </div>
                    </div>
                    <div class="list-subtitle">
                        ${client.getEmail()}
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>

    <c:if test="${fn:length(users) >= pageSize}">
        <nav>
            <ul class="pagination pagination-sm justify-content-center mt-2">
                <c:choose>
                    <c:when test="${page > 0}">
                        <li class="page-item"><a class="page-link" href="pages/users?page=${page-1}&pagesize=${pageSize}">Previous</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled"><a class="page-link" href="pages/users?page=${page-1}&pagesize=${pageSize}">Previous</a></li>
                    </c:otherwise>
                </c:choose>

                <c:forEach begin="${minPage}" end="${maxPage}" var="i">
                    <c:choose>
                        <c:when test="${i == page}">
                            <li class="page-item active"><a class="page-link" href="pages/users?page=${i}&pagesize=${pageSize}">${i+1}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item"><a class="page-link" href="pages/users?page=${i}&pagesize=${pageSize}">${i+1}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${page < maxPage}">
                        <li class="page-item"><a class="page-link" href="pages/users?page=${page+1}&pagesize=${pageSize}">Next</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item disabled"><a class="page-link" href="pages/users?page=${page+1}&pagesize=${pageSize}">Next</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </nav>
    </c:if>
    <input type="submit" class="btn btn-danger" name="reset" value="Reset password">
    <input type="submit" class="btn btn-warning" name="setactive" value="Toggle active">
</form>
<%@include file="includes/footer.jsp" %>