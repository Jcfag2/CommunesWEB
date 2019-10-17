<html>
<body>
<h2>Recherche par code postal</h2>
<form action="CommuneServlet" method="POST">
CodePostal <input name="cp" id="cp" size="6">
<button type="submit">Rechercher</button>
</form>

<form action="CommuneByNomServlet" method="POST">
Nom de Ville <input name="nomVille" id="nomVille" size="20">
<button type="submit">Rechercher</button>
</form>
</body>
</html>
