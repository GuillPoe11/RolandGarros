<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros - Court</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

	<!-- Form -->
	<div class="container_form">
		<s:form action="AjouterCourt">
			<s:textfield name="nomCourt" label="Nom du court : " />
			<br></br>
			<s:textfield name="numeroCourt" label="Numero du court : " />
			<br></br>
			<fieldset>
				<s:submit method="ajouterCourt" value="Ajouter un court" />
			</fieldset>
		</s:form>
		<a href="<s:url value="../index.jsp"/>">Retour au menu</a>
	</div>
	<!--  @end Form -->

	<jsp:include page="footer.jspf" />

</body>
</html>