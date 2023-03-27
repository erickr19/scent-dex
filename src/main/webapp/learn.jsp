<%--
  learn page for scent dex
  author: ereyes3
--%>
<%@include file="head.jsp"%>
<html lang="en">
<body class="bg-black">
  <%-- main container --%>
  <div class="container">
    <%-- nav --%>
    <%@include file="new-nav.jsp"%>
    <%-- content --%>
    <div class="container mt-4 text-white">
      <%-- Header --%>
      <h1>you have a nose for curiosity!</h1>
      <hr class="w-25 mb-3">
      <%-- TODO: add why cultures used fragrances --%>
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
        Since compositions can vary in the amount of perfume oil they contain, different names usually determine how concentrated they are:
      </p>
      <ul>
        <li>Eau Fraiche (1-3%)</li>
        <li>Eau de Cologne (2-6%)</li>
        <li>Eau de Toilette (5-15%)</li>
        <li>Eau de Parfum (15-20%)</li>
        <li>Pure Perfume (15-40%)</li>
      </ul>
      <%-- subheader 3 --%>
      <h2 class="mt-5">A fragrance's lifetime</h2>
        <p>
          Unfortunately fragrances don't last forever once applied. Some last more than others due to their composition.
          It's usually by design since it gives the other scent notes an opportunity to be revealed.
        </p>
      <%-- subheader 4 --%>
      <h2 class="mt-5">Layering smells</h2>
        <p>
          The layers of a fragrance are usually divided into three. There's the top notes which can be detected when the fragrance is applied.
          The middle notes which can be detected later on during the scent's lifespan. Finally, there's the base notes which can be detected
          once the other notes have died down.
        </p>
        <p>
          There's an abundance of notes for everyone. Common notes are citrus, flowers, ambers, musks, and woods.
        </p>
      <%-- subheader 5 --%>
      <h2 class="mt-5">Fragrances and You</h2>
        <p>
          Fragrances interact with your body chemistry and can inherit interesting properties from your person.
          It could make some notes more pronounced, make the fragrance lifetime different, or even change the fragrance completely.
        </p>
      <%-- subheader 6 --%>
      <h2 class="mt-5">Projection</h2>
        <p>
          Fragrances can project their scents depending on their composition. There's some that can be smelled by others
          across a room and there's some that are more intimate.
        </p>
      <%-- subheader 7 --%>
      <h2 class="mt-5">Finding a scent</h2>
        <p>
          The best way to find a scent is to personally go sample it. A lot of places allow you to do so by spraying testers.
          It's not recommended to "blind buy" a fragrance based off reviews alone as one's olfactory senses differ from another.
        </p>
    </div>
  </div>
</body>
</html>
