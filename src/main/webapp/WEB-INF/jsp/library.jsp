<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Список перелетов:</h1>
<ul>
    <c:forEach var="book" items="${requestScope.booksList}">
        <li>
            <a href="${pageContext.request.contextPath}/book?bookId=${book.id}">${book.description}</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>