<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Résultats Roland Garros</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

	<!-- tableau -->
	<div class="central-main-container row">
	
		<div class="container-liste background col-md-10 col-md-offset-1 resultat">
			<s:iterator status="status" value="lstMatchs">
				<table class="table table-bordered table-hover col-md-2 col-md-offset-1 ">
					<tr>
						<td>Court</td>
						<td>(<s:property value="#status.index" />)-<s:property value="court.nomCourt" /></td>
					</tr>
					<tr>	
						<td>Type de Tournoi</td>
						<td><s:property value="sousTournoi.typeSousTournoi" /></td>
					</tr>
					<tr>	
						<td>Date</td>
						<td><s:property value="dateMatch" /></td>
					</tr>
					<tr>
						<td>Joueur1</td>
						<td><s:property value="joueur1.nomJoueur" /></td>
					</tr>
					<tr>	
						<td>Joueur2</td>
						<td><s:property value="joueur2.nomJoueur" /></td>
					</tr>
					<tr>	
						<td>Score1</td>
						<td><s:property value="score1"/></td>
					</tr>
					<tr>	
						<td>Score2</td>
						<td><s:property value="score2"/></td>
					</tr>
					<tr>
						<td>Durée</td>
						<td><s:property value="duree"/></td>		
					</tr>	
				</table>
			</s:iterator>
		</div>
		<!-- End tableau -->
	</div>
	<br class="clear"/>
	<jsp:include page="footer.jspf" />

</body>
</html>