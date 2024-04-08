<%@page import="jsp_library.BookMain"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f2f5;
	margin: 0;
	padding: 0;
}

.container {
	max-width: 800px;
	margin: 50px auto; /* Center the container */
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.header {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.header h2 {
	margin: 0;
	color: #333; /* Heading color */
}

.header-buttons {
	display: flex;
	align-items: center;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th {
	font-weight: bold; /* Make table headings bold */
	background-color: #4CAF50; /* Add an attractive green background */
	color: white; /* Text color for contrast */
	padding: 10px; /* Increase padding for better spacing */
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

h2 {
	text-align: center;
}

.delete-button {
	background-color: #f44336; /* Red background color */
	color: white; /* Text color for contrast */
	border: none; /* Remove border */
	padding: 8px 12px; /* Adjust padding */
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
	border-radius: 4px; /* Add some rounded corners */
}

.delete-button:hover {
	background-color: #cc0000; /* Darker red color on hover */
}

.update-button {
	background-color: #007bff; /* Blue background color */
	color: white; /* Text color for contrast */
	border: none; /* Remove border */
	padding: 8px 12px; /* Adjust padding */
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
	border-radius: 4px; /* Add some rounded corners */
}

#update {
	background-color: #007bff; /* Blue background color */
	color: white; /* Text color for contrast */
	border: none; /* Remove border */
	padding: 8px 12px; /* Adjust padding */
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
	border-radius: 4px;
	margin-right: 10px;
}

#update:hover {
	background-color: #0056b3;
}

.update-button:hover {
	background-color: #0056b3; /* Darker blue color on hover */
}

@media only screen and (max-width: 600px) {
	.header {
		flex-direction: column;
		align-items: flex-start;
	}
	.header-buttons {
		margin-top: 10px;
	}
	a button {
		display: block;
		width: 100%;
		margin-bottom: 10px;
	}
}

h5 {
	margin-top: 80px;
	margin-left: -600px;
	margin-bottom: 1px
}
</style>
</head>
<body>
	<div class="container">
		<div class="header">
			<h2>List of all books</h2>
			<%
			String message = (String) request.getAttribute("id");
			%>
			<%
			if (message != null) {
			%>
		<h5>Currently session used by 	<%=message%></h5>
			<%
			}
			%>




			<div class="header-buttons">
				<a href="addBook.jsp"><button id="update">Add Book</button></a> <a
					id="logout" href="home.jsp"><button class="delete-button">Logout</button></a>
			</div>
		</div>
		<table>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Genre</th>
				<th>Quantity</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<%
			List<BookMain> list = (List) request.getAttribute("list");
			for (BookMain bookMain : list) {
			%>
			<tr>
				<td><%=bookMain.getId()%></td>
				<td><%=bookMain.getTitle()%></td>
				<td><%=bookMain.getAuthor()%></td>
				<td><%=bookMain.getGenre()%></td>
				<td><%=bookMain.getQuantity()%></td>
				<td><a href="update?id=<%=bookMain.getId()%>"><button
							class="update-button">UPDATE</button></a></td>
				<td><a href="delete?id=<%=bookMain.getId()%>"><button
							class="delete-button">DELETE</button></a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>
