<%@include file="head.jsp"%>
<html>
<link rel="stylesheet" href="css/index.css">
<body class="bg-black">
    <%-- main container --%>
    <div class="container h-100">
        <%-- nav --%>
        <%@include file="nav.jsp"%>
        <%-- content --%>
        <div class="container mt-4 hero-bg-container-image h-75 d-flex justify-content-center">
            <div class="text-dark bg-black bg-opacity-75 w-50 h-50 p-2 m-2 rounded">
                <c:choose>
                    <%-- if no user is logged in --%>
                    <c:when test="${empty user}">
                        <h1 class="text-white my-5">find your next fragrance here</h1>
                    </c:when>
                    <%-- if user is logged in --%>
                    <c:otherwise>
                        <h1 class="text-white my-5">Hello, ${user}. Find your next fragrance here
                    </c:otherwise>
                </c:choose>
                <div class="d-flex justify-content-end me-4 overflow-x-auto">
                    <button type="button" class="btn btn-light btn-lg me-3 px-3">explore</button>
                    <%-- if no user logged in --%>
                    <c:choose>
                        <c:when test="${empty user}">
                            <a href="${pageContext.request.contextPath}/testUser.jsp"><button type="button" class="btn btn-light btn-lg px-3">login</button></a>
                        </c:when>
                    <%-- if user is logged in --%>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/logout"><button type="button" class="btn btn-light btn-lg px-3">logout</button></a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
