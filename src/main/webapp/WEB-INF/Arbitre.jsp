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
		<s:form id="contact" action="ArbitreAction">
			<h3>Inscription des arbitres (de chaise)</h3>
			<fieldset>
				<s:textfield placeholder="Nom arbitre"
					value="#{ArbitreAction.nom} type=" text" tabindex="1" required
					autofocus></s:textfield>
			</fieldset>
			<fieldset>
				<s:textfield placeholder="Prenom arbitre"
					value="#{ArbitreAction.prenom} type=" text" tabindex="2" required></s:textfield>
			</fieldset>
			<fieldset>
				<s:submit name="submit" method="submit" type="submit"
					id="contact-submit">Submit</s:submit>
			</fieldset>
		</s:form>
	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>