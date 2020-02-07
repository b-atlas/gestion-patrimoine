<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	
	<div id="container">
	
		<h3>Liste des monuments de ${region.name}</h3>
	
		<input type="button" value="Ajouter un monument"
					onclick="window.location.href='showAddForm'; return false;"
					class="add-button" />
		
		<table>
					<tr>
						<th>name</th>
						<th>age (an)</th>
						<th>surface (m^2)</th>
						<th>Action</th>
					</tr>
					
					<!-- Loop over our monuments list -->
					<c:forEach var="monument" items="${monuments}">
						
						<!-- Create an update link variable -->
						<c:url var = "updateLink" value="/monument/showFormForUpdate">
							<c:param name="monumentId">${monument.id}</c:param>
						</c:url>
						
						<!-- Create a delete link variable -->
						<c:url var = "deleteLink" value="/monument/deleteMonument">
							<c:param name="monumentId">${monument.id}</c:param>
						</c:url>
					
						<tr>
							<td>${monument.name}</td>
							<td>${monument.age}</td>
							<td>${monument.surface}</td>
							
							<td>
								<a href="${deleteLink}" onclick="if (!(confirm('Etes vous sure de vouloir supprimer cet monument?'))) return false">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
	
				</table>
		
		<br>
	
	</div>
</body>
</html>