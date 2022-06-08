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
                <c:if test="${not empty user.getCart().getStory()}">
                    <div class="row">
                        <c:forEach items="${user.getCart().getStory()}" var="product">
                            <div class="card w-25 m-1" type="category">
                                <div class="card-body">
                                    <img class="card-img" style="width:150px;height:120px"
                                         src="${contextPath}/images/product/${product.getValue().getImg()}"
                                         alt="Card image">
                                    <br>
                                    <h6>Модель: ${product.getValue().getName()}</h6>
                                    <br>
                                    <h6>Цена: ${product.getValue().getPrice()} BYN</h6>
                                    <br>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <c:if test="${empty user.getCart().getStory()}">
                    <p><h4>Тут пока пусто. Купите что-нибудь!</h4></p>
                </c:if>
            </div>
        </div>
    </div>
</div>

</body>
</html>
