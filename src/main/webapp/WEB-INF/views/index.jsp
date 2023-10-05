<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <button><a href="/product/view-add">Add</a></button>
    <thead>
        <tr>
            <th>#</th>
            <th>Product Code</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Category code</th>
            <th>Category name</th>
            <th colspan="3">Action</th>
        </tr>
    </thead>

    <tbody>
    <c:forEach items="${list}" var="gv" varStatus="index">
        <tr>
            <td>${index.count}</td>
            <td>${gv.productCode}</td>
            <td>${gv.productName}</td>
            <td>${gv.price}</td>
            <td>${gv.description}</td>
            <td>${gv.category.categoryCode}</td>
            <td>${gv.category.categoryName}</td>
            <td>
                <button><a href="${pageContext.request.contextPath}/product/delete?id=${gv.id}">Remove</a></button>
                <button><a href="${pageContext.request.contextPath}/product/detail?id=${gv.id}">Detail</a></button>
                <button><a href="${pageContext.request.contextPath}/product/view-update?id=${gv.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div>
    <p>Page : ${currentPage} / ${totalPages}</p>
    <button><a href="${pageContext.request.contextPath}/product/hien-thi-tat-ca?page=${currentPage <= 1 ? 1 : (currentPage - 1) }">Previous</a></button>
    <button><a href="${pageContext.request.contextPath}/product/hien-thi-tat-ca?page=${currentPage >= totalPages ? currentPage : (currentPage + 1) }">Next</a></button>
</div>
</body>
</html>
