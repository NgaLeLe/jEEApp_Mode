<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Espace de client</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body class="container row justify-content-center">
	<%
		String nom = (String) request.getAttribute("nom");
	%>
	<div class="col-4 aligne-center">
		<img src="images/logo.png" alt="" srcset="">
	</div>
	<div class="col-8 justify-content-center">
		<h1>Bonjour ${nom}</h1>
		<div class="alert alert-danger" role="alert">Vous avez réussi de
			connecter !!</div>
		<form action="Convertir" method="post">
			<div class="radio ">
				<label class="control-label col-2">Choisir type de convertir</label>
				<label class="radio-inline col-3"><input type="radio"
					name="optTypeArgent" value="EURO" > EURO --> USD </label> <label
					class="radio-inline col-3"><input type="radio"
					name="optTypeArgent" value="USD"> USD --> EURO</label>
			</div>
			<div class="form-group ">
				<label class=" control-label" for="montant">Montant de
					convertir</label> <input type="number" class="form-control "
					id="idMontant " name="montant" required>
			</div>
			<div class="form-group ">
				<label class=" control-label " for="result">Resultat</label> <input
					class="form-control " name="result" type="text"
					value='<%=session.getAttribute("result")%>' readonly="true" />
			</div>
			<div>
				<button class="btn btn-primary btn-medium" type="submit"
					name="btnConvertir">Convertir</button>
				
			</div>
		</form>	
		
		<a href="${pageContext.request.contextPath}/Convertir" class="btn btn-primary">Continue</a>
		<form action="logout" method="post">	
				<button class="btn btn-primary btn-medium" type="button"
					name="btnDeconnecter">Deconnecter</button>
					</form>
				<%
					String error = (String) session.getAttribute("error");
					if (error == "2") {
					out.print("<div class=\"alert alert-warning\" role=\"alert\"> Montant converti est dépasse 100000!</div>");
				}
					if (error == "1") {
						out.print("<div class=\"alert alert-warning\" role=\"alert\"> Il faut saisir type d'argent de convertir !</div>");
					}
				%>
		
		<a href="/hello/">Retour</a>
	</div>
</body>

</html>