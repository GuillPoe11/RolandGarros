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
	function verif(evt,str) {
        var keyCode = evt.which ? evt.which : evt.keyCode;
        var accept = '0123456789';
        if (accept.indexOf(String.fromCharCode(keyCode)) >= 0) {
            return true;
        } else {
            if(str == "duree"){
            	$('#errorDuree').css('visibility','visible');
            }
            if(str == "score1"){
            	$('#errorScore1').css('visibility','visible');
            }
            if(str == "score2"){
            	$('#errorScore2').css('visibility','visible');
            }
            return false;
        }
    }
</script>
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
								listValue="value" name="idMatchDansSelect"
								cssClass="selectpicker show-tick form-control" /></td>
					</tr>
					<%-- <tr>
					<td><s:submit method="recupMatch" value="Valider" cssClass="btn btn-primary"/></td>
					</tr>
					 --%>
					<tr>
						<td>Durée du match en minutes</td>
						<td><s:textfield id="duree" name="duree" onkeypress="verif(event,'duree')"
								label="Durée du match" cssClass="form-control"></s:textfield>
								<span id="errorDuree" class="msgErrorJs">Seuls les chiffres sont autorisés</span></td>
					</tr>
					<tr>
						<td>Score du premier joueur/equipe</td>
						<td><s:textfield name="score1" onkeypress="verif(event,'score1')"
								label="Score du premier joueur" cssClass="form-control"></s:textfield>
								<span id="errorScore1" class="msgErrorJs">Seuls les chiffres de 0 à 5 sont autorisés</span></td>
					</tr>
					<tr>
						<td>Score du deuxieme joueur/equipe</td>
						<td><s:textfield name="score2" onkeypress="verif(event,'score2')"
								label="Score du deuxième joueur" cssClass="form-control"></s:textfield>
								<span id="errorScore2" class="msgErrorJs">Seuls les chiffres de 0 à 5 sont autorisés</span></td>
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
				<%-- <tr><td>
								<s:select
								label="Minute" list="#{'0':'0','1':'1', '2':'2', '3':'3'}"
								listKey="key" listValue="value" name="integerMinute"
								cssClass="inline" />
								</td>
								</tr> --%>
								
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