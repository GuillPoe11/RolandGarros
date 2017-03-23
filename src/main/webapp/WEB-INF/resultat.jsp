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
	<div class="central-main-container row containresult">
	
		<div class="container-liste col-md-12 resultat">
			<s:iterator status="status" value="lstMatchs">
				<table class="table table-bordered background table-hover col-md-4 col-md-offset-1">
					<tr>
						<td>(<s:property value="#status.index" />)-<s:property value="court.nomCourt" /></td>
					</tr>
					<tr>	
						<td>Type : <s:property value="sousTournoi.typeSousTournoi" /></td>
					</tr>
					<tr>	
						<td><s:property value="dateMatch" /></td>
					</tr>
					<tr>
						<td>Joueur1</td>
						<td><s:property value="joueur1.nomJoueur" /></td>
						<td><s:property value="score2"/></td>
					</tr>
					<tr>	
						<td>Joueur2</td>
						<td><s:property value="joueur2.nomJoueur" /></td>
						<td><s:property value="score1"/></td>
					</tr>
					<tr>	
						<td>Score1</td>
						
					</tr>
					<tr>	
						<td>Score2</td>
						
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