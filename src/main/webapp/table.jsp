<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.local}"/>

<html>
<head>
    <style type="text/css">
        table{
            width: 60%;
        }
        td{
            height: 10px;
            padding: 10px 10px;
        }
    </style>

    <title>Menu</title>
</head>
<body>

<c:set var="add" scope="request" value="${5}"/>
<div align="center">
    <h3>Бета-меню</h3>
    <table border="1" cellspacing="20">
            <tr>
                <fmt:bundle basename="lang" prefix="lang.">
            <th><fmt:message key="image"/> </th>
            <th width="30%"><fmt:message key="name"/></th>
            <th width="40%"><fmt:message key="description"/></th>
            <th width="10%"><fmt:message key="portion"/></th>
            <th width="10%"><fmt:message key="price"/></th>
                </fmt:bundle>
        </tr>
        <c:forEach items="${food}" var="it" >
            <tr>
                <td><img src="${it.image}" width="100%"></td>
                <td><c:out value="${it.name}"/></td>
                <td><c:out value="${it.description}"/>
                    <c:set var="test" value="" scope="page"/>
                        <c:forEach items="${it.options}" var="entry">
                            <br/>
                            <c:out value="${entry.key}"/>
                        </c:forEach>
                     </td>
                <td><c:out value="${it.portion}"/></td>
                <td>
                    <c:forEach items="${it.options}" var="entry">
                        <c:out value="${entry.value}"/><br/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table><br/>
    <c:if test="${requestScope.start>4}">
        <a href="menu.get?start=${requestScope.start-requestScope.add}&parser=${requestScope.parser}&SessionLocale=${sessionScope.local}">Prev</a>
    </c:if>
    <c:if test="${requestScope.isFinish eq y}">
        <a href="menu.get?start=${requestScope.start+requestScope.add}&parser=${requestScope.parser}&SessionLocale=${sessionScope.local}">Next</a>
    </c:if>

</div>
</body>
</html>
