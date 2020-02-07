<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Gestion de Patrimoine</title>
<link type="text/css" rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style-patrimoine.css" />
</head>
<body>
	
	<header>
		<nav>
			<ul>
			  <li><a href="${pageContext.request.contextPath}/">Accueil</a></li>
			  <li><a href="${pageContext.request.contextPath}/region/list">Liste des régions</a></li>
			  <li><a href="${pageContext.request.contextPath}/region/showAddRegionForm">Ajouter une région</a></li>
			  <li><a href="${pageContext.request.contextPath}/monument/showAddForm">Ajouter un monument</a></li>
			</ul>
		</nav>
	</header>
	
	<div id="wrraper">
		<div id="header">
			<h2> Gestion de Patrimoine</h2>
		</div>
	</div>
	
	<div id="caontainer">
	
		<h3>Ajouter une région</h3>
		
		<i>Remplir la formulaire. Asterisk (*) ça veut dire obligatoire.</i>
		
		<form:form action="addRegion" modelAttribute="region" method="POST">
			
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>name(*):</label></td>
						<td>
							<form:input path="name"/>
							<form:errors path="name" cssClass="error"/><br/><br/>
						</td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="ajouter" class="save"/></td>
					</tr>
					
				</tbody>
			</table>
						
		</form:form>
		
		<br>
		
		<div style="clear; both;"></div>
		
	
	</div>
	
</body>
</html>