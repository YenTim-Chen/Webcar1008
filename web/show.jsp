<%-- 
    Document   : show
    Created on : 2013/10/15, 上午 09:19:01
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
            <table border="1">
                  <tr>
                        <th>id</th>
                        <th>書名</th>
                        <th>書商</th>
                        <th>價錢</th>
                  </tr>
                  
                  <c:forEach var="ss" items="${onebook}">
                        <tr>
                              <td>${ss.id}</td>
                              <td>${ss.bookname}</td>
                              <td>${ss.publisher}</td>
                              <td>${ss.price}</td>
                        </tr>
                  </c:forEach>
            </table> 
            <h3><a href="http://localhost:8084/Webcar1008/ShowBooks">回首頁</a></h3>
</body>
</html>
