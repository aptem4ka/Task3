<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"  %>

<fmt:setLocale value="${sessionScope.local}"/>

<html>
<head>
    <style type="text/css">

        td{
            height: 10px;
            padding: 10px 10px;
        }
        #parent{
            margin: auto;
            text-align: center;
            width: 80%;
        }
        #categories{
            float: left;
            width: 20%;
            text-align: left;

        }
        #main-table{
            float: right;
            width: 80%;
        }
    </style>

    <title>Menu</title>
</head>
<body>
<h3 align="center">Бета-меню</h3>
<div id="parent">
<div id="categories">
    <h3><a href="menu.get?start=0&category=cold_snack">Холодные закуски</a> </h3>
    <h3><a href="menu.get?start=0&category=hot_snack">Горячие закуски</a></h3>

</div>
<c:set var="add" scope="request" value="${5}"/>
<div id="main-table">

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
        <a href="menu.get?start=${requestScope.start-requestScope.add}">Prev</a>
    </c:if>
    <c:if test="${requestScope.isFinish eq y}">
        <a href="menu.get?start=${requestScope.start+requestScope.add}">Next</a>
    </c:if>

</div>
</div>



</body>
</html>
