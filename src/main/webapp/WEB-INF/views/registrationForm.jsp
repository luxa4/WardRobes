<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 23.06.2020
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:form method="post" action="/registration" modelAttribute="UserFromRegistrationForm" >
    Name
    <spring:input path="name" />
    Password
    <spring:input path="password" />
    Email
    <spring:input path="email" />
    <spring:button name="ok" value="Add user">Add User</spring:button>
</spring:form>
</body>
</html>
