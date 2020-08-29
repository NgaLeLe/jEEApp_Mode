<!doctype html>
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/login.css">
</head>

<body class="container row justify-content-center">
	<div class="col-6 aligne-center">
		<img src="/images/logo.png" alt="" srcset="">
	</div>
	<div class="col-6 justify-content-center">
		<div class="alert alert-danger" role="alert">ESPACE D'ADMIN</div>
		<h1>Bonjour ${email} !!</h1>

		<div>
			<form method="post" action="logout">
				<a href="#" class="btn btn-primary">Continue</a>
				<button type="submit" name="btnDeconnect" class="btn btn-primary">Deconnecter</button>
			</form>
		</div>
	</div>

</body>

</html>