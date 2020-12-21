<c:if test="${ empty sessionScope.proprietaire}">
		<jsp:forward page="../Accueil/accueil.jsp"/>
</c:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
<h1>Upload File Form</h1>
 <form action="Upload" enctype="multipart/form-data" method="post">
 <input type="text" name="name1">
 <input type="text" name="name1">
 <input type="text" name="name1">
 <input type="text" name="name1">
 <input type="file" name="fichier1">
 <input type="file" name="fichier2">
 <input type="file" name="fichier3">
 <input type="submit" value="upload" />
 </form>
</center>

</body>
</html>