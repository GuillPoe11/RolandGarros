<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros - Ajouter un joueur</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

	<!-- Form -->
	<div class="container_form">
		<s:form id="contact" action="AjouterJoueur">
			<h3>Ajouter un joueur</h3>
			<h4>Remplissez le formulaire pour ajouter un joueur au tournoi</h4>
			<s:property value="message"/>
			<fieldset>
				<s:textfield name="joueur.nomJoueur" label="Nom du joueur" />
			</fieldset>
			<fieldset>
				<s:textfield name="joueur.prenomJoueur" label="Prénom du joueur" />
			</fieldset>
			<fieldset>
				<s:textfield name="joueur.sexeJoueur" label="Genre du joueur" />
			</fieldset>
			<fieldset>
				<s:select label="Sélectionnez une nationalité" headerKey="-1"
				headerValue="--------" list="mapNationalites" listKey="key"
				listValue="value" name="idNationalite"/>
			</fieldset>
			<fieldset>
				<s:submit method="creerJoueur" value="Valider" />
			</fieldset>
		</s:form>
	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>