<?php
session_start();
?>

<!DOCTYPE html>
    <html>
        <head>
            <title><?php echo $title; ?></title>
            <meta charset="UTF-8">
            <link href="<?php echo $css; ?>" rel="stylesheet">
        </head>
        <body>
        <div class="header">
            Blood donations
        </div>
        <?php
            if(!isset($_SESSION['login']) && empty($_SESSION['login'])) {
                echo("
                <a href=\"prijava.php\"><br />Prijava</a>
                <a href=\"registracija.php\">(ili Registracija)</a>.");
            }

        echo(
        "
        <div class=\"content\">
        <div style=\"height: 80px;\"></div>
    </html>");
?>