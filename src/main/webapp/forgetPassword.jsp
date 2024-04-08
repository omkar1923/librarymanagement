<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Reset</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f2f5;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 400px;
        margin: 100px auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    form {
        margin-top: 20px;
    }
    input[type="number"],
    input[type="text"] {
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
    <h2>Password Reset</h2>
    <form action="reset" method="post">
        <label for="id">ID</label><br>
        <input type="number" id="id" name="id"><br>
        <label for="newpassword">New Password</label><br>
        <input type="text" id="newpassword" name="newpassword"><br>
        <button>Update Password</button>
    </form>
</div>
</body>
</html>
