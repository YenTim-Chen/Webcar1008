<%-- 
    Document   : car
    Created on : 2013/10/11, 下午 03:06:16
    Author     : timchen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
      </head>
      <body>
            <h1>Hello World!</h1>
            
        <h1><font color="red">Total:${sum}元</font></h1>
        <table border="1">
        <tr>
                <th>id</th>
                <th>bookname</th>
                <th>publisher</th>
                <th>price</th>
                <th>count</th>
        </tr>
        
        <c:forEach var="aa" items="${carbuy}">
        <tr>
            <td>${aa.key.id}</td>
            <td>${aa.key.bookname}</td>
            <td>${aa.key.publisher}</td>
            <td>${aa.key.price}</td>
            <td>${aa.value}</td>
         </tr>
        </c:forEach>
        </table>
        <h3><a href="clearall">回首頁</a></h3>
       </body>
</html>
