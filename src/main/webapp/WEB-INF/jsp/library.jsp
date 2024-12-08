<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
<%@include file="fix/header.jsp"%>
<div>
    <c:forEach var="item" items="${bookList}">
        <div>
            <span>${item.name}</span>
        </div>
    </c:forEach>
</div>
<%@include file="fix/footer.jsp"%>
</body>
</html>