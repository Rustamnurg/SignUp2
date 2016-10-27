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
    <p><input type="submit" value="Add" name="action"></p>
</form>


<c:forEach var="posts" items="${linkedList}">
    <div class="content">
        <p>${posts.getContent()}</p>
        <p>${posts.getLoginAutor()} ${posts.getDate()} </p>
        <form id="formWorkWithPosts" action="<c:url value="/buttonsHandler"/>" method='post'  value="null" name="action" >
            <p>

                <input type="hidden" value=${posts.getId_posts()} name="idPosts">
                <c:if test="${posts.getIsEditable()}">
                    <input type="submit" value="Edit" name="action" class=button-for-jquery">
                    <input type="submit" value="Delete" name="action">
                    <%--<textarea name="edit-field" class="field-jquery" style="display: none;" cols="20" rows="3"--%>
                    <%--wrap="off"></textarea><br>--%>
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
</c:forEach>



</body>
</html>
