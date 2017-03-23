<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<title>Roland Garros</title>
<meta name="description" content="">

<jsp:include page="head.jspf" />
</head>
<body>

	<jsp:include page="menu.jspf" />

<div class="central-main-container row">
<h3>Planification des matchs</h3>
	<div class="container-liste background col-md-4 col-md-offset-1">
			<table class="table table-bordered table-hover">
				<tr>
					<td>Court</td>
					<td>Joueur Simple</td>
					<td></td>
					<td>Arbitre</td>
					<td>Tournoi</td>
					<td>Date</td>
					<td>Durée</td>
					<td>Equipes Doubles</td>
					<td></td>
					<td>Score </td>
					<td></td>
				</tr>
				<s:iterator status="status" value="lstMatchs">
					<tr>
						<td>
						(<s:property value="#status.index" />)
						<s:property
 								value="court.nomCourt" /></td> 
 						<td><s:property value="joueur1.nomJoueur" /></td> 
 						<td><s:property value="joueur2.nomJoueur" /></td> 
 						<td><s:property value="arbitre.nomArbitre" /></td> 
 						<td><s:property value="sousTournoi.nomTournoi" /></td> 
 						<td><s:property value="dateMatch" /></td> 
 						<td><s:property value="dureeMatch" /></td> 
 						<td><s:property value="equipe1.joueur1.nomJoueur" /></td> 
 						<td><s:property value="equipe1.joueur2.nomJoueur" /></td> 
 						<td><s:property value="equipe2.joueur1.nomJoueur" /></td> 
 						<td><s:property value="equipe2.joueur2.nomJoueur" /></td>
 						<td><s:property value="score1" /></td> 
 						<td><s:property value="score2" /></td>

					</tr>

				</s:iterator>
			</table>

		</div>
		
		
	<!-- Form -->
	<div class="container-form background col-md-5 col-md-offset-1">
	
	
	
	
	
		<s:form id="contact" action="PlanifierMatch">
		
			<fieldset>
			<s:select label="Sélectionnez une equipe"
								headerKey="-1" headerValue="--------" list="mapEquipes"
								listKey="key" listValue="value" name="idEquipe1" />
			</fieldset>
			
			<s:select label="Sélectionnez une equipe"
								headerKey="-1" headerValue="--------" list="mapEquipes"
								listKey="key" listValue="value" name="idEquipe2" />
			</fieldset>
		
			<fieldset>
			<s:select label="Sélectionnez un arbitre"
								headerKey="-1" headerValue="--------" list="mapArbitres"
								listKey="key" listValue="value" name="idArbitre" />
			</fieldset>
			<fieldset>
			<s:select label="Sélectionnez un court"
								headerKey="-1" headerValue="--------" list="mapCourts"
								listKey="key" listValue="value" name="idCourt" />
			</fieldset>
			<fieldset>
			<s:select label="Sélectionnez un Tournoi"
								headerKey="-1" headerValue="--------" list="mapSousTournois"
								listKey="key" listValue="value" name="idSousTournoi" />
			</fieldset>
		
		
			<fieldset>
			<s:select label="Sélectionnez un joueur"
								headerKey="-1" headerValue="--------" list="mapJoueurs"
								listKey="key" listValue="value" name="idJoueur1" />
			</fieldset>
			<fieldset>
			<s:select label="Sélectionnez un joueur"
								headerKey="-1" headerValue="--------" list="mapJoueurs"
								listKey="key" listValue="value" name="idJoueur2" />
			</fieldset>
			<fieldset>
				<s:textfield 
					name="match.dateMatch" label="Date du match" ></s:textfield>
			</fieldset>
			<fieldset>
				<s:textfield 
					name="match.dureeMatch" label="Durée du match" ></s:textfield>
			</fieldset>
			<fieldset>
				<s:textfield 
					name="match.score1" label="Score du premier joueur"></s:textfield>
			</fieldset>
			<fieldset>
				<s:textfield 
					name="match.score2" label="Score du deuxième joueur"></s:textfield>
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