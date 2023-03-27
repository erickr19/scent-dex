<%@include file="head.jsp"%>
<html>
<link rel="stylesheet" href="css/index.css">
<body class="bg-black">
    <%-- main container --%>
    <div class="container hero-bg-container-image pt-2 pt-lg-3 h-100">
        <%-- nav --%>
        <%@include file="new-nav.jsp"%>
        <%-- content --%>
        <div class="container mt-4 h-75 d-flex justify-content-center">
            <div class="text-dark bg-white h-50 p-2 m-2 rounded">
                <c:choose>
                    <%-- if no user is logged in --%>
                    <c:when test="${empty user}">
                        <h1 class="text-dark my-5 text-center">find your next fragrance here</h1>
                    </c:when>
                    <%-- if user is logged in --%>
                    <c:otherwise>
                        <h1 class="text-dark my-5 text-center">Hello, ${user}. Find your next fragrance here
                    </c:otherwise>
                </c:choose>
                <div class="d-flex justify-content-center mt-5 justify-content-lg-end">
                    <button type="button" class="btn btn-dark btn-lg me-3 px-3">explore</button>
                    <%-- if no user logged in --%>
                    <c:choose>
                        <c:when test="${empty user}">
                            <a href="${pageContext.request.contextPath}/testUser.jsp"><button type="button" class="btn btn-dark btn-lg px-3">login</button></a>
                        </c:when>
                    <%-- if user is logged in --%>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/logout"><button type="button" class="btn btn-dark btn-lg px-3">logout</button></a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
