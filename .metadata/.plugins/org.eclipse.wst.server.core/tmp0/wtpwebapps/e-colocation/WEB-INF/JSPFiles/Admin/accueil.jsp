<c:if test="${ empty sessionScope.admin}">
		<jsp:forward page="../Accueil/accueil.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
	<!--#########################  Head inclusion  ###################################-->
	
        				<c:import url="../include/assets/head.jsp"/>
        		
    <!--##############################################################################-->
  	<title> Dashbord  </title>
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
          <div class="row">
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-warning card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">content_copy</i>
                  </div>
                  <p class="card-category">Demandes</p>
                  <h3 class="card-title">50
                  </h3>
                </div>
                <div class="card-footer">
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-success card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">store</i>
                  </div>
                  <p class="card-category">Proprietes</p>
                  <h3 class="card-title">34</h3>
                </div>
                <div class="card-footer">
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-danger card-header-icon">
                  <div class="card-icon">
                    <i class="material-icons">info_outline</i>
                  </div>
                  <p class="card-category">Reclamation</p>
                  <h3 class="card-title">10</h3>
                </div>
                <div class="card-footer">
                </div>
              </div>
            </div>
            <div class="col-lg-3 col-md-6 col-sm-6">
              <div class="card card-stats">
                <div class="card-header card-header-info card-header-icon">
                  <div class="card-icon">
                    <i class="fa fa-twitter"></i>
                  </div>
                  <p class="card-category">Messages</p>
                  <h3 class="card-title">17</h3>
                </div>
                <div class="card-footer">
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-warning">
                  <h4 class="card-title ">Mes Demandes</h4>
                  <p class="card-category">Vous pouvez consulter/modifier/supprimer vos annonces</p>
                </div>
                <div class="card-body">
                  <button class="btn btn-success pull-right">Ajouter</button>
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
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-success">
                  <h4 class="card-title ">Mes propriete</h4>
                  <p class="card-category">Vous pouvez consulter/modifier/supprimer vos annonces</p>
                </div>
                <div class="card-body">
                  <button class="btn btn-success pull-right">Ajouter</button>
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
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-danger">
                  <h4 class="card-title ">Mes reclamation</h4>
                  <p class="card-category">Vous pouvez consulter/modifier/supprimer vos annonces</p>
                </div>
                <div class="card-body">
                  <button class="btn btn-success pull-right">Ajouter</button>
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
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-info">
                  <h4 class="card-title ">Mes messages</h4>
                  <p class="card-category">Vous pouvez consulter/modifier/supprimer vos annonces</p>
                </div>
                <div class="card-body">
                  <button class="btn btn-success pull-right">Ajouter</button>
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
	
        				<c:import url="../include/assets/plugin.jsp"/>
        		
    <!--##############################################################################-->
    
    <!--#########################  JS lib inclusion  ###################################-->
	
        				<c:import url="../include/assets/js.jsp"/>
        		
    <!--##############################################################################-->
</body>

</html>
