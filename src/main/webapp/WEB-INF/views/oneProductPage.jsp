
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
    <link href="<c:url value="/static/css/bootstrap-grid.css" />" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/static/css/myapp.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/static/css/all.css" />" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/static/css/jquery-ui.css" />" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish&display=swap" rel="stylesheet">
</head>
<body>
<%@include file="fragments/header.jsp" %>
<div class="container" >
    <div class="row justify-content-center">
        <div class="card" style="width: 18rem;">
            <img src="${product.imageUrl}" class="card-img-top" alt="...">
            <div class="card-body">
                <input id="productId" type="hidden" name="productId" value="${product.id}" />
                <p class="card-text">${product.name}</p>
                <p class="card-text marginCartBottom-1"><b>Price:</b> ${product.price} €</p>
                <p class="card-text marginCartBottom-1"><b>Size:</b> ${product.length}x${product.width}x${product.height} cm</p>
                <p class="card-text marginCartBottom-1"><b>Status:</b> ${product.status}</p>
                <div class="w-100"></div>
                    <input id="count" type="number" name="count"  value="1" min="1" max="5" />
                    <button id="addToCart" type="submit" class="btn btn-warning w-100"><i class="fas fa-dolly-flatbed normal"></i> Add to shopping cart </button>
                </div>
        </div>
    </div>
</div>
<%@include file="fragments/footer.jsp" %>


<script src="<c:url value="/static/js/jquery.js"/>" ></script>
<script src="<c:url value="/static/js/bootstrap.js"/>" ></script>
<script src="<c:url value="/static/js/application.js"/>" ></script>
</body>
</html>
