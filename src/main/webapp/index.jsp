<%@ page import="java.util.*" %>
<jsp:useBean id="person" class="bean.Person" scope="page"/>
<jsp:setProperty name="person" property="name" value="qianjin" />
<html>
<body>
<%! List<String> list=new ArrayList<String>(); %>
<%
for(int i=0;i<10;i++){
    list.add("element:"+i);
}

%>
<%--I just want to add some comments here --%>
<p>The first element in list <%=list.get(0) %></p><br/>
<p>Header Information<p><br/>
<table>
<tr bgcolor="#949494">
<th>Header Name</th><th>Header Value(s)</th>
</tr>
<%
Enumeration headerNames = request.getHeaderNames();
while(headerNames.hasMoreElements()) {
   String paramName = (String)headerNames.nextElement();
   out.print("<tr><td>" + paramName + "</td>\n");
   String paramValue = request.getHeader(paramName);
   out.println("<td> " + paramValue + "</td></tr>\n");
}
%>
</table>
<h2>Bean Information</h2>
<jsp:getProperty name="person" property="name" />

</body>
</html>
