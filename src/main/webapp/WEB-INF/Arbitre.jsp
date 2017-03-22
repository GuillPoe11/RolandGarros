<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

	<!-- Form -->
	<div class="container_form">
		<form id="contact" action="ArbitreAction" method="post">
			<h3>Inscription des arbitres (de chaises)</h3>
			<fieldset>
				<input placeholder="Nom arbitre" value="#{ArbitreAction.nom} type="text" tabindex="1" required
					autofocus>
			</fieldset>
			<fieldset>
				<input placeholder="Prenom arbitre" value="#{ArbitreAction.prenom} type="email" tabindex="2"
					required>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Submit</button>
			</fieldset>
		</form>
	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>