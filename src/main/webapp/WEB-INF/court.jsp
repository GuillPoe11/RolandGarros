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
	</div>
	<!--  @end Form -->
	
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
		

	<jsp:include page="footer.jspf" />

</body>
</html>