package jsp_library;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/reset")
public class ResetController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String newPassword=req.getParameter("newpassword");
		userCrud crud= new userCrud();
		try {
			int result=crud.updatePassword( id,newPassword);
			if(result!=0) {
				System.out.println("updated Successfull");
				req.setAttribute("message","Password updated Successfully");
				 RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				    dispatcher.forward(req, res);
				
				
			}
			else {
				System.out.println("error occured while updating");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
