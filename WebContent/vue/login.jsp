<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="style/login.css">
</head>

<body class="container row justify-content-center">
    <div class="col-4 aligne-center">
        <img src="images/logo.png" alt="" srcset="">
    </div>
    <div class="col-8 justify-content-center">
        <div class="mt-5">
        	<a href="vue/loginAdmin.jsp">Venez-vous la page d'Admin</a>
        </div>
        
        <form action="Convertir" method="post">
            <div class="form-group  ">
                <label class="control-label" for="inputNom">Nom </label> <input class="form-control " type="text" name="nom" id="inputNom" required>
            </div>
            <div class="form-group  ">
                <label class="control-label " for="inputPrenom">Email </label> <input class="form-control " type=" text " name="email" id="inputPrenom " placeholder="Email@yahoo.com " required>
            </div>
            <div class="form-group ">
                <label class=" control-label  " for="inputPassword ">Password
				</label> <input type="password" class="form-control " id="inputPassword " name="password" required>
            </div>
            <div>
                <button class="btn btn-danger btn-medium" type="submit">Se
					connecter</button>
            </div>
        </form>
        <div>
            <a href="#">Mot de passe oublie</a>
        </div>
        <div class="divider">
            <hr class="bd_divider">
        </div>
        <div>
            <form action="" method="post">
                <button class="btn btn-primary " type="submit ">S'identifier</button>
            </form>
        </div>

    </div>

</body>

</html>