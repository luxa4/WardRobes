
<%--
  Created by IntelliJ IDEA.
  User: Саша
  Date: 25.06.2020
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Shop of Wardrobes </title>
    <%--<link href="<c:url value="/static/css/font-awesome.css" />" rel="stylesheet">--%>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/bootstrap-grid.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/application.css" />" rel="stylesheet" type="text/css">
    <link href="<c:url value="/static/css/all.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="fragments/header.jsp" %>


<div class="container-fluid" >
    <div class="row marginContent-10">
        <search class="col-12 col-sm-6 col-md-4 col-lg-2 col-xl-2">
            <%@include file="fragments/searchfilter.jsp" %>
        </search>
        <main class="col-12 col-sm-6 col-md-8 col-lg-10 col-xl-10">
            <div class="container-fluid">
                <div class="row">
                    <c:forEach var="product" items="${productList}">
                        <div class="col-12 col-sm-6 col-md-6 col-lg-2 col-xl-2" >
                            <div class="myCard" style="width: 18rem;">
                                <img src="${product.imageUrl}" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <a href="/product/${product.id}"> <p class="card-text">${product.name}</p> </a>
                                    <p class="card-text">Price: ${product.price}</p>
                                    <p class="card-text">Size: ${product.length}x${product.width}x${product.height} cm</p>
                                    <p class="card-text">Status: ${product.status}</p>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </main>
     </div>
</div>

<%@include file="fragments/footer.jsp" %>


<script src="<c:url value="/static/js/jquery.js"/>" ></script>
<script src="<c:url value="/static/js/bootstrap.js"/>" ></script>
<%--<script src="<c:url value="/static/js/app.js"/>" ></script>--%>
</body>
</html>
