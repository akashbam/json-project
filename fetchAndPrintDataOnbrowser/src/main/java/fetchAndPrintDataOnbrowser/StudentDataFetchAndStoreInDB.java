package fetchAndPrintDataOnbrowser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/savestudent")
public class StudentDataFetchAndStoreInDB  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String mob=req.getParameter("mob");
		String yop=req.getParameter("yop");
		
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","sky@1234");
			PreparedStatement preparedStatement= connection.prepareStatement("insert into student(id,name,age,mobilenumber,yop) values(?,?,?,?,?)");
			preparedStatement.setInt(1, Integer.parseInt(id));
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, Integer.parseInt(age));
			preparedStatement.setLong(4, Long.parseLong(mob));
			preparedStatement.setInt(5, Integer.parseInt(yop));
			
			if(preparedStatement.executeUpdate()!=0)
			{
				PrintWriter printWriter= res.getWriter();
				printWriter.println("<h1 style=color:green>DATA SAVED SUCCESSFULLY !</h1>");
			}
			else
			{
				PrintWriter printWriter= res.getWriter();
				printWriter.println("<h1 style=color:red> FAILED TO SAVED DATA  !</h1>");
			}
				

			
			
			
		}  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   catch (SQLException e) {
			
			PrintWriter printWriter= res.getWriter();
			printWriter.println("<h1 style=color:red> EXEPTION ACCURED  !</h1>");
		}
		
		
		
		
	}

}
