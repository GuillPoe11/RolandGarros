<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<style>
.margin {
	margin: 0px;
	padding: 0px;
}
</style>
<title>Roland Garros - Court</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />
	<div class="central-main-container">
		<!-- Form -->
		<div class="container-form background">
			<p class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</p>
			<h3>Enregistrer un court</h3>
			<s:form action="AjouterCourt" cssClass="form-vertical" theme="simple">

				<s:textfield name="nomCourt" label="Nom du court " />
				<br></br>
				<s:textfield name="numeroCourt" label="Numero du court " />
				<br></br>
				<fieldset>
					<s:submit method="ajouterCourt" value="Ajouter un court" />
				</fieldset>
			</s:form>
		</div>

		<!--  @end Form -->
		<div class="container-liste background">
			<table class="table table-bordered table-hover">
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
	<br class="clear" />

	<jsp:include page="footer.jspf" />

</body>
</html>