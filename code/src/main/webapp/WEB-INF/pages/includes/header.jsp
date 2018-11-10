<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: samuel
  Date: 10/22/18
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <base href="${pageContext.request.contextPath}/">
        <title>${pageTitle}</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js"
                integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
                crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="static/css/styles.css" />
    </head>
    <body>
        <div>
            <nav class="navbar navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="" width="30" height="30" class="d-inline-block align-top" alt="">
                    Gamification API
                </a>
                <c:choose>
                    <c:when test="${user != null}">
                        <c:if test="${admin}">
                            <a class="nav-item ml-2" href="pages/users">Users</a>
                        </c:if>
                        <a class="nav-item ml-auto" href="pages/logout">Logout</a>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-item ml-auto mr-2" href="pages/register">Register</a>
                        <a class="nav-item" href="pages/login">Log in</a>
                    </c:otherwise>
                </c:choose>
            </nav>
        </div>
        <div class="container">