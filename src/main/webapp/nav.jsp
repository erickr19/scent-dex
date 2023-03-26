<%-- nav bar --%>
<nav class="navbar navbar-light">
    <div class="container justify-content-between flex-nowrap">
        <a class="navbar-brand text-white fs-2" href="${pageContext.request.contextPath}/homepage">Scent Dex</a>
        <div class="flex-fill px-5">
            <input type="text" class="form-control" placeholder="Search...">
        </div>
        <div>
            <ul class="nav fs-5 text-white flex-nowrap">
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/explore">explore</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="${pageContext.request.contextPath}/learn">learn</a>
                </li>
                <%-- if no user logged in, displays login --%>
                <c:choose>
                    <c:when test="${empty user}">
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/testUser.jsp">login</a>
                        </li>
                    </c:when>
                <%-- else display logout, and profile links --%>
                    <c:otherwise>
                        <li>
                            <a class="nav-link text-white" href="#">profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white" href="${pageContext.request.contextPath}/logout">logout</a>
                        </li>
                    </c:otherwise>
                </c:choose>


            </ul>
        </div>
    </div>
</nav>
<%-- horizontal break --%>
<hr class="text-white">