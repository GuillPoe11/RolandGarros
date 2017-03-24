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
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
.inline {
	display: inline-block;
	width: 50px;
}
</style>
<script>
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "dd/mm/yy"
		}).val()
	});
</script>
<jsp:include page="head.jspf" />
</head>
<body>


	<%@include file="menu.jspf"%>

	<div class="central-main-container row">
		<h3>Planification des matchs</h3>
		<div class="container-liste background  col-md-offset-1 col-md-7 ">
			<table class="table table-bordered table-hover">
				<tr>
					<td>Court</td>
					<td>Joueur 1</td>
					<td>Joueur 2</td>
					<td>Arbitre</td>
					<td>SousTournoi</td>
					<td>Date</td>
					<td>Durée</td>
					<td>Equipes 1</td>
					<td>Equipe 2</td>
					<td>Score 1</td>
					<td>Score 2</td>
				</tr>
				<s:iterator status="status" value="lstDixDerniersMatchs">
					<tr>
						<td>(<s:property value="#status.index" />) <s:property
								value="court.nomCourt" /></td>
						<td><s:property value="joueur1.nomJoueur" /></td>
						<td><s:property value="joueur2.nomJoueur" /></td>
						<td><s:property value="arbitre.nomArbitre" /></td>
						<td><s:property value="sousTournoi.nomSousTournoi" /></td>
						<td><s:property value="dateMatch" /></td>
						<td><s:property value="dureeMatch" /></td>
						<td><s:property value="equipe1.joueur1.nomJoueur" />-<s:property
								value="equipe1.joueur2.nomJoueur" /></td>
						<td><s:property value="equipe2.joueur1.nomJoueur" />-<s:property
								value="equipe2.joueur2.nomJoueur" /></td>
						<td><s:property value="score1" /></td>
						<td><s:property value="score2" /></td>

					</tr>

				</s:iterator>
			</table>

		</div>


		<!-- Form -->
		<div class="container-form background col-md-offset-1 col-md-3">
			<h4 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h4>


			<s:form id="contact" action="PlanifierMatch" theme="simple">

				<table id="form-table" class="table">
					<tr>
						<td>Sous-Tournoi :</td>
						<td><s:select label="Sélectionnez un Sous-Tournoi"
								headerKey="-1" headerValue="--------" list="mapSousTournois"
								listKey="key" listValue="value" name="idSousTournoi" /></td>
					</tr>
					<tr>
						<td>Equipe 1 :</td>
						<td><s:select label="Sélectionnez une equipe" headerKey="-1"
								headerValue="--------" list="mapEquipes" listKey="key"
								listValue="value" name="idEquipe1" /></td>
					</tr>
					<tr>
						<td>Equipe 2 :</td>
						<td><s:select label="Sélectionnez une equipe" headerKey="-1"
								headerValue="--------" list="mapEquipes" listKey="key"
								listValue="value" name="idEquipe2" /></td>
					</tr>
					<tr>
						<td>Arbitre :</td>
						<td><s:select label="Sélectionnez un arbitre" headerKey="-1"
								headerValue="--------" list="mapArbitres" listKey="key"
								listValue="value" name="idArbitre" /></td>
					</tr>
					<tr>
						<td>Court :</td>
						<td><s:select label="Sélectionnez un court" headerKey="-1"
								headerValue="--------" list="mapCourts" listKey="key"
								listValue="value" name="idCourt" /></td>
					</tr>

					<tr>
						<td>Joueur 1 :</td>
						<td><s:select label="Sélectionnez un joueur" headerKey="-1"
								headerValue="--------" list="mapJoueurs" listKey="key"
								listValue="value" name="idJoueur1" /></td>
					</tr>
					<tr>
						<td>Joueur 2 :</td>
						<td><s:select label="Sélectionnez un joueur" headerKey="-1"
								headerValue="--------" list="mapJoueurs" listKey="key"
								listValue="value" name="idJoueur2" /></td>
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

					<%-- <tr>
						<td>Durée du match en minutes</td>
						<td><s:textfield name="match.dureeMatch"
								label="Durée du match"></s:textfield></td>
					</tr>
					<tr>
						<td>Score du premier joueur :</td>
						<td><s:textfield name="match.score1"
								label="Score du premier joueur"></s:textfield></td>
					</tr>
					<tr>
						<td>Score du deuxieme joueur :</td>
						<td><s:textfield name="match.score2"
								label="Score du deuxième joueur"></s:textfield></td>
					</tr> --%>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								method="creerMatch" value="Valider" /></td>
					</tr>
				</table>
			</s:form>
		</div>
		<!--  @end Form -->
	</div>
	<jsp:include page="footer.jspf" />

</body>
</html>