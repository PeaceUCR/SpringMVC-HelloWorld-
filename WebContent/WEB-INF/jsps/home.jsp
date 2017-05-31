<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="java.util.*"
    import ="com.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello Home,
Model and View:<%= request.getAttribute("app_name") %>
Data from oracle:
<% 
List<DotaHero> dlist = (List)request.getAttribute("dlist");
for(int i=0;i<dlist.size();i++){
	out.println("<h3>"+dlist.get(i)+"</h3>");
}
%>
</body>
</html>