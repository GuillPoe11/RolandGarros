<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Equipe Roland Garros</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<%@include file="menu.jspf"%>

	<!-- tableau -->
	<div class="central-main-container row">

		<div class="container-liste background col-md-4 col-md-offset-1">
			<table class="table table-bordered table-hover">
				<tr>
					<td>Numéro de l'équipe</td>
					<td>Joueur1</td>
					<td>Joueur2</td>
				</tr>
				<s:iterator status="status" value="lstDixDernieresEquipes">
					<tr>
						<td><s:property value="idEquipe" /></td>
						<td><s:property value="joueur1.nomJoueur" /></td>
						<td><s:property value="joueur2.nomJoueur" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<!-- End tableau -->

		<!-- Form -->
		<div class="container-form background col-md-5 col-md-offset-1">
			<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>
			<s:form id="contact" action="AjouterEquipe">
				<h3>Ajouter une Nouvelle équipe</h3>
				<fieldset>
					<s:select name="idJoueur1" headerKey="-1"
						headerValue="Selectionner Joueur1" list="mapJoueur"
						value="joueur1" required="true"
						cssClass="selectpicker show-tick form-control" />
				</fieldset>
				<fieldset>
					<s:select name="idJoueur2" headerKey="-1"
						headerValue="Selectionner Joueur2" list="mapJoueur"
						value="joueur2" required="true"
						cssClass="selectpicker show-tick form-control" />
				</fieldset>
				<fieldset>
					<s:submit method="creerEquipe" value="Enregistrer"
						id="contact-submit" cssClass="btn btn-success"></s:submit>
				</fieldset>
			</s:form>
		</div>
		<!--  @end Form -->
	</div>
	<br class="clear" />
	<jsp:include page="footer.jspf" />

</body>
</html>