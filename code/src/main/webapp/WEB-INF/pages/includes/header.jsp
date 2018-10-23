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
        <link rel="stylesheet" href="static/css/styles.css" />
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <script src="static/js/jquery.min.js"></script>
        <script src="static/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container">
        <div class="topMenu">
            <div>logo</div>
            <div>Gamification API</div>
            <div><a href="./pages/login">Log in</a></div>
        </div>