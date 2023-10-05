<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/product/add" modelAttribute ="product">
    Product code: <form:input path="productCode" readonly="true" />
    <form:errors path="productCode"/>
    <br/>
    Product name: <form:input path="productName" readonly="true" />
    <form:errors path="productName"/>
    <br>
    Price: <form:input path="price" readonly="true"/>
    <form:errors path="price"/>
    <br>
    Desciption:<form:input path="description" readonly="true"/>
    <form:errors path="description"/>
    <br>
    Category:
    <form:input path="category.categoryName"  readonly="true"/>
    <br>
</form:form>
</body>
</html>