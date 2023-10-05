<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/product/add" modelAttribute ="product">
    Product code: <form:input path="productCode" />
    <form:errors path="productCode"/>
    <br/>
    Product name: <form:input path="productName" />
    <form:errors path="productName"/>
    <br>
    Price: <form:input path="price"/>
    <form:errors path="price"/>
    <br>
    Desciption:<form:input path="description"/>
    <form:errors path="description"/>
    <br>
    Category:
    <form:select path="category">
        <form:options items="${categories}" itemLabel="categoryName" />
    </form:select>
    <br>
    <form:button type ="submit">Thêm mới</form:button>
</form:form>
</body>
</html>