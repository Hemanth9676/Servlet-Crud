<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
           <form action="update">
           			ID : <input type="text" value="${user.getId() }" name="id" readonly="readonly">
           		Name : <input type="text" value="${user.getName() }" name="user_name">
          		User Name : <input type="text" value="${user.getUsername() }" name="user_username">
          		Email : <input type="text" value="${user.getEmail() }" name="user_email">
         		phone : <input type="tel" value="${user.getPhone() }" name="user_phone">
          		Password : <input type="password" value="${user.getPassword() }" name="user_password">
             <button type="submit"> Update </button>
           
               
           </form>
</body>
</html>