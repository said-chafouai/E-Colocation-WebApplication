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
                  <h4 class="card-title">Bienvenue dans la gestion de forum</h4>
                  <p class="card-category">Vous pouvez supprimer les publication et les reponses</p>
                </div>
                <div class="card-body">
                <div id="success"></div>
                	<c:forEach var="publication" items="${publications}">
                		<div class="row">
		                	<div class="col-md-12">
		                		<div class="alert alert-info">
		                			<span><b> ${publication.nom} ${publication.prenom} | <small> ${publication.datePub}</small></b><br>${publication.pub} </span>
								</div>
								<button class="btn btn-danger pull-right" onclick="supprimerPub(${publication.id})">Supprimer</button>
								<button class="btn btn-default pull-right" onclick="voirReponse(${publication.id})">Voir reponses</button>
                                
                                <!-- div pour les reponses pour chaque pub il ya une div  -->
		                		<div class="col-md-6" id="reponse${publication.id}">
		                		<div id=success></div>									
		                		</div>
		                		
		                	</div>
	                	</div>
					</c:forEach>                
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

	function supprimerPub(id) {
		var form = "supprimerPub";
	    $.post("A_Forum", {
	    	id_pub: id,
	    	form: form
	    }, function (data, status) {
	    	$("#success").html('<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> operation reussit</span></div>');
			location.reload();
	    });
	}
	
	function supprimerRep(id) {
		var form = "supprimerRep";
	    $.post("A_Forum", {
	    	form: form,
	    	id_rep: id
	    }, function (data, status) {
	    	$("#success").html('<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> operation reussit</span></div>');
			location.reload();
	    });
	}
	
	function voirReponse(id) {
		var form = "afficherRep";
	    $.post("A_Forum", {
	    	id_pub: id,
	    	form: form
	    }, function (data, status) {
	        $("#reponse"+id).html(data);
	    });
	}
	
	
	</script>
</body>

</html>

