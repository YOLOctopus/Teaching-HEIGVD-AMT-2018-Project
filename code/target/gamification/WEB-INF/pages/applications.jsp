<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="includes/header.jsp" %>

<form class="form-inline " method="get" action="pages/applications">
    <input name="query" class="form-control form-control-sm mr-3 w-75" type="text" placeholder="Search" aria-label="Search">
    <i class="fa fa-search" aria-hidden="true"></i>
</form>

<c:if test="${not empty applications}">
    <div class="list-group">
        <c:forEach items="${applications}" var="application">
            <a href="pages/application?id=${application.getId()}" class="list-group-item list-group-item-action">
                ${application.getName()} <br>
                ${application.getDescription()}
            </a>
        </c:forEach>
    </div>
</c:if>
<c:if test="${fn:length(applications) >= pageSize}">
    <nav aria-label="navigation">
        <ul class="pagination">
            <c:choose>
                <c:when test="${page > 0}">
                    <li class="page-item"><a class="page-link" href="pages/applications?user=${idUser}&page=${page-1}&pagesize=${pageSize}">Previous</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled"><a class="page-link" href="pages/applications?user=${idUser}&page=${page-1}&pagesize=${pageSize}">Previous</a></li>
                </c:otherwise>
            </c:choose>

            <c:forEach begin="${minPage}" end="${maxPage}" var="i">
                <c:choose>
                    <c:when test="${i == page}">
                        <li class="page-item active"><a class="page-link" href="pages/applications?user=${idUser}&page=${i}&pagesize=${pageSize}">${i+1}</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="pages/applications?user=${idUser}&page=${i}&pagesize=${pageSize}">${i+1}</a></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <c:choose>
                <c:when test="${page < maxPage}">
                    <li class="page-item"><a class="page-link" href="pages/applications?user=${idUser}&page=${page+1}&pagesize=${pageSize}">Next</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled"><a class="page-link" href="applications/users?user=${idUser}&page=${page+1}&pagesize=${pageSize}">Next</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</c:if>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Elements to display
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <a class="dropdown-item" href="pages/applications?pagesize=5">5</a>
        <a class="dropdown-item" href="pages/applications?pagesize=10">10</a>
        <a class="dropdown-item" href="pages/applications?pagesize=20">20</a>
        <a class="dropdown-item" href="pages/applications?pagesize=50">50</a>
    </div>
</div>

<%@include file="includes/footer.jsp" %>