<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mx" %>
<%@ taglib uri="/WEB-INF/tld/hello.tld" prefix="ex" %>
<%@ taglib uri="/WEB-INF/tld/hellobody.tld" prefix="exb" %>
<%@ taglib uri="/WEB-INF/tld/helloattribute.tld" prefix="exa" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Use Tags</title>
</head>
<body>
<h1> Use Tag File to Define Tag</h1>
<mx:JspTag id="Weblet1" webletID="W1001"/>
<h1> Use Tag Class to Define Tag</h1>
<ex:Hello/>
<exb:HelloBody>
<br/>This is message body
</exb:HelloBody>
<exa:HelloAttribute>
<br/>Without Attribute, it will show the message body
</exa:HelloAttribute>
<exa:HelloAttribute msg="This is a custom tag with a message"></exa:HelloAttribute>
</body>
</html>