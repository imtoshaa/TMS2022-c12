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
            <a class="nav-link" href="${contextPath}/">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/mypage/open">MyPage</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/cart/open">Корзина</a>
        </li>
    </ul>
    <form class="form-inline" method="post" action="${contextPath}/search">
        <input class="form-control mr-sm-2" type="text" id="searchQuery"
               placeholder="Search product" name="searchQuery"
               required>
        <button class="btn btn-success" type="submit" >Search</button>
    </form>
</nav>
<div class="container">
    <table class="table-responsive-xl">
        <thead>
        <tr>
            <th>Information</th>
        </tr>
        </thead>
        <c:if test="${not empty productsFromCategory}">
            <c:forEach items="${productsFromCategory}" var="product">
                <tbody>
                <tr>
                    <td>
                        <img class="rounded" style="width: 25%;height: auto"
                             src="${contextPath}/images/product/${product.getImg()}" alt="Card image">
                    </td>
                    <td>
                        <h6>Модель ${product.getName()}</h6>
                        <br>
                        <h6>Цена ${product.getPrice()} BYN</h6>
                        <br>
                        <a href="${contextPath}/product/${product.getId()}" class="btn btn-primary">Перейти к товару</a>
                        <br>
                    </td>
                </tr>
            </tbody>
                <br>
            </c:forEach>
        </c:if>
    </table>
</div>
</body>
</html>
