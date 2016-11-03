
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public homeServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		config.getServletContext().setAttribute("name", "ajay");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String create  =  request.getParameter("uname");
		String edit  =  request.getParameter("uname");
		String delete  =  request.getParameter("uname");
		
		
		
		//String great = getServletConfig().getInitParameter("great");
		writer.print("<html> <head>");
		
		writer.print("<title>" + "WELCOME TO HOME PAGE...." + "</title>");
		writer.print("</head>");
		writer.println("<body>");
		Enumeration< String > enm= request.getParameterNames();
		while (enm.hasMoreElements()) {
			String Pname = enm.nextElement().toString();
			String [] Pvalues = request.getParameterValues(Pname);
			//writer.println("<b>" + Pname + "</b>");
			
			
			
			for (int i = 0 ; i<Pvalues.length; i ++ ) {
				//writer.println(Pvalues[i]);
				String value = Pvalues[i];
				if (value.equals("option1")){
					RequestDispatcher rd = request.getRequestDispatcher("/NewBlog.html");
					rd.forward(request, response);
					//writer.println("NEW");
				} else if (value.equals("option2")) {
					RequestDispatcher rd = request.getRequestDispatcher("/EditBlob.html");
					rd.forward(request, response);
					//writer.println("EDIT");
				} else if (value.equals("option3")) {
					RequestDispatcher rd = request.getRequestDispatcher("/DeleteBlog.html");
					rd.forward(request, response);
					//writer.println("DELETE");
				}
			}
			writer.println("<br>");
		}
		
		writer.println("</body>");
		writer.println("</html>");
		
	}
		

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
