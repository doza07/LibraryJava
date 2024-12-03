<%--
  Created by IntelliJ IDEA.
  User: dkhnykin
  Date: 03.12.2024
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <div>
        <span>Content. Russian</span>
        <p>Size: ${requestScope.library.size()}</p>
    </div>

<%@include file="footer.jsp"%>
</body>
</html>
