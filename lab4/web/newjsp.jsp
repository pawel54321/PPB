<%-- 
    Document   : newjsp
    Created on : 2019-03-19, 13:42:44
    Author     : pawlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="nazwa" scope="session" class="newpackage.NewClass" />
        
        <jsp:setProperty name="nazwa" property="k" />
        <jsp:setProperty name="nazwa" property="n" />
        <jsp:setProperty name="nazwa" property="b" />
        
        <%=nazwa.obliczRaty()%>
        
        
    </body>
</html>
