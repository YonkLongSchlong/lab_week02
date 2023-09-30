<%@ page import="java.util.List" %>
<%@ page import="dev.yonk.backend.models.Employee" %><%--
  Created by IntelliJ IDEA.
  User: beeli
  Date: 30/09/2023
  Time: 6:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
    <%
            List<Employee> empList = (List<Employee>) request.getAttribute("empList");
    %>
    <div>
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
                <%for (Employee emp: empList) {%>
                    <td><%=emp.getId()%></td>
                    <td><%= emp.getName() %></td>
                    <td><%=emp.getDob() %></td>
                    <td><%=emp.getEmail() %></td>
                    <td><%=emp.getPhone() %></td>
                    <td><%=emp.getAddress() %></td>
                    <td><%=emp.getStatus() %></td>
                    <td><a href="">Update</a></td>
                    <td><a href="control?action=delete_emp?empId=<%=emp.getId()%>">Delete</a></td>
                <%}%>
            </tr>
        </table>
    </div>
</body>
</html>
