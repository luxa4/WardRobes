
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
    <title>Wardrobes - ${product.name}</title>
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/all.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="fragments/header.jsp" %>


<div class="container" >
    <div class="row justify-content-center">
        <div class="card" style="width: 18rem;">
            <img src="${product.imageUrl}" class="card-img-top" alt="...">
            <div class="card-body">
                <p class="card-text">${product.name}</p>
                <p class="card-text marginCartBottom-1"><b>Price:</b> ${product.price} €</p>
                <p class="card-text marginCartBottom-1"><b>Size:</b> ${product.length}x${product.width}x${product.height} cm</p>
                <p class="card-text marginCartBottom-1"><b>Status:</b> ${product.status}</p>
                <div class="w-100"></div>
                <a href="/addToShoppingCart" ><button type="button" class="btn btn-warning"><i class="fas fa-dolly-flatbed"></i> Add to shopping cart </button></a>
            </div>
        </div>
    </div>
</div>
<%@include file="fragments/footer.jsp" %>


<script src="<c:url value="/static/js/jquery.js"/>" ></script>
<script src="<c:url value="/static/js/bootstrap.js"/>" ></script>
<%--<script src="<c:url value="/static/js/app.js"/>" ></script>--%>
</body>
</html>
