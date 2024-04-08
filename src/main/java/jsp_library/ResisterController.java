package jsp_library;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/details")
public class ResisterController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	userCrud crud=new userCrud();
	User user=new User();
	int id = Integer.parseInt(req.getParameter("id"));
	String name = req.getParameter("name");
	long phone = Long.parseLong(req.getParameter("phone"));
	String address = req.getParameter("address");
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	user.setId(id);
	
	user.setName(name);
	user.setEmail(email);
	user.setPhone(phone);
	user.setPassword(password);
	user.setAddress(address);
	try {
		int result=crud.resister(user);
		if(result!=0) {
			System.err.println("resisteren Successfull");
			req.setAttribute("message","Signup Successful,Plz login");
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, res);
		}
		else {
			System.out.println("error");
			req.setAttribute("message","plz enter valid data to resister");
			RequestDispatcher dispatcher = req.getRequestDispatcher("resister.jsp");
			dispatcher.forward(req, res);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}

}
