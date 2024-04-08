<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
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
    h2 {
        margin-top: 0;
        font-size: 24px;
        color: #333;
    }
    input[type="text"],
    input[type="number"],
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
</style>
</head>
<body>
<div class="container">
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<h2><%=message %></h2>
<%} %>
    <h2>User Registration</h2>
    <form action="details" method="post">
        <label for="id">ID:</label><br>
        <input type="number" id="id" name="id"><br><br>
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br><br>
        <label for="phone">Phone:</label><br>
        <input type="number" id="phone" name="phone"><br><br>
        <label for="address">Address:</label><br>
        <input type="text" id="address" name="address"><br><br>
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email"><br><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br><br>
        <button>Register</button>
    </form>
</div>
</body>
</html>
