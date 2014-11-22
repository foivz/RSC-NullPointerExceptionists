<?php
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/style-form.css">
</head>
<body>

<form name="login" id="login" class="form" action="../Controller/login.php" method="POST">
    <div class="input-label">
        <label for="username">Korisničko ime:</label>
        <input type="text" name="username" id="username" size="20" maxlength="20" placeholder="Unesi korisničko ime" required="required"/>
    </div>

    <div class="input-label">
        <label for="password">Lozinka:</label>
        <input type="password" id="password" name="password" size="20" maxlength="20" placeholder="Unesi lozinku" required="required"/>
    </div>

    <div class="input-label">
        <input type="submit" name="submit" value="Prijavi se"/>
    </div>
</form>

</body>
</html>