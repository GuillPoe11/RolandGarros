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

	<%@include file="menu.jspf"%>

	<!-- Form -->
	<div class="central-main-container row">
		<div class="container-form background col-md-5 col-md-offset-1">
			<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>
			<s:form id="contact" action="AjouterJoueur" theme="simple">
				<h3>Ajouter un joueur</h3>
				<h4>Remplissez le formulaire pour ajouter un joueur au tournoi</h4>
				<table id="form-table" class="table">
					<tr>
						<td><s:label>Nom du joueur : </s:label></td>
						<td><s:textfield name="joueur.nomJoueur"
								label="Nom du joueur" /></td>
					</tr>
					<tr>
						<td><s:label>Prénom du joueur : </s:label></td>
						<td><s:textfield name="joueur.prenomJoueur"
								label="Prénom du joueur" /></td>
					</tr>
					<tr>
						<td><s:label>Genre du joueur : </s:label></td>
						<td><s:select label="Genre du joueur"
								list="#{'M':'Homme', 'F':'Femme'}" listKey="key"
								listValue="value" name="joueur.sexeJoueur" /></td>
					</tr>
					<tr>
						<td><s:label>Nationalité du joueur : </s:label></td>
						<td><s:select label="Sélectionnez une nationalité"
								headerKey="-1" headerValue="--------" list="mapNationalites"
								listKey="key" listValue="value" name="idNationalite" /></td>
					</tr>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								method="creerJoueur" value="Valider" cssClass="btn btn-primary" />
						</td>
					</tr>
				</table>
			</s:form>
		</div>
		<!--  @end Form -->

		<div class="container-liste background col-md-4 col-md-offset-1">
			<table id="liste-table" class="table table-bordered table-hover">
				<tr>

					<th>Prénom</th>
					<th>Nom</th>
					<th>Sexe</th>
					<th>Nationalité</th>
				</tr>
				<s:iterator status="status" value="lstJoueurs">
					<tr>
						<td><s:property value="prenomJoueur" /></td>
						<td><s:property value="nomJoueur" /></td>
						<td><s:property value="sexeJoueur" /></td>
						<td><s:property value="nationalite.libelleNationalite" /></td>
					</tr>

				</s:iterator>
			</table>

		</div>
		<!--  @end Form -->

	</div>

	<br class="clear" />
	<jsp:include page="footer.jspf" />

</body>
</html>