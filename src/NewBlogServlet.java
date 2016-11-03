
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewBlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewBlogServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
writer.print("<html> <head>");
		
		writer.print("<title>" + "WELCOME TO HOME PAGE...." + "</title>");
		writer.print("</head>");
		writer.println("<body>");
		
		Enumeration< String > enm= request.getParameterNames();
		while (enm.hasMoreElements()) {
			String Pname = enm.nextElement().toString();
			String [] Pvalues = request.getParameterValues(Pname);
			writer.println("<b>" + Pname + "</b>");
			
			for (int i = 0 ; i<Pvalues.length; i ++ ) {
				writer.println(Pvalues[i]);
			}
			
		 
			writer.println("<br>");
		}
		try{
			
			 File file = new File("c:\\Blogdata.txt");

		      if (file.createNewFile() || file.exists()){
		    	  writer.println("Blog is saved");
		    	  PrintWriter fileWriter = new PrintWriter(
							new FileOutputStream("c:\\Blogdata.txt",
									true));
		    	  fileWriter.println("AutherName:"+ "" +request.getParameter("AutherName:")); 
		    	  fileWriter.println("BlogName:"+ "" + request.getParameter("BlogName:"));
		    	  fileWriter.println("Comment:"+ "" + request.getParameter("Blog_Content:"));
		    	  fileWriter.close();
		      }else{
		    	  writer.println("Blog is not saved");
		      }
	       
		} catch (FileNotFoundException fnfe) {

		}
		
		writer.println("</body>");
		writer.println("</html>");
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
