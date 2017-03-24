<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros - Connexion</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<%@include file="menu.jspf"%>

	<!-- Form -->
	<div class="central-main-container row">
		<div
			class="container-form background col-md-2 col-md-offset-5">
			<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>
			<s:form action="Connexion" cssClass="form-vertical" theme="simple">
				<h3>Se connecter</h3>
				<s:textfield name="organisateur.loginOrganisateur" label="Login" />
				<br></br>
				<s:password name="organisateur.passwordOrganisateur"
					label="Mot de passe" />
				<br></br>
				<s:submit cssClass="btn btn-primary" method="seConnecter"
					value="Connexion" />
			</s:form>

		</div>


		<!--  @end Form -->

	</div>

	<br class="clear" />

	<jsp:include page="footer.jspf" />

</body>
</html>