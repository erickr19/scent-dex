<%--
    Explore JSP.
    This JSP will list all the fragrances in the database.
    author: ereyes3
--%>
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- c set retrievedFragrances --%>
<c:set var="allFragrances" value='${requestScope["retrievedFragrances"]}' />
<html>
<body class="bg-black">
    <%-- main container --%>
    <div class="container">
        <%-- nav --%>
        <%@include file="nav.jsp"%>
        <%-- content --%>
        <div class="container mt-4 text-white">
            <%-- Header --%>
            <h1>All results</h1>
            <hr class="w-25 mb-3">
            <%-- table --%>
            <table class="table text-white">
                <thead>
                    <tr>
                        <th scope="col">ID#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Designer</th>
                        <th scope="col">Description</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${allFragrances}" var="fragrance">
                        <tr>
                            <td>${fragrance.fragranceId}</td>
                            <td>${fragrance.name}</td>
                            <td>${fragrance.designer}</td>
                            <td>${fragrance.description}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
