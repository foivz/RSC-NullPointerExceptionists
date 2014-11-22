<?php
    session_start();

    if (!isset($_SESSION['logged'])) {
        $iframeSrc = "View/prijava.php";
    } else {
        $iframeSrc = "#";
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
                        <a href="#">Prijava</a>
                    </li>
                </ul>
            </nav>
        </header>

        <div id="iframe-container">
                <iframe src="<?php echo $iframeSrc; ?>" frameborder="0">
                    Došlo je do greške kod učitavnja stranice.
                </iframe>
        </div>

        <footer>
        </footer>
    </body>
</html>