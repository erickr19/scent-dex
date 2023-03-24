<%--
    Redirected from a successful user sign-up.
    Only used to test AWS Cognito authentication for now.
    Will add more features in the coming days.
    author: ereyes3
--%>
<%@include file="head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<body class="bg-black">
<%-- main container --%>
<div class="container">
    <%-- nav --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container mt-4 text-white">
        <%-- test if userName is set --%>
        <c:choose>
            <c:when test="${empty userName}">
                <p>Not currently signed in...</p>
                <a href = "logIn">Log in</a>
            </c:when>
            <c:otherwise>
                <h3>Hello ${userName}!</h3>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
