<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<body>
	<h2>Hello World!</h2>
	<p>Guigui t'es le meilleur !</p>
	<p>Nop il pompe sur Arnaud</p>
	<p>${nom}</p>
	<s:form action="Test">
		<fieldset>
			<s:submit method="test" value="Test" theme="simple" />
		</fieldset>
		<fieldset>
			<s:submit method="ajout" value="Ajout" theme="simple" />
		</fieldset>
	</s:form>
</body>
</html>
