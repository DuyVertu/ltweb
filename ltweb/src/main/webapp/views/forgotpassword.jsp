<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên Mật Khẩu</title>
</head>
<body>
    <h2>Quên Mật Khẩu</h2>

    <c:if test="${not empty alert}">
        <div style="color: red;">
            ${alert}
        </div>
    </c:if>

    <form action="${pageContext.request.contextPath}/forgot-password" method="post">
        <label for="username">Tên đăng nhập:</label><br>
        <input type="text" id="username" name="username" required><br><br>

        <label for="newPassword">Mật khẩu mới:</label><br>
        <input type="password" id="newPassword" name="newPassword" required><br><br>

        <button type="submit">Cập nhật mật khẩu</button>
    </form>

    <p><a href="${pageContext.request.contextPath}/login">Quay lại trang đăng nhập</a></p>
</body>
</html>
