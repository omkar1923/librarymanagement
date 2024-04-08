package jsp_library;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delete")
public class deleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		bookCurd curd=new bookCurd();
		try {
			int result=curd.deleteData( id);
			if(result!=0) {
				HttpSession httpSession=req.getSession();
				   String value=(String) httpSession.getAttribute("email");
					if (result != 0) {
						if(value!=null) {
							req.setAttribute("id",value);
				System.out.println("data deleted successfully");
				req.setAttribute("list",curd.displayBook());
				RequestDispatcher dispatcher=req.getRequestDispatcher("main.jsp");
				dispatcher.forward(req, res);
						}
			}
					}}
					catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 
	

}}
