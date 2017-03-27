<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros</title>
<meta name="description" content="">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
	$(function() {
		$("#datepicker").datepicker(
				{
					dateFormat : "dd/mm/yy",
					closeText : 'Fermer',
					prevText : 'Précédent',
					nextText : 'Suivant',
					monthNames : [ 'Janvier', 'Février', 'Mars', 'Avril',
							'Mai', 'Juin', 'Juillet', 'Août', 'Septembre',
							'Octobre', 'Novembre', 'Décembre' ],
					dayNamesMin : [ "Di", "Lu", "Ma", "Me", "Je", "Ve", "Sa" ]
				})
	});
</script>
<jsp:include page="../head.jspf" />
</head>
<body>


	<%@include file="../menu.jspf"%>

	<div class="central-main-container row">



		<!-- Form -->
		<div class="container-form background col-md-offset-1 col-md-10 clear">
			<h3>Planification des matchs en équipe</h3>
			<h4 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h4>


			<s:form id="contact" action="PlanifierMatch" theme="simple">

				<table id="form-table" class="table">
					<tr>
						<td>Sous-Tournoi</td>
						<td><s:select label="Sélectionnez un Sous-Tournoi"
								headerKey="-1" headerValue="--------"
								list="mapSousTournoisEquipe" listKey="key" listValue="value"
								name="idSousTournoi" /></td>
					</tr>
					<tr>
						<td>Equipe 1</td>
						<td><s:select label="Sélectionnez une equipe" headerKey="-1"
								headerValue="--------" list="mapEquipes" listKey="key"
								listValue="value" name="idEquipe1" /></td>
					</tr>
					<tr>
						<td>Equipe 2</td>
						<td><s:select label="Sélectionnez une equipe" headerKey="-1"
								headerValue="--------" list="mapEquipes" listKey="key"
								listValue="value" name="idEquipe2" /></td>
					</tr>
					<tr>
						<td>Arbitre</td>
						<td><s:select label="Sélectionnez un arbitre" headerKey="-1"
								headerValue="--------" list="mapArbitres" listKey="key"
								listValue="value" name="idArbitre" /></td>
					</tr>
					<tr>
						<td>Court</td>
						<td><s:select label="Sélectionnez un court" headerKey="-1"
								headerValue="--------" list="mapCourts" listKey="key"
								listValue="value" name="idCourt" /></td>
					</tr>
					<tr>
						<td>Date du match</td>
						<td><s:textfield name="dateMatch" label="Date du match"
								id="datepicker"></s:textfield></td>
					</tr>
					<tr>
						<td>Heure du match</td>
						<td><s:select label="Heure" list="lstHeures"
								name="integerHeure" cssClass="inline" /> <s:select
								label="Minute" list="#{'0':'0','15':'15', '30':'30', '45':'45'}"
								listKey="key" listValue="value" name="integerMinute"
								cssClass="inline" /></td>
					</tr>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								cssClass="btn btn-primary" method="creerMatchEquipe"
								value="Valider" /></td>
					</tr>
				</table>
			</s:form>

		</div>
		<div style="height: 20px; clear: both;"></div>

		<div
			class="container-liste background col-md-offset-1 col-md-10 clear">
			<table class="table table-bordered table-hover">
				<tr>
					<th>Court</th>
					<th>Equipes 1</th>
					<th>Equipe 2</th>
					<th>Arbitre</th>
					<th>SousTournoi</th>
					<th>Date</th>
				</tr>
				<s:iterator status="status" value="lstDixDerniersMatchsEquipe">
					<tr>
						<td><s:property value="court.nomCourt" /></td>
						<td><s:property value="equipe1.joueur1.nomJoueur" />-<s:property
								value="equipe1.joueur2.nomJoueur" /></td>
						<td><s:property value="equipe2.joueur1.nomJoueur" />-<s:property
								value="equipe2.joueur2.nomJoueur" /></td>
						<td><s:property value="arbitre.nomArbitre" /></td>
						<td><s:property value="sousTournoi.nomSousTournoi" /></td>
						<td><s:date format="dd/MM/yyyy HH:mm" name="dateMatch" /></td>
					</tr>
				</s:iterator>
			</table>

		</div>
		<!--  @end Form -->
	</div>
	<jsp:include page="../footer.jspf" />

</body>
</html>