<%--
    Document   : header
    Created on : 28.10.2018
    Author     : Samuel Mayor, Alexandra Korukova, Pierre-Samuel Rochat and Arnold von Bauer Gauss
    Goal       : Header included in every pages. Contains a menu leading to each pages of the website
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <base href="${pageContext.request.contextPath}/">
        <link rel="icon" type="image/png" href="static/images/gamification.png" />
        <title>${pageTitle}</title>
        <link rel="stylesheet" href="static/css/styles.css" />
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </head>
    <body>
        <div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">
                    <img src="static/images/gamification.png" height="40" class="d-inline mr-1" alt="">
                    <div class="d-inline" height="40">Gamification API</div>
                </a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <c:choose>
                        <c:when test="${user != null}">
                            <ul class="navbar-nav">
                                <c:if test="${admin}">
                                    <li class="nav-item">
                                        <a class="nav-link" href="pages/users">Users</a>
                                    </li>
                                </c:if>
                                <li class="nav-item">
                                    <a class="nav-link" href="pages/applications?user=${id}">Applications</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="pages/profile">Profile</a>
                                </li>
                            </ul>
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="pages/logout">Logout</a>
                                </li>
                            </ul>
                        </c:when>
                        <c:otherwise>
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item">
                                    <a class="nav-link" href="pages/register">Register</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="pages/login">Login</a>
                                </li>
                            </ul>
                        </c:otherwise>
                    </c:choose>
                </div>
            </nav>
        </div>
        <div class="container">