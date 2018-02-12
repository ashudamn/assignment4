<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*,java.sql.*,com.mysql.jdbc.Driver,com.mysql.jdbc.Connection,com.mysql.jdbc.Statement,com.appperfect.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>We have got jsp here</title>
</head>
<body>
Working with server: <%= application.getServerInfo() %><br>
Servlet Specification: <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %> <br>
JSP version: <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %><br>
<%

String username="";
String password="";
String url="";
String driver="";
String query="";
String nextPage="";
if(request.getParameter("username")!=null){
	username=request.getParameter("username").trim();
}
if(request.getParameter("password")!=null){
	password=request.getParameter("password");
}
if(request.getParameter("url")!=null){
	url=request.getParameter("url").trim();
}
if(request.getParameter("driver")!=null){
	driver=request.getParameter("driver").trim();
}
if(request.getParameter("query")!=null){
	query=request.getParameter("query");
}
ResultSet rs;
		if(!AccessDB.connect2DB(driver,url,username,password,query))
		{
			nextPage="error.jsp";
		}
	
	 	rs=AccessDB.getRs();

		%><table><%
		if(rs!=null){
		try{
		while (rs.next()) {
			ResultSetMetaData rsmd = rs.getMetaData();
			int colsNumber = rsmd.getColumnCount();
			%><tr><%
			for (int i = 1; i <= colsNumber; i++){
					System.out.print(rs.getString(i)+" ");
					%><td><%= rs.getString(i)%></td><%
			}
			%></tr><%
			System.out.println();
		}
		}
		catch(Exception e)
		{
			ErrorFinder.findError(e);
			nextPage="error.jsp";
		}
		finally{
			AccessDB.closeAllConnections();
		}
		}
		%></table><%
if(!nextPage.isEmpty()){
	response.sendRedirect(nextPage);
}
	
%>

</body>
</html>