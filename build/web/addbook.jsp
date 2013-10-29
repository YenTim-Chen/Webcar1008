<%-- 
    Document   : addbook
    Created on : 2013/10/8, 下午 04:08:19
    Author     : timchen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="addbook" method="get">
        Bookname:<input type="text"name='bookname'></input></br>
        Publisher:<input type="text"name='publisher'></input></br>
        Price:<input type="text"name='price'></input></br>
        <input type="submit"value='send'>
        </form>
    </body>
</html>
