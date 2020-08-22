<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 05.07.2020
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shop of Wardrobes </title>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/bootstrap-grid.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/myapp.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/static/css/all.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container-fluid">
   <div class="d-flex flex-column h-100 justify-content-center align-items-center">
       <div><h3>Login</h3></div>
       <div class="col-10 col-sm-8 col-md-6 col-lg-4 col-xl-3">
           <div class="card x">
               <div class="card-body">
                   <spring:form action="/authentication" method="post" >
                       <div class="form-group">
                           <label for="exampleInputEmail1">User name</label>
                           <input type="text" class="form-control" id="exampleInputEmail1" name="username">
                               <%--<small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>--%>
                       </div>
                       <div class="form-group">
                           <label for="exampleInputPassword1">Password</label>
                           <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                       </div>
                       <div class="container-fluid" >
                           <div class="row align-items-center justify-content-between" >
                              <div>
                                   <button type="submit" class="btn btn-primary ">Log In</button>
                              </div>
                               <div>
                                   <a href="/registration" class="text-primary text-right" > Create account </a>
                               </div>

                           </div>
                       </div>
                   </spring:form>
               </div>
           </div>
       </div>

   </div>
</div>
</body>
</html>
