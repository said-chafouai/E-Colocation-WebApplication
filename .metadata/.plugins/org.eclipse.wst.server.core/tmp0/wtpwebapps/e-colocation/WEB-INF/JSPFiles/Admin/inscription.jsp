<c:if test="${ empty sessionScope.admin}">
		<jsp:forward page="../Accueil/accueil.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
  <!--#########################  Head inclusion  ###################################-->
	
        				<c:import url="../include/assets/head.jsp"/>
        		
    <!--##############################################################################-->
  <title>
    Material Dashboard by Creative Tim
  </title>
</head>

<body class="">
  <div class="wrapper ">
  <!--#########################  Sidebar inclusion  ###################################-->
	
        				<c:import url="../include/assets/sidebarAdmin.jsp"/>
        		
    <!--##############################################################################-->
    <div class="main-panel">
     <!--#########################  Navbar inclusion  ###################################-->
	
        				<c:import url="../include/assets/navbar.jsp"/>
        		
    <!--##############################################################################-->
      <div class="content">
        <div class="container-fluid">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Demandes d'inscription</h4>
                  <p class="card-category">Vous pouvez valider ou rejeter les demandes d'inscription</p>
                </div>
                <div class="card-body">
                <div id="success"></div>
            <div class="table-responsive">
                    <table class="table table-hover">
                      <thead class=" text-primary">
                        <th>
                          ID
                        </th>
                        <th>
                          Nom
                        </th>
                        <th>
                          Prenom
                        </th>
                        <th>
                          Adresse
                        </th>
                        <th>
                          Ville
                        </th>
                        <th>
                          Description
                        </th>
                        <th class="text-warning">Valider</th>
                        <th class="text-danger">Rejeter</th>
                      </thead>
                      <tbody>
                      <c:forEach var="demande" items="${demandes}">
                                        <tr>
                                            <td>${demande.id}</td>
                                            <td>${demande.nom}</td>
                                             
                                              <td>${demande.prenom}</td>
                                              <td>${demande.adresse}</td>
                                              <td>${demande.ville}</td>
                                              <td>${demande.description}</td>
                                              <td><button class="btn btn-warning" onClick="valider(${demande.id})">Valider</button></td>
                                              <td><button class="btn btn-danger" onClick="rejeter(${demande.id})">Rejeter</button></td>
                                        </tr>
                                        
					</c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
        </div>
      </div>
        <!--#########################  footer inclusion  ###################################-->
	
        				<c:import url="../include/assets/footer.jsp"/>
        		
    <!--##############################################################################-->
    </div>
  </div>
  <!--#########################  Plugin inclusion  ###################################-->
	
        		<!-- <c:import url="../include/assets/plugin.jsp"/>  -->		
        		
    <!--##############################################################################-->
    
    <!--#########################  JS lib inclusion  ###################################-->
	
        				<c:import url="../include/assets/js.jsp"/>
        		
    <!--##############################################################################-->
    
    
	<script type="text/javascript">
	
	function valider(id){
		var form="valider";
		var id = id;
		$.post("A_Inscription",{
			form: form,
			id: id
		},function(data, status) {
			$("#success").html('<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> Demande acceptee </span></div>');
			location.reload();
		});
	}
	
	function rejeter(id){
		var form="rejeter";
		var id = id;
		$.post("A_Inscription",{
			form: form,
			id: id
		},function(data, status) {
			$("#success").html('<div class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> Demande refusee</span></div>');
			location.reload();
		});
	}
	

	</script>
</body>

</html>

