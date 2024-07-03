<%@page import="com.Admin.MatchDao"%>
<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style >
body{
	background-image:url("1.webp");
     background-size:1400px 800px;
     background-repeat:no-repeat;
     background-position:center;
     height:700px;
  

}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><marquee><label class='ise'>All Available Match Details are-----</marquee></h2><br><br><br><br>
<center><table border ='2'>
<tr><th> Title</th><th>Place</th><th>Match Date</th>
<%
ResultSet rs = new MatchDao().RetrieveMatch();
while(rs.next()){
%>
<tr><th><%= rs.getString(1) %></th><th><%=rs.getString(2) %></th><th><%=rs.getString(3) %></th></tr>
<%} %>
</table>
</center>

</body>
</html>