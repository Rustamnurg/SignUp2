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
Weather <c:out value="${MessageTemp}" default="none"/> K


</body>
</html>
