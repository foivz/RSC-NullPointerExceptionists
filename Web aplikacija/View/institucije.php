<?php
    require_once "../Controller/Ucitavac.php";
    $institucije = Ucitavac::UcitajInstitucije();
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/style-institutions.css">
    </head>
    <body>
        <div class="table-container">
            <ul>
                <?php
                    $liste = "";
                    foreach ($institucije as $i) {
                        $liste .= "<li>";
                        $liste .= "<div class='name'>{$i->GetName()} -&nbsp;</div>";
                        $liste .= "<div class='location'> {$i->GetLocation()}</div>";
                        $liste .= "<div class='description'>{$i->GetDescription()}</div>";
                        $liste .= "</li>";
                    }
                    echo $liste;
                ?>
            </ul>
        </div>
    </body>
</html>