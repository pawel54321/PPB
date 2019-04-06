<%-- 
    Document   : newjsp
    Created on : 2019-03-19, 13:42:44
    Author     : pawlo
--%>

<%!
    String losujKolor()
    {
        String color = "#";
        char[] c = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        for(int i=0;i<6;i++) {
            color += c[(int)Math.floor(Math.random()*16)];
        }
        
        return color;
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="<%=losujKolor() %>">
        <jsp:useBean id="nazwa" scope="session" class="newpackage.NewClass" />
        
        <jsp:setProperty name="nazwa" property="k" />
        <jsp:setProperty name="nazwa" property="n" />
        <jsp:setProperty name="nazwa" property="b" />
        
        <%=nazwa.obliczRaty()%>
        
        
    </body>
</html>
