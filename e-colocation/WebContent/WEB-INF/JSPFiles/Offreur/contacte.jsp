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
                    <div class="card">
                        <div class="card-header card-header-primary">
                            <h3 class="card-title">Nouveaux messages</h3>
                            <p class="card-category">Vous trouverez ici l'ensemble des messages envoyes par les differnets Demandeurs
                            </p>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <a href="#ajouterMessage" class="btn btn-success pull-right">Nouveau message</a>
                                    <a href="#mesMessages" class="btn btn-warning pull-right">Mes messages</a>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <c:forEach var="msg" items="${msgRecus}">
                                        <div class="alert alert-info">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <i class="material-icons">close</i>
                                            </button>
                                            <span><b> ${msg.nomSender} ${msg.prenomSender} | <small> ${msg.date}</small></b><br>${msg.message} </span>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="card" id="mesMessages">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title ">Mes messages</h4>
                            <p class="card-category">Vous pouvez Consulter/Ajouter/Supprimer vos messages</p>
                        </div>
                        <div class="card-body">
                            <a class="btn btn-success pull-right" href="#ajouterMessage">Nouveau message</a>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead class=" text-primary">
                                        <th>
                                            Numero
                                        </th>
                                        <th>
                                            Nom Prenom
                                        </th>
                                        <th>
                                            Date
                                        </th>
                                        <th>
                                            Message
                                        </th>
                                        <th class="text-danger">Supprimer</th>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="msg" items="${msgEnvoyes}">
                                            <tr>
                                                <td>${msg.id}</td>
                                                <td>${msg.nomSender} ${msg.prenomSender}</td>
                                                <td>${msg.date}</td>
                                                <td>${msg.message}</td>
                                                <td>
                                                    <button class="btn btn-danger">Supprimer</button>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="card" id="ajouterMessage">
                        <div class="card-header card-header-primary">
                            <h4 class="card-title">Envoyez un message</h4>
                            <p class="card-category">Vous devez remplir tous les champs</p>
                        </div>
                        <div class="card-body">
                            <div id="success"></div>
							<div class="row">
								<div class="col-md-4"></div>
                            <div class="col-md-4">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <thead>
                                            <th>#</th>
                                            <th>Prenom</th>
                                            <th>Nom</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="receiver" items="${receivers}">
                                                <tr>
                                                    <td>
                                                    	<div class="form-check">
							                                <label class="form-check-label">
								                                <input class="form-check-input" type="radio" value="${receiver.id}" name="id_receiver">
								                                <span class="form-check-sign">
								                                	<span class="check"></span>
								                                </span>
							                                </label>
						                             	</div>
                                                    </td>
                                                    <td>
                                                        <c:out value="${receiver.nom}" />
                                                    </td>
                                                    <td>
                                                        <c:out value="${receiver.prenom}" />
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="form-group">
                            		<label class=""> Votre message.</label>
                            		<textarea class="form-control" rows="5" id="message"></textarea>
                         		 </div>

                                <button class="btn btn-success pull-right" onClick="envoyerMessage()">Envoyer</button>

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

    <!-- <c:import url="../include/assets/plugin.jsp"/> -->

    <!--##############################################################################-->

    <!--#########################  JS lib inclusion  ###################################-->

    <c:import url="../include/assets/js.jsp" />

    <!--##############################################################################-->

    <script type="text/javascript">
	
	function envoyerMessage(){
		var form="envoyer";
		var id_receiver = $("input[name='id_receiver']").val();
		var message = $("#message").val();
		$.post("O_Contacte",{
			form: form,
			id_receiver: id_receiver,
			message: message
			
		},function(data, status) {
			$("#success").html('<div class="alert alert-success"><button type="button" class="close" data-dismiss="alert" aria-label="Close">'+
			'<i class="material-icons">close</i></button><span><b> Success - </b> l"opertation c"est bien deroulee</span></div>');
			location.reload();	
		});
	}
	

	</script>
</body>

</html>