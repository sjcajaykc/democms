<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.Scanner"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
 <%
            String jspPath = "c:\\";
            String fileName = "Blogdata.txt";
            String txtFilePath = "c:\\Blogdata.txt";
            BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
            //BufferedReader br = new InputStreamReader(new FileInputStream(txtFilePath));
            StringBuilder sb = new StringBuilder();
            String line;
			String AutherName = request.getParameter("AutherName:");
			
			out.println(request.getParameter("AutherName:")); 
			String buffer = "";
		    try {

		        Scanner scan = new Scanner (new File (txtFilePath));
		        while (scan.hasNext())
		        {
		            buffer = scan.nextLine();
		            if (buffer.contains(AutherName)){
		            	 buffer = "";
		            }

		           
		            else
		            {
		            	out.println("The blog is not there...."); 


		            }
		        }
		        scan.close();

		    } catch (Exception e) {
		        //System.out.println("An error occured while searching in file!");
		    }
			
          
            out.println("in deletepage.jsp"); 
        %>
	
</body>
</body>
</html>