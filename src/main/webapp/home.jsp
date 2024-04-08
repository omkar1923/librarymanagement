<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LibrarianPro - Facebook Login</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
    }
    .container {
        max-width: 400px;
        margin: 50px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        margin-top: 50px;
        font-size: 36px;
        color: #1877f2;
        text-align: center;
    }
    h2 {
        margin-top: 0;
        font-size: 24px;
        color: #1877f2;
    }
    input[type="text"],
    input[type="password"] {
        width: calc(100% - 20px);
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #dddfe2;
        border-radius: 5px;
    }
    button {
        width: calc(100% - 20px);
        padding: 10px;
        margin: 10px 0;
        border: none;
        border-radius: 5px;
        background-color: #1877f2;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
    }
    button:hover {
        background-color: #1467c2;
    }
    a {
        color: #1877f2;
        text-decoration: none;
    }
    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
<h1>LibrarianPro</h1>
<div class="container">
    <h2>Log in to Library</h2>
    <%String message=(String)request.getAttribute("message"); %>
    <%if(message!=null){ %>
   <h2> <%=message %></h2>
   <%} %>
    <form action="login" method="post">
        <label for="id">Email</label><br>
        <input type="text" id="email" name="email"><br><br>
        <label for="password">Password</label><br>
        <input type="password" id="password" name="password"><br><br>
        <button>Login</button>
    </form>
    <p><a href="forgetPassword.jsp">Forgot password?</a></p>
</div>
<div class="container">
    <h2>Create a New Account</h2>
    <p>It's quick and easy.</p>
    <a href="resister.jsp">Sign Up</a>
</div>
</body>
</html>
