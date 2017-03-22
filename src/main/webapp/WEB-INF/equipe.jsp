<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Joueur Roland Garros</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

	<!-- Form -->
	<div class="container_form">
		<s:form id="contact" action="AjouterEquipe">
			<h3>Ajouter une Nouvelle équipe</h3>
			<h4>Joueur 1</h4>
			<fieldset>
				<s:select
			       name="idJoueur1"
			       headerKey="-1" headerValue="Selectionner Joueur1"
			       list="mapJoueur"
			       value="selectJoueur1"
			       required="true"
				/>
			</fieldset>
			<h4>Joueur 2</h4>
			<fieldset>
				<s:select
			       name="idJoueur2"
			       headerKey="-1" headerValue="Selectionner Joueur2"
			       list="mapJoueur"
			       value="selectJoueur1"
			       required="true"
				/>
			</fieldset>
			<fieldset>
				<s:submit method="creerEquipe" value="Enregistrer" id="contact-submit"></s:submit>
			</fieldset>
		</s:form>
	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>