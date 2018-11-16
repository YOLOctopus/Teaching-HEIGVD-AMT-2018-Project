<%--
    Document   : applications
    Created on : 28.10.2018
    Author     : Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
    Goal       : Show applications list of a user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="includes/header.jsp" %>

<c:if test="${empty user}">
    <c:redirect url="/pages/login"/>
</c:if>

<c:if test="${not admin && idUser != id}">
    <c:redirect url="/pages/home"/>
</c:if>

<div class="clearfix mb-2">
    <h1 class="d-inline">Applications</h1>
    <form action="pages/newapplication" method="post" class="d-inline">
        <input type="hidden" name="id" value="${idUser}">
        <button type="submit" class="btn btn-sm btn-primary btn-right-w float-right" id="newapp-btn">New app</button>
    </form>
</div>

<hr />

<div class="clearfix mb-2">
    <form class="form-inline d-inline float-left" method="get" action="pages/applications">
        <input name="query" class="form-control form-control-sm w-100" type="text" placeholder="Search" aria-label="Search" id="search">
        <input type="hidden" value="${idUser}" name="user">
        <i class="fa fa-search" aria-hidden="true"></i>
    </form>

    <div class="dropdown d-inline float-right">
        <button class="btn btn-sm btn-outline-primary btn-right-w dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Apps per page
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="pages/applications?user=${idUser}&pagesize=5" id="pagesize-5">5</a>
            <a class="dropdown-item" href="pages/applications?user=${idUser}&pagesize=10" id="pagesize-10">10</a>
            <a class="dropdown-item" href="pages/applications?user=${idUser}&pagesize=20" id="pagesize-20">20</a>
            <a class="dropdown-item" href="pages/applications?user=${idUser}&pagesize=50" id="pagesize-50">50</a>
        </div>
    </div>
</div>

<c:if test="${not empty applications}">
    <div class="list-group">
        <c:forEach items="${applications}" var="application">
            <div class="list-group-item list-group-item-action">
                <div>
                    <a class="list-title" href="pages/application?id=${application.getId()}">
                        <span>${application.getName()}</span>
                    </a>
                    <div class="list-subtitle">
                        ${application.getDescription()}
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>

<c:if test="${totalSize > pageSize}">
    <nav>
        <ul class="pagination pagination-sm justify-content-center mt-2">
            <c:choose>
                <c:when test="${page > 0}">
                    <li class="page-item"><a class="page-link" href="pages/applications?user=${idUser}&page=${page-1}&pagesize=${pageSize}" id="previous">Previous</a></li>
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
                    <li class="page-item"><a class="page-link" href="pages/applications?user=${idUser}&page=${page+1}&pagesize=${pageSize}" id="next">Next</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item disabled"><a class="page-link" href="applications/users?user=${idUser}&page=${page+1}&pagesize=${pageSize}">Next</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
</c:if>

<%@include file="includes/footer.jsp" %>