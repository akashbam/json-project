package fetchAndPrintDataOnbrowser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/HSHSServlt2")
public class HSHSServlt2  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String mob=req.getParameter("mob");
		
		PrintWriter printWriter=res.getWriter();
		printWriter.println(id);
		printWriter.println(name);
		printWriter.println(mob);
	}

}
