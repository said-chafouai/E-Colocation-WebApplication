<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>
		Demandeur | <small>Faire une recherche</small>
	</h1>
	<form action="FaireRecherche" method="post">
		<table>
			<caption>Rechercher</caption>

      	
      	<tr>
      		<td><label for="prix">Prix </label></td>
      		<td><input type="text" name="prix" /></td>
      	</tr>
      	<tr>
      		<td><label for="superficie">Superficie </label></td>
      		<td><input type="text" name="superficie" /></td>
      	</tr>
      	<tr>
      		<td>Ville </td>		
			<td>	<SELECT name="nom" size="1">
            <OPTION></OPTION>
            <OPTION>casa</OPTION>
            <OPTION>rabat</OPTION>
            <OPTION>agadir</OPTION>
            <OPTION>meknes</OPTION>
            <OPTION>tanger</OPTION>
                </SELECT>

                  </td>
      		
      						
      	</tr>
		<tr>
			<td><input type="submit" value="rechercher"></td>
		</tr>
		
		</table>
		
	</form>
	<c:forEach var="propriete" items="${proprietes}">
			<tr>
			   
				<td><c:out value="${propriete.addresse}" /></td>
				<td><c:out value="${propriete.ville}" /></td>
				<td><c:out value="${propriete.superficie}" /></td>
				<td><c:out value="${propriete.type}" /></td>
				<td><c:out value="${propriete.prix}" /></td>
				<td><c:out value="${propriete.nbMax}" /></td>
				
				
			</tr>
		</c:forEach>
		

</body>
</html>