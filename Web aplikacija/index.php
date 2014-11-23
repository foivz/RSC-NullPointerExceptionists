<?php
    session_start();
    $logiran = 0;
    $prijava_odjava = "";

    if (isset($_SESSION['userId'])) {
        $prijava_odjava = "<a href='Controller/logout.php'>Odjava</a>";
        $logiran = 1;
    }
    else {
        $prijava_odjava = "<a href='#' onclick='LoginOnClick()'>Prijava</a>";
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
                <img src="View/Images/logo.png" alt="Logo" height="75px"
                 style="margin-left: 50px; margin-top: 2px"/>
            </div>

            <nav id="navigation">
                <ul>
                    <li>
                        <a href="#" onclick="HomeOnClick()">Početna</a>
                    </li>
                    <li>
                        <a href="#" onclick="InstitutionOnClick()">Institucije</a>
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
            <iframe src="View/pocetna.php" frameborder="0" id="iframe-element"></iframe>
        </div>

        <footer>
        </footer>
    </body>
    <script>
        var iframeElement = document.getElementById("iframe-element");
        function InstitutionOnClick()
        {
            iframeElement.src = "View/institucije.php";
        }
        function HomeOnClick()
        {
            iframeElement.src = "View/pocetna.php";
        }
        function LoginOnClick()
        {
            iframeElement.src = "View/prijava.php";
        }
    </script>
</html>