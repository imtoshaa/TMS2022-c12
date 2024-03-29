<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MyPage</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/eshop?command=start-page">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/eshop?command=redirect-to-my-page">MyPage</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${contextPath}/eshop?command=redirect-to-shopping-cart">Корзина</a>
        </li>
    </ul>
    <form class="form-inline" method="post" action="eshop?command=search-page">
        <input class="form-control mr-sm-2" type="text" id="searchQuery"
               placeholder="Search product" name="searchQuery"
               required>
        <button class="btn btn-success" type="submit" >Search</button>
    </form>
</nav>
<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-4">
            <h2>Пользователь ${user.getName()}</h2>
            <img class="card-img" style="width: 100%;height: auto"
                 src="${contextPath}/images/users/${user.getImg()}" alt="Card image">
            <hr class="d-sm-none">
        </div>
        <div class="col-sm-8">
            <h2>О пользователе</h2>
            <p>Привет, ${user.getName()}!</p>
            <p>Информация о пользователе:</p>
            <p>Имя: ${user.getName()}</p>
            <p>Фамилия: ${user.getSurname()}</p>
            <p>День рождения: ${user.getBirthday()}</p>
            <p>Имя: ${user.getEmail()}</p>
            <p>${user.getInfo()}</p>
            <p><h4>История покупок</h4></p>
            <div class="container-fluid">
                <c:if test="${not empty orderHistory}">
                    <div class="row">
                        <c:forEach items="${orderHistory}" var="order">
                            <div class="card w-25 m-1" type="category">
                                <div class="card-body">
                                    <img class="card-img" style="width:150px;height:120px"
                                         src="${contextPath}/images/product/${order.getValue().getProduct().getImg()}"
                                         alt="Card image">
                                    <br>
                                    <h6>Дата заказа: ${order.getValue().getDate()}</h6>
                                    <h6>Модель: ${order.getValue().getProduct().getName()}</h6>
                                    <br>
                                    <h6>Цена: ${order.getValue().getProduct().getPrice()} BYN</h6>
                                    <br>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${empty orderHistory}">
                    <p><h4>Тут пока пусто. Купите что-нибудь!</h4></p>
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>
</html>
