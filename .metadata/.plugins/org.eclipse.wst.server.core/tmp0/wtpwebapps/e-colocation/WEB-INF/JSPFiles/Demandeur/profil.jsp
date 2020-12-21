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
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Editer votre Profil</h4>
                  <p class="card-category">Completez votre profil</p>
                </div>
                <div class="card-body">
                <div id="profilSuccess">
                 </div>
                  <div id="profil">
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="">Nom</label>
                          <input type="text" class="form-control" id="nom" value="${user.nom}" disabled>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="">Prenom</label>
                          <input type="text" class="form-control" id="prenom" value="${user.prenom}" disabled>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="">Mot de passe</label>
                          <input type="text" class="form-control" id="mdp"  value="${user.password}">
                        </div>
                      </div>
                      <div class="col-md-6">
                        <div class="form-group">
                          <label class="">Ville</label>
                          <input type="text" class="form-control" id="ville" value="${user.ville}">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label class="">Adresse</label>
                          <input type="text" class="form-control" id="adresse" value="${user.adresse}">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-12">
                        <div class="form-group">
                          <label>Vous etes</label>
                          <div class="form-group">
                            <label class=""> Metez une petites description sur vous.</label>
                            <textarea class="form-control" rows="5" id="description">${user.description}</textarea>
                          </div>
                        </div>
                      </div>
                    </div>
                    <button class="btn btn-primary pull-right" onClick="modifierProfil()">Enregistrez</button>
                    <div class="clearfix"></div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card card-profile">
                <div class="card-avatar">
                  <a href="#pablo">
                    <img class="img" src="presentation/assets/img/faces/said.jpg" />
                  </a>
                </div>
                <div class="card-body">
                  <h6 class="card-category text-gray">Etudiant</h6>
                  <h4 class="card-title">${user.nom} ${user.prenom}</h4>
                  <p class="card-description">
                    ${user.description}
                  </p>
                </div>
              </div>
            </div>
          </div>
        
          <div class="row">
            <div class="col-md-8">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Editer votre exigences</h4>
                  <p class="card-category">Completez votre profil</p>
                </div>
                <div class="card-body">
                  <form id="caracteristiques">
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Age</label>
                          <input type="text" class="form-control" id="age">
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Activite principale</label>
                          <input type="text" class="form-control" id="activite" >
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Religion</label>
                          <input type="email" class="form-control" id="religion">
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Fumeur</label>
                          <div class="form-check">
                                <label class="form-check-label">Oui
                                  <input class="form-check-input" type="radio" value="" name="fumeur">
                                  <span class="form-check-sign">
                                    <span class="check"></span>
                                  </span>
                                </label>
                              </div>
                            <div class="form-check">
                                <label class="form-check-label">Non
                                  <input class="form-check-input" type="radio" value="" name="fumeur">
                                  <span class="form-check-sign">
                                    <span class="check"></span>
                                  </span>
                                </label>
                              </div>
                        </div>
                      </div>
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Vous aimez les animaux domestiques</label>
                          <div class="form-check">
                                <label class="form-check-label">Oui
                                  <input class="form-check-input" type="radio" value="" name="animaux">
                                  <span class="form-check-sign">
                                    <span class="check"></span>
                                  </span>
                                </label>
                              </div>
                            <div class="form-check">
                                <label class="form-check-label">Non
                                  <input class="form-check-input" type="radio" value="" name="animaux">
                                  <span class="form-check-sign">
                                    <span class="check"></span>
                                  </span>
                                </label>
                              </div>
                        </div>
                      </div>
                        <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Experience de colocation</label>
                            <div class="form-check">
                                <label class="form-check-label">Oui
                                  <input class="form-check-input" type="radio" value="" name="exp_colo">
                                  <span class="form-check-sign">
                                    <span class="check"></span>
                                  </span>
                                </label>
                              </div>
                            <div class="form-check">
                                <label class="form-check-label">Non
                                  <input class="form-check-input" type="radio" value="" name="exp_colo">
                                  <span class="form-check-sign">
                                    <span class="check"></span>
                                  </span>
                                </label>
                              </div>
                        </div>
                      </div>
                    </div>
                    <div class="row">
                      <div class="col-md-4">
                        <div class="form-group">
                          <label class="bmd-label-floating">Niveau de proprete note sur 10</label>
                          <input type="text" class="form-control" id="proprete">
                        </div>
                      </div>
                      </div>
                    <button type="submit" class="btn btn-primary pull-right" onClick="modifierExigence()">Enregistrez</button>
                    <div class="clearfix"></div>
                  </form>
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
    <!--#########################  JS lib inclusion  ###################################-->
	
        				<c:import url="../include/assets/js.jsp"/>
        		
    <!--##############################################################################-->
    
    
	<script type="text/javascript">
	
	
	function modifierProfil(){
		var form="modifierProfil";
		var mdp = $("#mdp").val();
		var ville = $("#ville").val();
		var adresse = $("#adresse").val();
		var description = $("#description").val();
		$.post("D_Profil",{
			form: form,
			mdp: mdp,
			ville: ville,
			adresse: adresse,
			description: description
			
		},function(data, status) {
			$("#profilSuccess").html('<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> operation reussit</span></div>');
			location.reload();
		});
	}
	

	</script>
</body>

</html>

