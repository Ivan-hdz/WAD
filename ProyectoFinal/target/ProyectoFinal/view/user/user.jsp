<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spring-4 + Struts-3 + Hibernate Integration Demo</title>
    <style>
        table.list
        {
            border-collapse:collapse;
            width: 40%;
        }
        table.list, table.list td, table.list th
        {
            border:1px solid gray;
            padding: 5px;
        }
    </style>
</head>
<body>

<h2>Spring-4 + Struts-3 + Hibernate Integration Demo</h2>

<s:form method="post" action="create">
    <table>
        <tr>
            <td><s:textfield key="label.name" name="user.name"/></td>
        </tr>
        <tr>
            <td><s:textfield key="label.email" name="user.email"/></td>
        </tr>
        <tr>
            <td><s:textfield key="label.password" name="user.password"/></td>
        </tr>
        <tr>
            <td>
                <s:submit key="label.submit" />
            </td>
        </tr>
    </table>
</s:form>


<h3>Users</h3>
<c:if  test="${!empty users}">
    <table class="list">
        <tr>
            <th align="left">Nombre</th>
            <th align="left">Email</th>
            <th align="left">Contraseña</th>
            <th align="left">Actions</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.name} </td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td><a href="delete/${user.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>