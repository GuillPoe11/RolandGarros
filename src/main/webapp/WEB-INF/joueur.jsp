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
			<s:property value="message" />
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
					listValue="value" name="idNationalite" />
			</fieldset>
			<fieldset>
				<s:submit method="creerJoueur" value="Valider" />
			</fieldset>
		</s:form>
	</div>
	<!--  @end Form -->

	<div class="container-liste background col-md-4 col-md-offset-1">
		<table class="table table-bordered table-hover">
			<tr>
				<th>Prénom</th>
				<th>Nom</th>
				<th>Sexe</th>
				<th>Nationalité</th>
			</tr>
			<s:iterator status="status" value="lstJoueurs">
				<tr>
					<td>(<s:property value="#status.index" />)-<s:property
							value="prenomJoueur" /></td>
					<td><s:property value="nomJoueur" /></td>
					<td><s:property value="sexeJoueur" /></td>
					<td><s:property value="nationalite.libelleNationalite" /></td>
				</tr>

			</s:iterator>
		</table>

	</div>

	<jsp:include page="footer.jspf" />

</body>
</html>