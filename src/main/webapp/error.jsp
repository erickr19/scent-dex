<%--
  error page
  author: ereyes3
--%>
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- c set error --%>
<c:set var="error" value='${requestScope["error"]}' />
<html lang="en">
<body class="bg-black">
<%-- main container --%>
<div class="container">
    <%-- nav --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container mt-4 text-white">
        <%-- Header --%>
        <h1>This doesn't smell right...</h1>
        <hr class="w-25 mb-3">
        <%-- Subheader --%>
        <h2 class="mt-5">Error</h2>
        <p class="mt-4">
            <c:out value="${error}" />
        </p>
    </div>
</div>
</body>
</html>
