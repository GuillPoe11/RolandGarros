<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros</title>
<meta name="description" content="">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<jsp:include page="../head.jspf" />
</head>
<body>


	<%@include file="../menu.jspf"%>

	<div class="central-main-container row">



		<!-- Form -->
		<div class="container-form background col-md-offset-1 col-md-10 clear">
			<h3>Choisissez le type de matchs à planifier</h3>
			<h4 class="<s:property value="typeMsgForm" />">
				<s:property value="msgForm" />
			</h4>

			<s:form id="contact" action="PlanifierMatch" theme="simple">

				<s:submit cssClass="btn btn-primary" method="choixMatchSimple"
					value="Match simple"></s:submit>
				<s:submit cssClass="btn btn-primary" method="choixMatchEquipe"
					value="Match en équipe"></s:submit>

			</s:form>

		</div>
		<div style="height: 20px; clear: both;"></div>

		<!--  @end Form -->
	</div>
	<jsp:include page="../footer.jspf" />

</body>
</html>