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
				<s:if test="score1!=null && score2!=null">
					<div class="col-md-4 tab ">
						<div class="head-tab">
							<div id="nom-court"><s:property value="court.nomCourt" /></div>
							<s:if test="sousTournoi.typeSousTournoi=='S'">
							<div id="type">Simple</div>
							</s:if>
							<s:elseif test="sousTournoi.typeSousTournoi=='E'">
							<div id="type">Double</div>
							</s:elseif>
						</div>
						<table class="table table-bordered background table-hover col-md-12">
							<tr>	
								<td colspan="4">Match du <s:date name="dateMatch" format="dd/MM/yyyy HH:mm" /></td>
							</tr>
							<s:if test="equipe1.joueur1.nomJoueur != '' && equipe1.joueur2.nomJoueur != ''">
							<tr>
								<td class="nom-equipe"><s:property value="equipe1.joueur1.nomJoueur"/> <s:property value="equipe1.joueur1.prenomJoueur"/></td>
								<td class="nom-equipe"><s:property value="equipe1.joueur2.nomJoueur"/> <s:property value="equipe1.joueur2.prenomJoueur"/></td>
								<td class="set">Sets</td>
								<td class="score"><s:property value="score2"/></td>
							</tr>
							<tr>
								<td class="nom-equipe"><s:property value="equipe2.joueur1.nomJoueur"/> <s:property value="equipe2.joueur1.prenomJoueur"/></td>
								<td class="nom-equipe"><s:property value="equipe2.joueur2.nomJoueur"/> <s:property value="equipe2.joueur2.prenomJoueur"/></td>
								<td class="set">Sets</td>
								<td class="score"><s:property value="score1"/></td>
							</tr>
							</s:if>
							<s:else>
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
							</s:else>	
						</table>
						<div class="duree">Durée : <s:property value="dureeMatch"/> mn</div>
					</div>	
				</s:if>	
			</s:iterator>
		
		</div>
		<!-- End tableau -->
	</div>
	<br class="clear"/>
	<jsp:include page="footer.jspf" />

</body>
</html>