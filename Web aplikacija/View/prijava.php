<?php
session_start();

if (!isset($_SESSION['userId'])) {
    $prijava_odjava = "<a href=\"#\">Prijava</a>";
}
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="CSS/style-index.css">
    <link rel="stylesheet" type="text/css" href="CSS/style-form.css">
</head>
<body>
<header>
    <div id="banner">
    </div>

    <nav id="navigation">
        <ul>
            <li>
                <a href="#">Početna</a>
            </li>
            <li>
                <a href="#">Institucije</a>
            </li>
            <li>
                <a href="#">Donatori</a>
            </li>
            <li>
                <?php
                echo $prijava_odjava;
                ?>
            </li>
        </ul>
    </nav>
</header>

<form name="login" id="login" class="form" action="../Controller/login.php" method="POST" style="margin-bottom: 300px;">
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

<footer>
</footer>
</body>
</html>