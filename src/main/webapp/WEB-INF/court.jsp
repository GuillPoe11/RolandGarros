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

	<%@include file="menu.jspf" %>

	<div class="central-main-container row">
		<!-- Form -->
		<div class="container-form background col-md-5 col-md-offset-1">
			<h3 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h3>
			<s:form action="AjouterCourt" theme="simple">
				<h3>Enregistrer un court</h3>
				<table id="form-table" class="table">
					<tr>
						<td><s:label>Nom de court : </s:label></td>
						<td><s:textfield name="nomCourt" label="Nom du court "/></td>
					</tr>
					<tr>
						<td><s:label>Numéro de court : </s:label></td>
						<td><s:textfield name="numeroCourt" label="Numero du court " />
						</td>
					</tr>
					<tr>
						<td colspan="2" class="colspan-center"><s:submit
								method="ajouterCourt" value="Ajouter un court"
								cssClass="btn btn-primary" /></td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="container-liste background col-md-4 col-md-offset-1">
			<table id="liste-table" class="table table-bordered table-hover">
				<tr>
					<th>Nom du court</th>
					<th>Numéro du court</th>
				</tr>
				<s:iterator status="status" value="lstDixCourts">
					<%-- 	(<s:property value="#status.index" />)- --%>
					<tr>
						<td><s:property value="nomCourt" /></td>
						<td><s:property value="numeroCourt" /></td>

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