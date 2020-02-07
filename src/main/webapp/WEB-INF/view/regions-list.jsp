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
			  <li><a href="${pageContext.request.contextPath}/region/list">Liste des r�gions</a></li>
			  <li><a href="${pageContext.request.contextPath}/region/showAddRegionForm">Ajouter une r�gion</a></li>
			  <li><a href="${pageContext.request.contextPath}/monument/showAddForm">Ajouter un monument</a></li>
			</ul>
		</nav>
	</header>
	
	<div id="container">
	
		<h3>Liste des r�gions</h3>
	
		<input type="button" value="Ajouter r�gion"
					onclick="window.location.href='showAddRegionForm'; return false;"
					class="add-button" />
		
		<table>
					<tr>
						<th>name</th>
						<th>Monuments</th>
						<th>Action</th>
					</tr>
					
					<!-- Loop over our regions list -->
					<c:forEach var="region" items="${regions}">
						
						<!-- Create an display monuments link variable -->
						<c:url var = "displayLink" value="/monument/displayMonuments">
							<c:param name="regionId">${region.id}</c:param>
						</c:url>
						
						<!-- Create an update link variable -->
						<c:url var = "updateLink" value="/region/showFormForUpdate">
							<c:param name="regionId">${region.id}</c:param>
						</c:url>
						
						<!-- Create a delete link variable -->
						<c:url var = "deleteLink" value="/region/deleteRegion">
							<c:param name="regionId">${region.id}</c:param>
						</c:url>
					
						<tr>
							<td>${region.name}</td>
							
							<td><a href="${displayLink}">affciher</a></td>
							
							<td>
								<a href="${updateLink}">Update</a> 
								| 
								<a href="${deleteLink}" onclick="if (!(confirm('Etes vous sure de vouloir supprimer cette r�gion?'))) return false">Supprimer</a>
							</td>
						</tr>
					</c:forEach>
	
				</table>
		
		<br>
			
	
	</div>

</body>
</html>