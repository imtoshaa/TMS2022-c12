<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Category</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/eshop?command=start-page">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/mypage.jsp">MyPage</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/eshop?command=redirect-to-shopping-cart">Корзина</a>
        </li>
    </ul>
    <form class="form-inline" action="#">
        <input class="form-control mr-sm-2" type="text" placeholder="Search">
        <button class="btn btn-success" type="submit">Search</button>
    </form>
</nav>
<div class="container">
    <table class="table-responsive-xl">
        <tbody>
        <tr>
            <td>
                <img class="rounded" style="width: 100%;height: auto"
                     src="${contextPath}/images/product/${product.getImg()}" alt="Card image">
            </td>
            <td>
                <h6>Модель: ${product.getName()}</h6>
                <br>
                <h6>Описание: ${product.getDescription()}</h6>
                <br>
                <h6>Цена: ${product.getPrice()} BYN</h6>
                <br>
                <a href="${contextPath}/eshop?command=add-product-to-cart&productId=${product.getId()}" class="btn btn-primary">Купить</a>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
