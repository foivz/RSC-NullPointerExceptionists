<?php
    session_start();

    if (isset($_SESSION['userId'])) {
        $prijava_odjava = "<a href=\"Controller/logout.php\">Odjava</a>";
    }
    else {
        header("Location: View/prijava.php");
    }
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="View/CSS/style-index.css">
        <link rel="stylesheet" type="text/css" href="View/CSS/style-form.css">
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

        <div id="iframe-container">
        </div>

        <footer>
        </footer>
    </body>
</html>