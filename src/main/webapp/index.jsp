<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros</title>
<meta name="description" content="">
<jsp:include page="WEB-INF/head.jspf" />
<style>
.effet-nav-home:hover {
	transform: scale(1.08);
	background-color: #222;
	border:1px outset #000;
	-webkit-transition: all 1s linear;
	-ms-transition: all 1s linear;
	transition: all 1s linear;
}
</style>
</head>
<body>

	<%@include file="WEB-INF/menu.jspf"%>

	<!-- Form -->
	<div class="central-main-container row btn-group-home">
	<br> <a class="lienNav" 
			href=<s:url action="EnregistrerScoreMatchTest"></s:url>><button
				class="btn-home effet-nav-home" style="width:600px;">
				<span style="width:600px;">Enregistrer un score v2<br>GouiGoui Bossera
					Samedi Soir<br>J'ai avancé, continuerais dimanche
				</span>
			</button></a><br>
		<a class="lienNav" href=<s:url action="AjouterJoueur"></s:url>><button
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
				<span>Enregistrer un score // STOPPP //</span>
			</button></a> <a class="lienNav" href=<s:url action="AjouterArbitre"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Ajouter un arbitre</span>
			</button></a> <a class="lienNav" href=<s:url action="AjouterEquipe"></s:url>><button
				class="btn-home effet-nav-home">
				<span>Ajouter une équipe</span>
			</button></a> 

	</div>
	<!--  @end Form -->

	<jsp:include page="WEB-INF/footer.jspf" />

</body>
</html>