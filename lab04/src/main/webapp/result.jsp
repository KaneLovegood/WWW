<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
</head>
<body>
<h1>HTML FORM EXPAMPLE WITH FILE UPLOAD</h1>
<br>
<h2>Form Result</h2>

<p>Name: ${name}</p>
<p>Gender: ${gender}</p>
<p>Country: ${country}</p>
<p>Birthday: ${birthday}</p>

<p>Hobbies:
    <c:if test="${not empty hobbies}">
        <c:forEach var="h" items="${hobbies}">
            ${h}&nbsp;
        </c:forEach>
    </c:if>
    <c:if test="${empty hobbies}">
        None
    </c:if>
</p>

<c:if test="${not empty image}">
    <h3>Profile Picture</h3>
    <img src="${pageContext.request.contextPath}/uploads/${image}"
         width="200"/>
</c:if>
</body>
</html>