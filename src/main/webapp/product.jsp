<%@ page import="java.util.List" %>
<%@ page import="dev.yonk.backend.models.Product" %><%--
  Created by IntelliJ IDEA.
  User: beeli
  Date: 30/09/2023
  Time: 9:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <% List<Product> productList = (List<Product>) request.getAttribute("productList") %>
    <div class="container">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>DOB</th>
                <th></th>
                <th>Email</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Status</th>
                <th><a href="">Insert</a></th>
            </tr>
            </thead>
            <tr>
                <%for (Product product: productList) {%>
                <td><% product.getId() %></td>
                <td><% product.getName() %></td>
                <td><% product.getDescription() %></td>
                <td><% product.getUnit() %></td>
                <td><% product.getManufacturer() %></td>
                <td><a href="">Update</a></td>
                <td><a href="">Delete</a></td>
                <%}%>
            </tr>
        </table>
    </div>
</body>
</html>
