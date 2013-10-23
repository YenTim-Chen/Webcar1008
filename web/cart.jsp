<%-- 
    Document   : cart
    Created on : 2013/10/9, 上午 09:48:22
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
                  <c:forEach var="run" items="${buybook}">
                        <tr>
                              <td>${run.key.id}</td>
                              <td>${run.key.bookname}</td>
                              <td>${run.key.publisher}</td>
                              <td>${run.key.price}</td>
                              <td>${run.value}</td>
                             <td><a href="deletebook?bookid=${run.key.id}">delete list</a></td>
                        </tr>
                  </c:forEach>
            </table>
            <h3><a href="book.jsp">回首頁,繼續購物</a></h3>
            <h3><a href="car.jsp">結帳<h3>
                              </body>
                              </html>
