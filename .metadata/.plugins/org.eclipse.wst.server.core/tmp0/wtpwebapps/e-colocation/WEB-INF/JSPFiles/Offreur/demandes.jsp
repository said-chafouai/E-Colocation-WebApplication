<c:if test="${ empty sessionScope.proprietaire}">
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
	
        				<c:import url="../include/assets/sidebarOffreur.jsp"/>
        		
    <!--##############################################################################-->
    <div class="main-panel">
     <!--#########################  Navbar inclusion  ###################################-->
	
        				<c:import url="../include/assets/navbar.jsp"/>
        		
    <!--##############################################################################-->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title ">Demandes</h4>
                  <p class="card-category">Nouvelles demandes sur vous annonces</p>
                </div>
                
                <div class="card-body">
                <div id="success">
                </div>
                  <div class="table-responsive">
                    <table class="table">
                      <thead class=" text-primary">
                        <th>Numero</th>
                        <th>Date</th>
                        <th>Numero demandeur</th>
                        <th>Numero d'annonce</th>
                        <th>Statut</th>
                        <th class="text-primary">Voir profil</th>
                        <th class="text-success">Valider</th>
                        <th class="text-danger">Rejeter</th>
                      </thead>
                      <tbody>
                      <c:forEach var="demande" items="${demandes}">
			<tr>
				<td>${demande.id}</td>
				<td>${demande.date}</td>
				<td>${demande.id_user}</td>
				<td>${demande.id_prop}</td>
				<td><font color="red">${demande.statut }</font></td>
				<td><button class="btn btn-primary">Voir Profil</button></td>
				<td><button class="btn btn-success" onClick="validerDemande(${demande.id})">Valider</button></td>
				<td><button class="btn btn-danger" onClick="rejeterDemande(${demande.id})">Rjeter</button></td>
			</tr>
		</c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
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
	
	function validerDemande(id){
		var form="valider";
		var id = id
		$.post("O_Demandes",{
			form: form,
			id: id
		},function(data, status) {
			$("#success").html('<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> This is a regular notification made with ".alert-success"</span></div>');
			location.reload();
		});
	}
	function rejeterDemande(id){
		var form="rejeter";
		var id = id
		$.post("O_Demandes",{
			form: form,
			id: id
		},function(data, status) {
			$("#success").html('<div class="alert alert-danger"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> This is a regular notification made with ".alert-success"</span></div>');
			location.reload();
		});
	}
	

	</script>
</body>

</html>


