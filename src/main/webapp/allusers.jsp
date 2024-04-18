<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.tyss.instagram.entity.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Users Page</title>
</head>
<body style="background:cyan;">
<table border="1" cellpadding="15" cellspacing="1" style='margin:auto; background:white; color:purple;'>
      <tr> <th>  Id </th>
       <th>  Name </th>
       <th>  userName </th>
       <th>  Email </th>
       <th>  Password </th>
      
      </tr>
	<%
	List<Users> users = (List<Users>) request.getAttribute("users");

	for (Users u : users) {
	%>

	<h1>
	<tr>
		<td><%=u.getId() %></td></h1>
	    <h1><td> <%= u.getName()%></td></h1>
        <h1><td> <%= u.getUsername() %> </td></h1>
        <h1><td> <%= u.getEmail() %> </td></h1>
        <h1> <td><%= u.getPassword() %> </td></h1>
    </tr>
	<%
	}
	
	%>
</table>
<br>
<br>
	 <a style="margin:50%" href="index.jsp"> <button type="button">Back</button> </a>

</body>
</html>