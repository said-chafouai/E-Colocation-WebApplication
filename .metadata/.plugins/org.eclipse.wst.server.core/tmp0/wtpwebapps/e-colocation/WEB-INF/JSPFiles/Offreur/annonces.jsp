<c:if test="${ empty sessionScope.proprietaire}">
		<jsp:forward page="../Accueil/accueil.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
    <!--#########################  Head inclusion  ###################################-->

    <c:import url="../include/assets/head.jsp" />

    <!--##############################################################################-->
    <title>
        Material Dashboard by Creative Tim
    </title>
</head>

<body class="">
    <div class="wrapper ">
        <!--#########################  Sidebar inclusion  ###################################-->

        <c:import url="../include/assets/sidebarOffreur.jsp" />

        <!--##############################################################################-->
        <div class="main-panel">
            <!--#########################  Navbar inclusion  ###################################-->

            <c:import url="../include/assets/navbar.jsp" />

            <!--##############################################################################-->
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-primary">
                                    <h4 class="card-title">Annonces</h4>
                                    <p class="card-category">Consulter vous annonces</p>
                                </div>
                                <div class="card-body">
                                    <a class="btn btn-success pull-right" href="#ajouterAnnonce">Ajouter une annonce</a>
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <thead class=" text-primary">
                                                <th>
                                                    ID
                                                </th>
                                                <th>
                                                    Name
                                                </th>
                                                <th>
                                                    Country
                                                </th>
                                                <th>
                                                    City
                                                </th>
                                                <th>
                                                    Salary
                                                </th>
                                                <th class="text-warning">Modifier</th>
                                                <th class="text-danger">Supprimer</th>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="propriete" items="${proprietes}">
                                                    <tr>
                                                        <td>
                                                            ${propriete.addresse}
                                                        </td>
                                                        <td>
                                                        ${propriete.ville}
                                                        </td>

                                                        <td>
                                                        ${propriete.superficie}
                                                        </td>
                                                        <td>
                                                        ${propriete.type}
                                                        </td>
                                                        <td>
                                                        ${propriete.prix}
                                                        </td>
                                                        <td>
                                                            <button class="btn btn-warning" onClick="modifierAnnonce( ${propriete.id})">Modifier</button>
                                                        </td>
                                                        <td>
                                                            <button class="btn btn-danger" onClick="suprimerAnnonce(${propriete.id})">Supprimer</button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row" id="ajouterAnnonce">
                        <div class="col-md-8">
                            <div class="card">
                                <div class="card-header card-header-primary">
                                    <h4 class="card-title">Ajouter une annonces</h4>
                                    <p class="card-category">Vous devez remplir tous les champs</p>
                                </div>
                                <div class="card-body">
                                  	<form  action="O_Annonces" enctype="multipart/form-data"  method="post">
                                  
	                                    <div class="form-group">
	                                        <input type="text" name="adresse" placeholder="Adresse" class="form-control" required>
	                                    </div>
										
	                                    <div class="form-group">
	                                        <input type="text" name="ville" placeholder="Ville" class="form-control" required>
	                                    </div>
	
	                                    <div class="form-group">
	                                        <input type="number" name="superficie" placeholder="superficier" class="form-control" required>
	                                    </div>
	
	                                    <div class="form-group">
	                                        <select name="type" class="form-control" required>
	                                            <option>Choisissez un type de propriete ...</option>
	                                            <option>Appartement</option>
	                                            <option>Studio</option>
	                                            <option>Maison</option>
	                                        </select>
	                                    </div>
	                                    <div class="form-group">
	                                        <input type="number" class="form-control" placeholder="prix" name="prix" required>
	                                    </div>
	                                    <div class="form-group">
	                                        <input type="number" class="form-control" placeholder="Nombre maximum de personne" name="nbMax" required>
	                                    </div>
	                                    <div class="form-group">
	                                        <input type="number" class="form-control" placeholder="Nombre souhite" name="nbSouhaite" required>
	                                    </div>
	                                    <div class="form-group">
	                                        <input type="date" class="form-control" placeholder="date de disponible" name="disponibilite" required>
	                                    </div>
	                                   
	                                    	Photo 1
	                                        <input type="file" class="" name="photo1" ><br>
	                                        Photo 2
	                                        <input type="file" class=""  name="photo2" ><br>
	                                        Photo 3
	                                        <input type="file" class="" name="photo3" >
	                                    <div class="form-group">
	                                        <input type="submit" class="btn btn-primary pull-right" value="Ajouter">
	                                    </div>
                                	</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--#########################  footer inclusion  ###################################-->

            <c:import url="../include/assets/footer.jsp" />

            <!--##############################################################################-->
        </div>
    </div>
    <!--#########################  Plugin inclusion  ###################################-->

    <!-- <c:import url="../include/assets/plugin.jsp"/>  -->

    <!--##############################################################################-->

    <!--#########################  JS lib inclusion  ###################################-->

    <c:import url="../include/assets/js.jsp" />

    <!--##############################################################################-->


</body>

</html>