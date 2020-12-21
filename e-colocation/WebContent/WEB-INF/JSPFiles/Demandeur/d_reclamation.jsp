<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Demandeur | <small>Reclamation</small></h1>
	
	<button onClick="btnForm()">Faire une reclamation</button>
	 <!-- Visualiser les reclamation -->
	 <table border="1">
			<caption>Consulter les reclamations</caption>
			<tr>
				<th>Propriete</th>
				<th>type reclamation</th>
				<th>Description</th>
				<th>Date reclamation</th>
			</tr>
			<c:forEach var="reclamation" items="${reclamations}">
			<tr>
				<td><c:out value="${reclamation.address}" /></td>
				<td><c:out value="${reclamation.type}" /></td>
				<td><c:out value="${reclamation.reclamation}" /></td>
				<td><c:out value="${reclamation.date}" /></td>
			</tr>
		</c:forEach>
	</table>
	<br><br><br><br>
	<div id="formFaireReclamation">
		<fieldset>
		<form action="ReclamationServlet" method="post">
			<table border="1">
				<caption>Choisissez une propriete</caption>
				<tr>
					<th>#</th>
					<th>Adresse</th>
					<th>Ville</th>
					<th>Superficie</th>
					<th>Type</th>
					<th>Prix</th>
					<th>Nombre Maximum</th>
				</tr>
				<c:forEach var="propriete" items="${proprietes}">
				<tr>
					<td><input type="radio" name="id_pro" value="${propriete.id}"></td>
					<td><c:out value="${propriete.addresse}" /></td>
					<td><c:out value="${propriete.ville}" /></td>
					<td><c:out value="${propriete.superficie}" /></td>
					<td><c:out value="${propriete.type}" /></td>
					<td><c:out value="${propriete.prix}" /></td>
					<td><c:out value="${propriete.nbMax}" /></td>
				</tr>
			</c:forEach>
			</table>
			Type de reclamation<br>
			<select name="type">
						<option value="">Choisissez...</option>
						<option value="type 1">type 1</option>
						<option value="type 2">type 2</option>
						<option value="type 3">type 3</option>
			</select><br>
			Description de la reclamation<br>
			<input type="text" name="reclamation"><br>
			<input type="submit" value="Reclamer">
		</form>
		</fieldset>
	</div>
	<script src="presentation/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
		    	$("#formFaireReclamation").hide();
		});
		
		function btnForm(){
			$("#formFaireReclamation").toggle();
		}
	</script>

</body>
</html>