<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros - Enregistrer score du match</title>
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
		
		<div class="container-liste background  col-md-offset-1 col-md-7 ">
		<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>
		<h3>Enregistrer un score</h3>
			<s:form id="Select" action="EnregistrerScoreMatchTest" theme="simple">

				<table id="form-table" class="table">
					<tr>
						<td id="select-match">Sélection du match</td>
						<td><s:select label="Sélectionnez un match" headerKey="-1"
								headerValue="--------" list="mapMatchs" listKey="key"
								listValue="value" name="idMatchDansLst"
								cssClass="selectpicker show-tick form-control" /></td>
					</tr>
					<%-- <tr>
					<td><s:submit method="recupMatch" value="Valider" cssClass="btn btn-primary"/></td>
					</tr>
					 --%>
					<tr>
						<td>Durée du match en minutes</td>
						<td><s:textfield name="duree"
								label="Durée du match" cssClass="form-control"></s:textfield></td>
					</tr>
					<tr>
						<td>Score du premier joueur</td>
						<td><s:textfield name="score1"
								label="Score du premier joueur" cssClass="form-control"></s:textfield></td>
					</tr>
					<tr>
						<td>Score du deuxieme joueur</td>
						<td><s:textfield name="score2"
								label="Score du deuxième joueur" cssClass="form-control"></s:textfield></td>
					</tr>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								method="modifierMatch" value="Valider"
								cssClass="btn btn-primary" /></td>
					</tr>
				</table>
			</s:form>
		</div>
		<!--  @end Form -->
	</div>
	<jsp:include page="footer.jspf" />

</body>
</html>