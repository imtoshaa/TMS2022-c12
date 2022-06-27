<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Categories</title>
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
<div class="container" style="margin-top:30px">
    <h2>Popular categories</h2>

    <div class="container-fluid">
        <c:if test="${not empty categories}">
            <div class="row">
                <c:forEach items="${categories}" var="category">
                    <div class="card w-25 m-1" type="category">
                        <div class="card-body">
                            <a class="btn btn-primary" href="${contextPath}/eshop?command=category-redirect&categoryName=${category.getId()}"
                               role="button">${category.getName()}</a>
                            <img class="card-img" style="width:150px;height:120px"
                                 src="${contextPath}/images/category/${category.getImg()}" alt="Card image">
                            <br>
                            <a>${category.getDescription()}</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>

