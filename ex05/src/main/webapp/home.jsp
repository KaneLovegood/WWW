<%--
  Created by IntelliJ IDEA.
  User: khang1752004
  Date: 27/01/2026
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Xin chao, ${sessionScope.user}</h1>
    <a href="sercure/secret.jsp">Trang bao mat</a>
    <a href="${pageContext.request.contextPath}/logout">Dang xuat</a>

</body>
</html>
