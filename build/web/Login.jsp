<%-- 
    Document   : Login
    Created on : 2013/10/11, 下午 04:25:47
    Author     : timchen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE" />
    <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE" />
    <META HTTP-EQUIV="EXPIRES" CONTENT="-1" />
      </head>
      <body>
            <h1>Hello World!</h1>
            <form action="register.jsp">
                  <input type="submit" value="New Account"/>
            </form>
            <form action="loginServlet" method="get">
                  
            username:<input type="text" name="loginName" value="Kitty"></input></br>
            password:<input type="password" name="password" value="123456"></input></br>
            <input type="checkbox"name='rememberme'value="yes">Remember me</input>
            <input type="submit" value="send"/>
            
            </form>
      </body>
</html>
