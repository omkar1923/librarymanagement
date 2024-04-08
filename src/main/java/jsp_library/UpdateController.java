package jsp_library;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	
	
	bookCurd bookCurd=new bookCurd();
	try {
		BookMain bookMain=bookCurd.updateDetaile(id);
		req.setAttribute("update", bookMain);
		RequestDispatcher dispatcher=req.getRequestDispatcher("Edit.jsp");
		dispatcher.forward(req, res);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	String title=req.getParameter("title");
	String author=req.getParameter("author");
	String genre=req.getParameter("genre");
	int quantity=Integer.parseInt(req.getParameter("quantity"));
	BookMain bookMain=new BookMain();
	bookMain.setId(id);
	bookMain.setAuthor(author);
	bookMain.setGenre(genre);
	bookMain.setQuantity(quantity);
	bookMain.setTitle(title);
	bookCurd curd=new bookCurd();
try {
	
	int result=curd.displayUpdate(bookMain);
	HttpSession httpSession=req.getSession();
	   String value=(String) httpSession.getAttribute("email");
		if (result != 0) {
			if(value!=null) {
				req.setAttribute("id",value);
			
		System.out.println("update Success");
		req.setAttribute("list",curd.displayBook());
		RequestDispatcher dispatcher=req.getRequestDispatcher("main.jsp");
		dispatcher.forward(req, res);
		}}
	
} catch (ClassNotFoundException | SQLException e) {
	e.printStackTrace();
}
	// TODO Auto-generated catch block
	
}
	}


