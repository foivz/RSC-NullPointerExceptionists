<?php
    session_start();

    if (!isset($_SESSION['userId'])) {
        $iframeSrc = "View/prijava.php";
        $prijava_odjava = "<a href=\"View/prijava.php\">Prijava</a>";

    } else {
        $iframeSrc = "#";
        $prijava_odjava = "<a href=\"Controller/logout.php\">Odjava</a>";
    }
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="View/CSS/style-index.css">
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
                        <?php echo $prijava_odjava; ?>
                    </li>
                </ul>
            </nav>
        </header>

        <div id="iframe-container">
                <iframe src="<?php echo $iframeSrc; ?>" frameborder="0">
                    Došlo je do griješke kod učitavnja stranice.
                </iframe>
        </div>

        <footer>
        </footer>
    </body>
</html>