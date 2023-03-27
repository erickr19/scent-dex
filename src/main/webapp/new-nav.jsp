<%--
  new nav jsp
  new nav to be included into project
  author: ereyes3
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary rounded-3">
  <div class="container-fluid align-items-start">
    <%-- Branding --%>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/homepage">Scent Dex</a>
    <%-- Toggler --%>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse flex-grow-0" id="navbarSupportedContent">
      <%-- Navbar --%>
      <ul class="navbar-nav d-flex me-auto mb-2 mb-lg-0">
        <%-- Search Bar --%>
        <form class="d-flex align-items-center" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
        <%-- Explore --%>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/explore">explore</a>
        </li>
        <%-- Learn --%>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/learn">learn</a>
        </li>
        <%-- dropdown menu (no use case at the moment) --%>
<%--        <li class="nav-item dropdown">--%>
<%--          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--            Dropdown--%>
<%--          </a>--%>
<%--          <ul class="dropdown-menu">--%>
<%--            <li><a class="dropdown-item" href="#">Action</a></li>--%>
<%--            <li><a class="dropdown-item" href="#">Another action</a></li>--%>
<%--            <li><hr class="dropdown-divider"></li>--%>
<%--            <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
<%--          </ul>--%>
<%--        </li>--%>

        <%-- if user is not logged in --%>
        <c:choose>
          <c:when test="${empty user}">
        <%-- Login --%>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/testUser.jsp">login</a>
            </li>
          </c:when>
        <%-- if user is logged in --%>
          <c:otherwise>
        <%-- Profile --%>
            <li>
              <a class="nav-link" href="#">profile</a>
            </li>
        <%-- Logout --%>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/logout">logout</a>
            </li>
          </c:otherwise>
        </c:choose>
      </ul>
    </div>
  </div>
</nav>
