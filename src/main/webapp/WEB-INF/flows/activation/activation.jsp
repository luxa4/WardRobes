<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 22.06.2020
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Activation</title>
</head>
<body>
<h2>Click to activate account</h2>



<form:form id="activation" method="post" action="${flowExecutionUrl}">
    <input type="submit" name="_eventId_activate" value="activate" />
    <input type="submit" name="_eventId_cancel" value="cancel" />
</form:form>



</body>
</html>
