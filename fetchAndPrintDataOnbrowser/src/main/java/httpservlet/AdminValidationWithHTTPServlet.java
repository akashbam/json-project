package httpservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminValidation")
public class AdminValidationWithHTTPServlet  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","sky@1234");
			PreparedStatement preparedStatement= connection.prepareStatement("select * from admin where email=? and password=?");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				RequestDispatcher requestDispatcher=req.getRequestDispatcher("AdminWorkSpace.html");
				requestDispatcher.forward(req, resp);
						

						
			}
			else
			{
				PrintWriter printWriter= resp.getWriter();
				printWriter.println("<h1 style=color:red align=center>INVALID CREDENTIAL</h1>");
				
				RequestDispatcher dispatcher= req.getRequestDispatcher("AdminValidationWithHTTPServlet.html");
				dispatcher.include(req, resp);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
