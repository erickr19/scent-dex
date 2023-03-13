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
                <li class="nav-item">
                    <a class="nav-link text-white" href="#">login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%-- horizontal break --%>
<hr class="text-white">