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
        <p>${posts.getDate()}</p>
        <form id="formWorkWithPosts" action="<c:url value="/buttonsHandler"/>" method='post'>
            <p>
                <input type="hidden" value=${posts.getId_posts()} name="idPosts">
                <c:if test="${idUsers}">
                    <button name="Edit" class=button-for-jquery">Edit</button>
                    <input type="submit" value="Delete" name="Delete">
                </c:if>
                <input type="submit" value="Like" name="Like"> 3
            </p><br>
            <textarea name="edit-field" class="field-jquery"  cols="20" rows="3"
                      wrap="off"></textarea><br>
        </form>
        <br/> <br/>
    </div>
</c:forEach>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"
        integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>

<script>
    $('.button-for-jquery').click(function() {
        $('.field-jquery').hide(500);
    });
</script>

</body>
</html>
