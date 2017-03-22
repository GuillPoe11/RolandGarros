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

	<jsp:include page="menu.jspf" />

	<!-- Form -->
	<div class="container_form">
		<s:form id="contact" action="AjouterArbitre">
			<h3>Inscription des arbitres (de chaise)</h3>
			<fieldset>
				<s:textfield 
					name="arbitre.nomArbitre" label="Nom de l'arbitre" ></s:textfield>
			</fieldset>
			<fieldset>
				<s:textfield 
					name="arbitre.prenomArbitre" label="Prénom de l'arbitre"></s:textfield>
			</fieldset>
			<fieldset>
				<s:submit method="submite" value="Valider"/>
			</fieldset>
		</s:form>
	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>