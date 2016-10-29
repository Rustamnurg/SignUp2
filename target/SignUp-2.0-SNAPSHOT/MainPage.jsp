<%@ page import="java.util.LinkedList" %>
<%--
  Created by IntelliJ IDEA.
  Essence: Rustam
  Date: 11.10.16
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    <%@include file='css/style.css' %>
</style>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="min-width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=no;">
    <title>MainPage</title>
</head>
<body>
<header>
<nav>
    <ul>
        <li class="active"><a href="#">Blog</a></li>
        <li><a href="">Users</a></li>
        <li><a href="">About</a></li>
        <li><a href="">Contact</a></li>
        <li><a href="">Settings</a></li>
    </ul>
</nav>
</header>


<%--Welcome <c:out value="${MessageName}" default="noname"/> ! <br/>--%>
<%--Weather <c:out value="${MessageTemp}" default="none"/>--%>

<div class="wrapper">
    <h1><a href="#">Rustameil</a> </h1>
    <div class="body">
        <div class="contentBody"><article>
<form id="form" action="<c:url value="/buttonsHandler"/>" method='post'>
    <textarea name="content" cols="20" rows="3" wrap="off"></textarea><br>
    <p><input type="submit" value="Add" name="action"></p>
</form>
            </article>

<c:forEach var="posts" items="${linkedList}">
            <article>
    <div class="content">
        <p>${posts.getContent()}</p>
        </br>
        <p>${posts.getLoginAutor()} ${posts.getDate()} </p>
        <form id="formWorkWithPosts" action="<c:url value="/buttonsHandler"/>" method='post'  value="null" name="action" >
            <p>

                <input type="hidden" value=${posts.getId_posts()} name="idPosts">
                <c:if test="${edit}">
                   <p></p> <textarea name="edit-field" cols="20" rows="3"
                              wrap="off"></textarea><br>
                    <input type="submit" value="EditSend" name="action"></p>
                </c:if>

                <c:if test="${posts.getIsEditable()}">
                    <input type="submit" value="Edit" name="action" class=button-for-jquery">
                    <input type="submit" value="Delete" name="action">
                </c:if>
                <c:if test="${posts.getIsLikes()}">
                    <input type="submit" value="DeleteLikes" name="action"> ${posts.getLikes()}

                </c:if>
                <c:if test="${!posts.getIsLikes()}">
                    <input type="submit" value="AddLikes" name="action"> ${posts.getLikes()}
                </c:if>
            </p><br>

        </form>
        <br/> <br/>
    </div>
                </article>
</c:forEach>

        </div>
        <%--<aside>--%>
            <%--<div class="sidebar">--%>
                <%--<h2>Sidebar</h2>--%>
                <%--<ul>--%>
                    <%--<li><a href="">Lorem Ipsum is</a></li>--%>
                    <%--<li><a href="">Simply dummy</a></li>--%>
                    <%--<li><a href="">Text of the printing</a></li>--%>
                    <%--<li><a href="">And typesetting</a></li>--%>
                    <%--<li><a href="">Industry lorem</a></li>--%>
                    <%--<li><a href="">Ipsum has been</a></li>--%>
                    <%--<li><a href="">The industry's</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
            <%--<div class="sidebar">--%>
                <%--<h2>Sidebar</h2>--%>
                <%--<ul>--%>
                    <%--<li><a href="">Lorem Ipsum is</a></li>--%>
                    <%--<li><a href="">Simply dummy</a></li>--%>
                    <%--<li><a href="">Text of the printing</a></li>--%>
                    <%--<li><a href="">And typesetting</a></li>--%>
                    <%--<li><a href="">Industry lorem</a></li>--%>
                    <%--<li><a href="">Ipsum has been</a></li>--%>
                    <%--<li><a href="">The industry's</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</aside>--%>
    </div>
</div>
<footer>footer</footer>
</body>
</html>