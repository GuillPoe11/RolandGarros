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
<jsp:include page="head.jspf" />
</head>
<body>


	<%@include file="menu.jspf"%>

	<div class="central-main-container row">
		<h3>Planification des matchs</h3>
		<div class="container-liste background  col-md-offset-1 col-md-7 ">
			<table id="matchsAffichers" class="table table-bordered table-hover">
				<tr>
					<td>Court</td>
					<td>Joueur 1</td>
					<td>Joueur 2</td>
					<td>Arbitre</td>
					<td>SousTournoi</td>
					<td>Date</td>
					<td>Durée</td>
<!-- 					<td>Equipes 1</td> -->
<!-- 					<td>Equipe 2</td> -->
<!-- 					<td>Score 1</td> -->
<!-- 					<td>Score 2</td> -->
					<td></td>
				</tr>
				
				
				<s:iterator status="status" value="lstMatchs">
					<tr>
						<td>(<s:property value="#status.index" />) <s:property
								value="court.nomCourt" /></td>
						<td><s:property value="joueur1.nomJoueur" /></td>
						<td><s:property value="joueur2.nomJoueur" /></td>
						<td><s:property value="arbitre.nomArbitre" /></td>
						<td><s:property value="sousTournoi.nomSousTournoi" /></td>
						<td><s:property value="dateMatch" /></td>
						<td><s:property value="dureeMatch" /></td>
<%-- 						<td><s:property value="equipe1.joueur1.nomJoueur" />-<s:property --%>
<%-- 								value="equipe1.joueur2.nomJoueur" /></td> --%>
<%-- 						<td><s:property value="equipe2.joueur1.nomJoueur" />-<s:property --%>
<%-- 								value="equipe2.joueur2.nomJoueur" /></td> --%>
<%-- 						<td><s:property value="score1" /></td> --%>
<%-- 						<td><s:property value="score2" /></td> --%>
							
					<td><s:form action="EnregistrerScoreMatch">
					<s:hidden id="idMatchDansLst" name="idMatchDansLst" value="$(\"matchsAffichers\").index($(this))"></s:hidden><s:submit
								method="recupMatch" value="Modifier" />
				</s:form></td>
					</tr>
				</s:iterator>
			</table>

		</div>


		<!-- Form -->
		<div class="container-form background col-md-offset-1 col-md-3">
			<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>


			<s:form id="contact" action="EnregistrerScoreMatch">

				<table id="form-table" class="table">
					<tr>
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
					</tr>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								method="modifierMatch" value="Valider" /></td>
					</tr>
				</table>
			</s:form>
		</div>
		<!--  @end Form -->
	</div>
	<jsp:include page="footer.jspf" />

</body>
</html>