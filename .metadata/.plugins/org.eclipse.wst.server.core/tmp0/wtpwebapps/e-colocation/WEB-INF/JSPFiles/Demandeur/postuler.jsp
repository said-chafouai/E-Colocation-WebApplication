<c:if test="${ empty sessionScope.demandeur}">
		<jsp:forward page="../Accueil/accueil.jsp"/>
</c:if>
<!DOCTYPE html>
<html lang="en">

<head>
    <!--#########################  Head inclusion  ###################################-->

    <c:import url="../include/assets/head.jsp" />

    <!--##############################################################################-->
    <title>
        E-Colocation
    </title>
</head>

<body class="">
    <div class="wrapper ">
        <!--#########################  Sidebar inclusion  ###################################-->

        <c:import url="../include/assets/sidebarDemandeur.jsp" />

        <!--##############################################################################-->
        <div class="main-panel">
            <!--#########################  Navbar inclusion  ###################################-->

            <c:import url="../include/assets/navbar.jsp" />

            <!--##############################################################################-->
            <div class="content">
                <div class="container-fluid">
                    <div class="card">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title">Annonces</h4>
                            <p class="card-category">Postuler sur l'annonce qui vous convient</p>
                        </div>
                        <div class="card-body">
                        <c:forEach var="propriete" items="${proprietes}">
                            <!-- Debut de carousel -->
                            <div id="carouselExampleIndicators${propriete.id}" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselExampleIndicators${propriete.id}" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselExampleIndicators${propriete.id}" data-slide-to="1"></li>
                                    <li data-target="#carouselExampleIndicators${propriete.id}" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">                                  	
                                  	<c:forEach var="image" items="${propriete.images}" varStatus="status">
                                	<div class="carousel-item<c:if test="${status.count==1}"><c:out value=" active"/></c:if>">
                                        <img class="d-block w-100" src="presentation/assets/img/maison/${image}" height="300" alt="">
                                    </div>
                                    </c:forEach> 
                                </div>
                                <a class="carousel-control-prev" href="#carouselExampleIndicators${propriete.id}" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleIndicators${propriete.id}" role="button" data-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                            <!-- /Carousel -->
                            <br>
                            <div class="row">
								<div class="col-md-6">
								<fieldset><legend>Informations sur la maison</legend>
									Adresse : <b> ${propriete.addresse}</b><br>
									Superficie : <b> ${propriete.superficie} cm<sup>2</sup></b> <br>
									Type : <b> ${propriete.type}</b><br>
									Prix : <b> ${propriete.prix}</b><br>
									Nombre maximum de peronnes: <b> ${propriete.nbMax}</b><br>
									Date de disponiblite : <b> ${propriete.disponibilite}</b><br>
								</fieldset>
								<div id="success${propriete.id}"></div>

								</div>    
								<div class="col-md-6">
								<fieldset><legend>Exigences de proprietaire	</legend>
									Age :<br>
									Fumeur:<br>
									Animaux domestiques :<br>
									Bruit :<br>
									Niveau de proprete:<br>
									Religion :<br>
								</fieldset>
								<button class="btn btn-warning pull-right" onClick="postuler(${propriete.id})">Postuler</button>
								</div>
								                        
                            </div>
                           </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <!--#########################  footer inclusion  ###################################-->

            <c:import url="../include/assets/footer.jsp" />

            <!--##############################################################################-->
        </div>
    </div>
    <!--#########################  JS lib inclusion  ###################################-->

    <c:import url="../include/assets/js.jsp" />

    <!--##############################################################################-->

    <script type="text/javascript">
    
    function postuler(id){
     	$.post("D_Postuler",{
     		id: id
     	},function(data,statut){
     		$("#success"+id).html('<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> Operation reussit</span></div>');

     	});
    }
    </script>
</body>

</html>