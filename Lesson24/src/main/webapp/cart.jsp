<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Cart</title>
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
            <a class="nav-link" href="${contextPath}/home">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/mypage.jsp">MyPage</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/cart">Корзина</a>
        </li>
    </ul>
    <form class="form-inline" action="#">
        <input class="form-control mr-sm-2" type="text" placeholder="Search">
        <button class="btn btn-success" type="submit">Search</button>
    </form>
</nav>
<div class="container">
    <form method="post" action="cart" accept-charset="UTF-8">
        <table class="table-responsive-xl">
            <thead>
            <tr>
                <h4>Корзина</h4>
            </tr>
            </thead>
            <c:if test="${not empty user.getCart().getProducts()}">
                <c:forEach items="${user.getCart().getProducts()}" var="product">
                    <tbody>
                    <tr>
                        <td>
                            <img class="rounded" style="width: 25%;height: auto"
                                 src="${contextPath}/images/product/${product.getValue().getImg()}" alt="Card image">
                        </td>
                        <td>
                            <h6>Модель ${product.getValue().getName()}</h6>
                            <br>
                            <h6>Цена ${product.getValue().getPrice()} BYN</h6>
                            <br>
                            <button type="submit" class="btn btn-primary" name="remove"
                                    value="${product.getKey()}">Удалить
                            </button>
                            <br>
                        </td>
                    </tr>
                    </tbody>
                    <br>
                </c:forEach>
            </c:if>
        </table>
        <h5>Общая стоимость корзины ${user.getCart().getTotalPrice()} BYN</h5>

        <button type="submit" class="btn btn-primary" name="action"
                value="clear">Очистить корзину
        </button>
        <button type="submit" class="btn btn-primary" name="action"
                value="buy">Купить товары
        </button>
    </form>

</div>
</body>
</html>
