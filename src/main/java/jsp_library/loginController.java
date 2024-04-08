package jsp_library;
import java.io.IOException;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class loginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		userCrud crud=new userCrud();
		bookCurd bookCurd=new bookCurd();
		System.out.println("regerg");
		String email= req.getParameter("email");
		String password=req.getParameter("password");
		try {
			String dbPassword=crud.logIn(email);
			System.out.println("hiiii");
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("email",email);
			if(password != null && password.equals(dbPassword)) {
			    System.out.println("loop");
			    System.out.println("success");
			    req.setAttribute("list",bookCurd.displayBook());
			    RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");
			    dispatcher.forward(req, res);
			}
			else {
				 req.setAttribute("message","wrong id or password");
				    RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				    dispatcher.forward(req, res);
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("err");
			e.printStackTrace();
		}
	}
}
