<%--
  learn page for scent dex
  author: ereyes3
--%>
<%@include file="head.jsp"%>
<html>
<body class="bg-black">
  <%-- main container --%>
  <div class="container">
    <%-- nav --%>
    <%@include file="nav.jsp"%>
    <%-- content --%>
    <div class="container mt-4 text-white">
      <%-- Header --%>
      <h1>you have a nose for curiosity!</h1>
      <hr class="w-25 mb-3">
      <%-- Subheader --%>
      <h2 class="mt-5">Did you know that the earliest perfume maker (on record) was a woman chemist named Tapputi?</h2>
      <p class="mt-4">
        Clay tablets found from Mesopotamia tell stories of Tapputi Belatekallim and her invention of fragrances.
      </p>
      <%-- images --%>
      <img src="images/taputi.jpg" alt="A mesopotamian clay tablet" class="img-fluid">
      <%-- subheader 2 --%>
      <h2 class="mt-5">What's in a fragrance?</h2>
      <p>
        A fragrance is usually a composition of a blend of extracts, essential oils, alcohol, and water.
      </p>
      <p>
        Since compositions can vary in the amount of perfume oil there have different names to determine how concentrated they are:
      </p>
      <ul>
        <li>Eau Fraiche (1-3%)</li>
        <li>Eau de Cologne (2-6%)</li>
        <li>Eau de Toilette (5-15%)</li>
        <li>Eau de Parfum (15-20%)</li>
        <li>Pure Perfume (15-40%)</li>
      </ul>
    </div>
  </div>
</body>
</html>
