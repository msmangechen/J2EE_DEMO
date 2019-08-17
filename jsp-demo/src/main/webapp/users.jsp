<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- 引入JSTL library -->
<%@ page isELIgnored="false" %>
<%@ page import="com.mercury.jsp_demo.bean.User" %>
<jsp:useBean id="users" scope="request" class="java.util.ArrayList"></jsp:useBean>

<h2>Users</h2>
<%-- <ul>
	<!-- 写Java代码，out不需要引用就可以用（是Implicit object） -->
	<% 
		for (Object o : users) {
			User user = (User) o;
			out.print("<li>" + user.getName() + " - " + user.getAge() + "</li>");
		}
	%>
</ul> --%>

<ul>
	<c:forEach var="user" items="${users}">
		<li>${user.getName()} - ${user.getAge()}</li>
	</c:forEach>
</ul>

</body>
</html>