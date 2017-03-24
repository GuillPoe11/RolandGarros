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

	<%@include file="menu.jspf" %>

	<!-- tableau -->
	<div class="central-main-container row containresult">
	
		<div class="container-liste col-md-12 resultat">
			<s:iterator status="status" value="lstMatchs">
				
					<div class="col-md-4">
						<div id="nom-court">(<s:property value="#status.index" />)-<s:property value="court.nomCourt" /></div>
						<div id="type"><s:property value="sousTournoi.typeSousTournoi" /></div>
						<table class="table table-bordered background table-hover col-md-12">
							<tr>	
								<td>Match du <s:property value="dateMatch"/></td>
							</tr>
							<tr>
								<td class="nom-joueur"><s:property value="joueur1.nomJoueur"/> <s:property value="joueur1.prenomJoueur"/></td>
								<td class="set">Sets</td>
								<td class="score"><s:property value="score2"/></td>
							</tr>
							<tr>
								<td class="nom-joueur"><s:property value="joueur2.nomJoueur" /> <s:property value="joueur2.prenomJoueur" /></td>
								<td class="set">Sets</td>
								<td class="score"><s:property value="score1"/></td>
							</tr>	
						</table>
						<div class="duree">Durée : <s:property value="duree"/> mn</div>
					</div>	
					
			</s:iterator>
		</div>
		<!-- End tableau -->
	</div>
	<br class="clear"/>
	<jsp:include page="footer.jspf" />

</body>
</html>