<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>angular ajax</title>
</head>
<body>
<% 
Cookie fcookie = new Cookie("firstName","Jin");
Cookie lcookie = new Cookie("secondName","Qian");
response.addCookie(fcookie);
response.addCookie(lcookie);
%>
<div>Hello Word</div>
<div><p style="display:none">alflafj</p></div>
</body>
</html> --%>
<%@page import="com.google.gson.*" %>
<%@page import="bean.Person" %>
<%
Person p=new Person();
p.setName("jinqian");
p.setNumber("123456");
Gson gson=new Gson();
response.getWriter().println(gson.toJson(p));
%>