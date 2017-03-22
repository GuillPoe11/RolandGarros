<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<title>Joueur Roland Garros</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

	<!-- Form -->
	<div class="container_form">
		<form id="contact" action="" method="post">
			<h3>Ajouter un joueur</h3>
			<fieldset>
				<input placeholder="Nom" type="text" tabindex="1" required
					autofocus>
			</fieldset>
			<fieldset>
				<input placeholder="Prénom" type="text" tabindex="2"
					required>
			</fieldset>
			<fieldset>
				<input placeholder="Sexe" type="text" tabindex="3"
					required>
			</fieldset>
			<fieldset>
				<input placeholder="Nationalité" type="text" tabindex="4"
					required>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Enregistrer le joueur</button>
			</fieldset>
		</form>
	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>