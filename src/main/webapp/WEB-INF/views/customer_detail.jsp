<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CUSTOMER DETAIL</title>
</head>
<body>

    <h1>CUSTOMER DETAILS: </h1>
    <ul>
        <li>NAME: ${customer.name}</li>
        <li>ADDRESS: ${customer.address}</li>
        <li>PHONE: ${customer.phone}</li>
        <li>EMAIL: ${customer.email}</li>
    </ul>
    <p><a href="/app/addCustomer">ADD CUSTOMER</a></p>
</body>
</html>
