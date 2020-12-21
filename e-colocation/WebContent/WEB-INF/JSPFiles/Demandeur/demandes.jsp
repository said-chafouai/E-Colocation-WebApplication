<c:if test="${ empty sessionScope.demandeur}">
		<jsp:forward page="../Accueil/accueil.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
  <!--#########################  Head inclusion  ###################################-->
	
        				<c:import url="../include/assets/head.jsp"/>
        		
    <!--##############################################################################-->
  <title>
    E-Colocation
  </title>
</head>

<body class="">
  <div class="wrapper ">
  <!--#########################  Sidebar inclusion  ###################################-->
	
        				<c:import url="../include/assets/sidebarDemandeur.jsp"/>
        		
    <!--##############################################################################-->
    <div class="main-panel">
     <!--#########################  Navbar inclusion  ###################################-->
	
        				<c:import url="../include/assets/navbar.jsp"/>
        		
    <!--##############################################################################-->
      <div class="content">
        <div class="container-fluid">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Consulter vos demandes</h4>
                  <p class="card-category">Vous pouvez voir l'etat de votre demandes</p>
                </div>
                <div class="card-body">
                	<div class="table-responsive">
                    <table class="table table-hover">
                      <thead class=" text-primary">
                        <th>date</th>
						<th>id_prop</th>
						<th>statut</th>
                      </thead>
                      <tbody>
                      <c:forEach var="demande" items="${demandesAttente}">
						<tr>
							<td>${demande.date}</td>
							<td>${demande.id_prop}</td>
							<td><font color="red">En attente</font></td>
						</tr>
					</c:forEach>
                      </tbody>
                    </table>
                  </div>
          		</div>
          	</div>
          	
          	<div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Consulter vos demandes Valider</h4>
                  <p class="card-category">Vous pouvez voir les demandes validees</p>
                </div>
                <div class="card-body">
                	<div class="table-responsive">
                    <table class="table table-hover">
                      <thead class=" text-primary">
                        <th>date</th>
						<th>id_prop</th>
						<th>statut</th>
                      </thead>
                      <tbody>
                      <c:forEach var="demande" items="${demandesValidee}">
						<tr>
							<td>${demande.date}</td>
							<td>${demande.id_prop}</td>
							<td><font color="green">${demande.statut}</font></td>
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
    <!--#########################  JS lib inclusion  ###################################-->
	
        				<c:import url="../include/assets/js.jsp"/>
        		
    <!--##############################################################################-->
    
    
	<script type="text/javascript">


	</script>
</body>

</html>

