<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"  %>



<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <c:set var="add" scope="request" value="${5}"/>
    <fmt:setLocale value="${sessionScope.local}"/>

    <title>Menu</title>
</head>
<body>
<fmt:bundle basename="lang" prefix="lang.">
    <div class="row content">

        <div class="col-md-2">

            <table class="table">
                <thead class="thead-light">
                <tr>
                    <th><fmt:message key="categories"/> </th>
                </tr>
                </thead>
                <tbody>

                <tr>
                    <td><a href="menu.get?start=0&category=cold_snack"><fmt:message key="cold_snack"/></a></td>
                </tr>
                <tr>
                    <td><a href="menu.get?start=0&category=hot_snack"><fmt:message key="hot_snack"/></a></td>
                </tr>

            </table>

        </div>
        <div class="col-md-9">
            <table class="table table-striped">
                <thead class="thead-light">

                <tr>
                    <th class="w-5"><fmt:message key="image"/> </th>
                    <th class="w-25"><fmt:message key="name"/> </th>
                    <th class="w-50"><fmt:message key="description"/> </th>
                    <th class="w-10"><fmt:message key="portion"/> </th>
                    <th class="w-10"><fmt:message key="price"/> </th>
                </tr>

                </thead>
                <tbody>
                <c:forEach items="${food}" var="it" >
                    <tr>
                        <td class="w-10" ><img src="${it.image}" class="img-fluid img-thumbnail" ></td>
                        <td class="w-20"><c:out value="${it.name}"/></td>
                        <td class="w-50"><c:out value="${it.description}"/>
                            <c:forEach items="${it.options}" var="entry">
                                <br/>
                                <c:out value="${entry.key}"/>
                            </c:forEach>
                        </td>
                        <td class="w-10"><c:out value="${it.portion}"/></td>
                        <td class="w-10">
                            <c:forEach items="${it.options}" var="entry">
                                <c:out value="${entry.value}"/><br/>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

        <ul class="pagination justify-content-center">
        <c:if test="${requestScope.start>4}">
            <li class="page-item"><a class="page-link" href="menu.get?start=${requestScope.start-requestScope.add}">Previous</a></li>
        </c:if>
        <c:if test="${requestScope.isFinish eq y}">
            <li class="page-item"><a class="page-link" href="menu.get?start=${requestScope.start+requestScope.add}">Next</a></li>
        </c:if>
        </ul>

</fmt:bundle>
</body>
</html>
