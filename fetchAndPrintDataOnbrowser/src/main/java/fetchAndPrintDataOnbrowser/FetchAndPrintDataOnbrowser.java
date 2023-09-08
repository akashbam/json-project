package fetchAndPrintDataOnbrowser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/req1")
public class FetchAndPrintDataOnbrowser extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		
		PrintWriter printWriter= res.getWriter();
		printWriter.print("hello "+ name);
		printWriter.println("<table border=\"2px\" cellspacing=\"0px\" cellpadding=\"10px\"><tr><td>ID</td><td>NAME</td><td>AGE</td></tr><tr><td>1</td><td>AKASH</td><td>22</td><tr><td>2</td><td>SHAILESH</td><td>23</td></table>");
		//printWriter.println("hhi");
		res.setContentType("text/html") ;
	}

}
