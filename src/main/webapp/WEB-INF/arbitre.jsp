<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros - Arbitre</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

	<div class="central-main-container row">
		<!-- Form -->
		<div class="container-form background col-md-5 col-md-offset-1">
			<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>

			<s:form id="contact" action="AjouterArbitre" theme="simple">

				<table id="form-table" class="table">
					<tr>
						<td><s:label>Nom de l'arbitre : </s:label></td>
						<td><s:textfield name="arbitre.nomArbitre"
								label="Nom de l'arbitre"></s:textfield></td>
					</tr>
					<tr>
						<td><s:label>Prénom de l'arbitre : </s:label></td>
						<td><s:textfield name="arbitre.prenomArbitre"
								label="Prénom de l'arbitre"></s:textfield></td>
					</tr>
					<%-- <tr>
			<td>
			<s:select
			       name="idTypeArbitre"
			       headerKey="-1" headerValue="Chaise"
			       list="lstTypeArbitres"
			       value="Chaise"
			       label="Type de l'arbitre"
				/>
			</td>
			</tr> --%>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								method="submite" value="Valider" /></td>
					</tr>
				</table>
			</s:form>
		</div>
		<!--  @end Form -->
		<div class="container-liste background col-md-4 col-md-offset-1">
			<table id="liste-table" class="table table-bordered table-hover">
				<tr>
					<th>Prénom de l'arbitre</th>
					<th>Nom de l'arbitre</th>
				</tr>
				<s:iterator status="status" value="lstArbitres">
					<%-- 	(<s:property value="#status.index" />)- --%>
					<tr>
						<td><s:property value="prenomArbitre" /></td>
						<td><s:property value="nomArbitre" /></td>

					</tr>

				</s:iterator>
			</table>

		</div>
		<!--  @end Form -->

	</div>

	<br class="clear" />
	<jsp:include page="footer.jspf" />
</body>
</html>