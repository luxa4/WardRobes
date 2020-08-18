<%--
  Created by IntelliJ IDEA.
  User: luxa4
  Date: 30.07.2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Shopping Address</title>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/bootstrap-grid.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/myapp.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/static/css/all.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container-fluid">
    <div class="d-flex flex-column h-100 justify-content-center align-items-center">
        <div><h3>Shipping Address</h3></div>
        <div class="col-10 col-sm-8 col-md-6 col-lg-4 col-xl-3">
            <div class="card x">
                <div class="card-body">
                    <spring:form modelAttribute="order">
                        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
                        <div class="form-group">
                            <label>Index</label>
                            <spring:input path="address.index"  type="text" class="form-control" />
                        </div>

                        <div class="form-group">
                            <label>Region</label>
                            <spring:input path="address.region" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>City</label>
                            <spring:input path="address.city" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Street</label>
                            <spring:input path="address.street" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>House</label>
                            <spring:input path="address.homeNumber" type="text" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Flat</label>
                            <spring:input path="address.flat" type="text" class="form-control" />
                        </div>
                        <a href="${flowExecutionUrl}&_eventId=cancel" class="btn btn-primary">Cancel</a>
                        <a href="${flowExecutionUrl}&_eventId=back" class="btn btn-primary">Back</a>
                        <button type="submit" name="_eventId_next" class="btn btn-primary">Next</button>
                    </spring:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
