<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros</title>
<meta name="description" content="">

<jsp:include page="WEB-INF/head.jspf" />
</head>
<body>

	<jsp:include page="WEB-INF/menu.jspf" />

	<!-- Form -->
	<div class="container_form">
			<table>
			<tr>
			<td><li><a class="lienNav" href=<s:url action="AjouterJoueur"></s:url>>Ajouter joueur</a></li></td>
			<td><li><a class="lienNav" href=<s:url action="AjouterCourt"></s:url>>Ajouter Court</a></li></td>
			<td><li><a class="lienNav" href=<s:url action="PlanifierMatch"></s:url>>Planifier match</a></li></td>
			</tr>
			<tr>
			<td><li><a class="lienNav" href=<s:url action="EnregistrerScoreMatch"></s:url>>Enregistrer le résultat du match</a></li></td>
			<td><li><a class="lienNav" href=<s:url action="AjouterArbitre"></s:url>>Ajouter arbitre</a></li></td>
			<td><li><a class="lienNav" href=<s:url action="AjouterEquipe"></s:url>>Ajouter équipe</a></li></td>
			</tr>
			</table>
	</div>
	<!--  @end Form -->

	<jsp:include page="WEB-INF/footer.jspf" />

</body>
</html>