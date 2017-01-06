<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 21.11.2016
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proselyte</title>
</head>
<body>
<h3>Proselyte presents</h3>
<br/>
<a href="<c:url value="/users"/>">Books list</a>
<br/>
</body>
</html>