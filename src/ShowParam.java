
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowParam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowParam() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<html>");
		printWriter.println("<head>");
		printWriter.println("<title> Request HTTP ParameterSent.... </title>");
		printWriter.println("</head><body>");
		printWriter.println("<p> Parameter sent with request:</p>");
		Enumeration< String > enm= request.getParameterNames();
		while (enm.hasMoreElements()) {
			String Pname = enm.nextElement().toString();
			String [] Pvalues = request.getParameterValues(Pname);
			printWriter.println("<b>" + Pname + "</b>");
			
			for (int i = 0 ; i<Pvalues.length; i ++ ) {
				printWriter.println(Pvalues[i]);
			}
			printWriter.println("<br>");
		}
		printWriter.println("</body>");
		printWriter.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
