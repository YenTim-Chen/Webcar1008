<%-- 
    Document   : book
    Created on : 2013/10/8, 下午 04:04:04
    Author     : timchen
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="model.bookbean"%>
<%@page import="model.bookbean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${username}!</h1>
        <a href="addbook.jsp"<h3>addbook</h3></a>
        <a href="carservlet">cart</a>
        <a href="clearall">all clear</a>
        <table border='1'>
            <tr>
                <th>id</th>
                <th>bookname</th>
                <th>publisher</th>
                <th>price</th>
            </tr>
            <c:forEach var="aa" items="${books}">
                <tr>
                    <td>${aa.id}</td>
                    <td>${aa.bookname}</td>
                    <td>${aa.publisher}</td>
                    <td>${aa.price}</td>
                    <td><a href="http://localhost:8084/Webcar1008/Buy?bookid=${aa.id}">buy</td>
                    <td><a href="show?bookid=${aa.id}">資訊</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
