<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>
</head>
<body>
<%@ page isELIgnored="false" %> <!-- expression language, default will ignore User{data}, add will display -->
<h1>Hello from hello.jsp!</h1>
<h2>User: ${data.name} ${data.age}</h2>
<h2>Count: ${count}</h2>
</body>
</html>