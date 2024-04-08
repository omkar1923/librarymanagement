package jsp_library;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List; // Import List interface

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/book")
public class BookController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String genre = req.getParameter("genre");
		int quantity = Integer.parseInt(req.getParameter("quantity"));

		BookMain bookMain = new BookMain();
		bookMain.setId(id);
		bookMain.setAuthor(author);
		bookMain.setGenre(genre);
		bookMain.setQuantity(quantity);
		bookMain.setTitle(title);

		bookCurd curd = new bookCurd();
		try {
			int result = curd.addBook(bookMain);
			HttpSession httpSession=req.getSession();
			   String value=(String) httpSession.getAttribute("email");
				if (result != 0) {
					if(value!=null) {
						req.setAttribute("id",value);
				System.out.println("data entered");

				req.setAttribute("list", curd.displayBook());

				RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
				dispatcher.forward(req, res);}
			} else {
				System.out.println("error in book");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
