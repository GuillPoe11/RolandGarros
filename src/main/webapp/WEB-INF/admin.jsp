<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros</title>
<meta name="description" content="">
<jsp:include page="head.jspf" />
</head>
<body>

	<%@include file="menu.jspf"%>

	<!-- Form -->
	<div class="central-main-container row btn-group-home">

		<br> <a class="lienNav"
			href=<s:url action="AjouterJoueur"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Ajouter un joueur</span>
			</button></a> <a class="lienNav" href=<s:url action="AjouterCourt"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Ajouter un Court&nbsp;&nbsp;</span>
			</button></a> <a class="lienNav" href=<s:url action="PlanifierMatch"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Planifier un Match</span>
			</button></a> <br> <a class="lienNav"
			href=<s:url action="EnregistrerScoreMatch"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Enregistrer un score</span>
			</button></a> <a class="lienNav" href=<s:url action="AjouterArbitre"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Ajouter un arbitre</span>
			</button></a> <a class="lienNav" href=<s:url action="AjouterEquipe"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Ajouter une équipe</span>
			</button></a>


	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>