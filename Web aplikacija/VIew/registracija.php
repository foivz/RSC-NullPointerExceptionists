<?php
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/style-index.css">
</head>
<body>

<form name="login" id="login" action="../Controller/registracija.php" method="POST">
    <div class="labels">
        <label for="username">Korisničko ime:</label><br />
        <label for="password">Lozinka:</label><br />
    </div>
    <div>
        <input class="input" type="text" name="username" id="username" size="20" maxlength="20" placeholder="Unesi korisničko ime" required="required"/><br>
        <input class="input" type="password" id="password" name="password" size="20" maxlength="20" placeholder="Unesi lozinku" required="required"/><br>
    </div>

    <input class="button" type="submit" name="submit" value="Prijavi se"/>
</form>

</body>
</html>