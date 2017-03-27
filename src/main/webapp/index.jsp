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

	<%@include file="WEB-INF/menu.jspf"%>

	<!-- Form -->
	<div class="central-main-container row btn-group-home">
		<div style="background-color: white;">

			Liste erreurs à corriger : <br> Planifier match : Enregistrer
			match fonctionne avec 2 joueurs, mais pas avec 2 equipes<br> :
			possibilité d'entrer 2 joueurs et 2 equipes en même temps<br>

			Enregistrer score, les controles de form ne marche pas (ex vérif
			score = chiffre)
		</div>
		<br> <a class="lienNav"
			href=<s:url action="EnregistrerScoreMatchTest"></s:url>><button
				class="btn-home effet-nav-home">
				<span style="width: 600px;">Enregistrer un score v2<br>
				</span>
			</button></a><br> <a class="lienNav"
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