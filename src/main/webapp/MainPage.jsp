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
    <title>MainPage</title>
</head>
<body>


Welcome <c:out value="${MessageName}" default="noname"/> ! <br/>
Weather <c:out value="${MessageTemp}" default="none"/>



<form id="form" action="<c:url value="/buttonsHandler"/>" method='post'>
    <textarea name="content" cols="20" rows="3" wrap="off"></textarea><br>
    <p><input type="submit" value="add" name="add"></p>
</form>


<c:forEach var="posts" items="${linkedList}">
    <div class="content">
        <p>${posts.getContent()}</p>
        <p>${posts.getLoginAutor()} ${posts.getDate()} </p>
        <form id="formWorkWithPosts" action="<c:url value="/buttonsHandler"/>" method='post'>
            <p>
                <input type="hidden" value=${posts.getId_posts()} name="idPosts">
                <c:if test="${posts.getIsEditable()}">
                    <input type="submit" value="Edit" name="Edit" class=button-for-jquery">
                    <input type="submit" value="Delete" name="Delete">
                    <%--<textarea name="edit-field" class="field-jquery" style="display: none;" cols="20" rows="3"--%>
                              <%--wrap="off"></textarea><br>--%>
                </c:if>
                <c:if test="${posts.getIsLikes()}">
                <input type="submit" value="Like" name="Like"> ${posts.getLikes()}--
                </c:if>
                <c:if test="${!posts.getIsLikes()}">
                    <input type="submit" value="Like" name="Like"> ${posts.getLikes()}++
                </c:if>
            </p><br>
        </form>
        <br/> <br/>
    </div>
</c:forEach>


<%--<c:forEach var="posts" items="${linkedList}">--%>
    <%--<div class="content">--%>
        <%--<p>${posts.getContent()}</p>--%>
        <%--<p>id Users - ${posts.getId_author()} time - ${posts.getDate()} </p>--%>
        <%--<form id="formWorkWithPosts" action="<c:url value="/buttonsHandler"/>" method='post'>--%>
            <%--<p>--%>
                <%--<input type="hidden" value=${posts.getId_posts()} name="idPosts">--%>
                <%--<c:if test="${posts.getId_author() == idUsers}">--%>
                    <%--<input type="submit" value="Edit" name="Edit" class=button-for-jquery">--%>
                    <%--<input type="submit" value="Delete" name="Delete">--%>
                    <%--&lt;%&ndash;<textarea name="edit-field" class="field-jquery" style="display: none;" cols="20" rows="3"&ndash;%&gt;--%>
                    <%--&lt;%&ndash;wrap="off"></textarea><br>&ndash;%&gt;--%>
                <%--</c:if>--%>
                <%--<input type="submit" value="Like" name="Like"> 3--%>
            <%--</p><br>--%>



        <%--</form>--%>
        <%--<br/> <br/>--%>
    <%--</div>--%>
<%--</c:forEach>--%>
<%--<script>--%>
    <%--var re = /^\d[0-9,]+\d$/;--%>

<%--if (re.test( "227,30,218,9,245,6,256,15,246,26" ) ) {--%>

<%--alert("Данная строка соответсвует заявленому патерну");--%>

<%--}--%>



<%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"--%>
        <%--integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>--%>

<%--<script>--%>
    <%--$('.button-for-jquery').click(function() {--%>
        <%--$('.field-jquery').toggle(500);--%>
    <%--});--%>
<%--</script>--%>

</body>
</html>
