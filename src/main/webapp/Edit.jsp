<%@page import="jsp_library.BookMain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
    }</style>
</head>
<body>
<%BookMain bookmain=(BookMain)request.getAttribute("update");  %>
<div class="container">
<form action="update" method="post">
        
          <label for="id">ID:</label><br>
        <input type="hidden" id="id" name="id" value=<%=bookmain.getId()  %>><br><br>
        <label for="title">Title:</label><br>
        <input type="text" id="title" name="title" value=<%= bookmain.getTitle() %>><br><br>
        <label for="author">Author:</label><br>
        <input type="text" id="author" name="author" value=<%= bookmain.getAuthor() %>><br><br>
        <label for="genre">Genre:</label><br>
        <input type="text" id="genre" name="genre" value=<%=bookmain.getGenre()  %>><br><br>
        <label for="quantity">Quantity:</label><br>
        <input type="number" id="quantity" name="quantity" value=<%= bookmain.getQuantity() %>><br><br>
        <button>Register</button>
</form>
</div>
</body>
</html>