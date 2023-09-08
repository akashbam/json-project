package fetchAndPrintDataOnbrowser;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/HSHSFile1Req")
public class HSHSServlet1 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		 RequestDispatcher requestDispatcher= req.getRequestDispatcher("HTMLFile2.html");
		 requestDispatcher.forward(req, res);
		
	}

}
