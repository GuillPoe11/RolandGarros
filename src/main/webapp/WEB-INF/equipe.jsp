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
		<div class="container-form background col-md-5 col-md-offset-1">
			<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>
			<s:form id="contact" action="AjouterEquipe">
				<h3>Ajouter une Nouvelle équipe</h3>
				<table id="form-table" class="table">
					<tr>
						<td><s:select name="idJoueur1" headerKey="-1"
								headerValue="Selectionner Joueur1" list="mapJoueur"
								value="joueur1" required="true"
								cssClass="selectpicker show-tick form-control" /></td>
					</tr>
					<tr>
						<td><s:select name="idJoueur2" headerKey="-1"
								headerValue="Selectionner Joueur2" list="mapJoueur"
								value="joueur2" required="true"
								cssClass="selectpicker show-tick form-control" /></td>
					</tr>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								method="creerEquipe" value="Enregistrer" id="contact-submit"
								cssClass="btn btn-primary"></s:submit></td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="clear"></div>
		<div class="container-liste background col-md-4 col-md-offset-1">
			<table class="table table-bordered table-hover">
				<tr>
					<th>Numéro de l'équipe</th>
					<th>Joueur1</th>
					<th>Joueur2</th>
				</tr>
				<s:iterator status="status" value="lstEquipes">
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

		<!--  @end Form -->
	</div>
	<br class="clear" />
	<jsp:include page="footer.jspf" />

</body>
</html>