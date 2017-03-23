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
<h3>Inscription des arbitres (de chaise)</h3>
	<div class="container-liste background col-md-4 col-md-offset-1">
			<table class="table table-bordered table-hover">
				<tr>
					<td>Nom de l'arbitre</td>
					<td>prénom de l'arbitre</td>
				</tr>
				<s:iterator status="status" value="lstArbitres">
					<tr>
						<td>
<%-- 						(<s:property value="#status.index" />) --%>
						<s:property
								value="nomArbitre" /></td>
						<td><s:property value="prenomArbitre" /></td>

					</tr>

				</s:iterator>
			</table>

		</div>
		
		
	<!-- Form -->
	<div class="container-form background col-md-5 col-md-offset-1">
	
	
	
	
	
		<s:form id="contact" action="AjouterArbitre">
			
			<fieldset>
				<s:textfield 
					name="arbitre.nomArbitre" label="Nom de l'arbitre" ></s:textfield>
			</fieldset>
			<fieldset>
				<s:textfield 
					name="arbitre.prenomArbitre" label="Prénom de l'arbitre"></s:textfield>
			</fieldset>
			<fieldset>
			<s:select
			       name="idTypeArbitre"
			       headerKey="-1" headerValue="Chaise"
			       list="lstTypeArbitres"
			       value="Chaise"
			       label="Type de l'arbitre"
				/>
			</fieldset>
			<fieldset>
				<s:submit method="submite" value="Valider"/>
			</fieldset>
		</s:form>
	</div>
	<!--  @end Form -->
</div>
	<jsp:include page="footer.jspf" />

</body>
</html>