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
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.css" />"/>
</head>
<body>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td>
            <h3>Add User</h3>

            <c:url var="addAction" value="/users/add"/>
            <form:form action="${addAction}" commandName="user" modelAttribute="user">
                <table>
                    <c:if test="${user.id != 0}">
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="id" readonly="true" size="8" disabled="true" cssClass="form"/>
                                <form:hidden path="id"/>
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td>
                            <form:label path="name">
                                <spring:message text="Name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="name" cssClass="form"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="Age">
                                <spring:message text="age"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="age" cssClass="form"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="admin">
                                <spring:message text="Admin"/>
                            </form:label>
                        </td>
                        <td>
                            <form:select path="admin" cssClass="form">
                                <form:option value="true" label="true"/>
                                <form:option value="false" label="false"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <c:if test="${user.id != 0}">
                                <input class="form" type="submit"
                                       value="<spring:message text="Edit User" />"/>
                            </c:if>
                            <c:if test="${user.id == 0}">
                                <input class="form" type="submit"
                                       value="<spring:message text="Add User"/>"/>
                            </c:if>
                        </td>
                    </tr>
                </table>
            </form:form>

            <h3>User List</h3>

            <form:form action="/search" commandName="search">
                <form:input path="content"/>
                <input type="submit" value="<spring:message text="Search"/>"/>
            </form:form>


            <c:if test="${!empty listUsers}">
                <table width="100%" border="0" class="tg">
                    <tr id="users">
                        <th><strong>ID</strong></th>
                        <th><strong>Name</strong></th>
                        <th><strong>Age</strong></th>
                        <th><strong>Admin</strong></th>
                        <th><strong>Created Date</strong></th>
                        <th><strong>Edit</strong></th>
                        <th><strong>Delete</strong></th>
                    </tr>
                    <c:forEach items="${listUsers}" var="user">
                        <tr id="users">
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>${user.admin}</td>
                            <td>${user.createdDate}</td>
                            <td><a href="<c:url value="/edit/${user.id}"/>">Edit</a></td>
                            <td><a href="<c:url value="/remove/${user.id}"/>">Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
                <tag:paginate max="15" offset="${offset}" count="${count}"
                              uri="/users" next="&raquo;" previous="&laquo;" />
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>