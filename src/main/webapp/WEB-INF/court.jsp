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
	<div class="central-main-container">
		<!-- Form -->
		<div class="container-form background">
			<h1 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h1>
			<s:form action="AjouterCourt" id="contact">
				<h3>Enregistrer un court</h3>
				<s:textfield name="nomCourt" label="Nom du court " />
				<br></br>
				<s:textfield name="numeroCourt" label="Numero du court " />
				<br></br>
				<fieldset>
					<s:submit method="ajouterCourt" value="Ajouter un court" />
				</fieldset>
				<s:property value="msgForm" />
			</s:form>

		</div>

		<!--  @end Form -->
		<div class="container-liste background">
			<table border="1">
				<tr>
					<td>Nom du court</td>
					<td>Numéro du court</td>
				</tr>
				<s:iterator status="status" value="lstCourts">
					<tr>
						<td>(<s:property value="#status.index" />)-<s:property
								value="nomCourt" /></td>
						<td><s:property value="numeroCourt" /></td>

					</tr>

				</s:iterator>
			</table>

		</div>
	</div>
	<br class="clear"/>

	<jsp:include page="footer.jspf" />

</body>
</html>