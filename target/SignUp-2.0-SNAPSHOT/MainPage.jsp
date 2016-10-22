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

<form id="form" action="<c:url value="/AddPostsServlet"/>" method='post'>
    <textarea name="content" cols="20" rows="3" wrap="off"></textarea><br>
    <p><input type="submit"></p>
</form>


<c:forEach var="posts" items="${linkedList}">
   <div class="content" class = "'${posts.getId_posts()}'">
       <p>${posts.getContent()}</p>
       <p>${posts.getDate()}</p>
       <form id="formWorkWithPosts" action="<c:url value="/"/>" method='post'>
           <p><input type="submit" value="Редактировать">
               <input type="submit" value="Понравилось"> 3</p>
       </form>
       <br/> <br/>
    </div>
</c:forEach>




</body>
</html>