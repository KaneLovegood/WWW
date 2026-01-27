<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Form</title>
</head>
<body>
<h1>HTML FORM EXPAMPLE WITH FILE UPLOAD</h1>
<br>
<form action="${pageContext.request.contextPath}/form" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"><br><br>

    Gender:
    <input type="radio" name="gender" value="Male"> Male
    <input type="radio" name="gender" value="Female"> Female
    <br><br>

    Hobbies:
    <input type="checkbox" name="hobbies" value="Reading"> Reading
    <input type="checkbox" name="hobbies" value="Music"> Music
    <input type="checkbox" name="hobbies" value="Sport"> Sport
    <br><br>

    Country:
    <select name="country">
        <option value="Vietnam">Việt Nam</option>
        <option value="USA">USA</option>
        <option value="Japan">Japan</option>
    </select>
    <br><br>

    Birthday:<input type="datetime-local" name="birthday">
    <br><br>

    Profile picture:<input type="file" name="picture">
    <br><br>

    <button type="submit">submit</button>
</form>

</body>
</html>