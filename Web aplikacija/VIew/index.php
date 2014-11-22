<?php
header('Content-Type: text/html; charset=utf-8');
session_start();
?>

{include file='zaglavlje.tpl'}

<div class="navigation">
    <ul id="nav">
        <li class="active"><a href="index.php">Početna</a></li>
        <li><a href="#">Test</a></li>
        <li><a href="#">Test</a></li>
        <li><a href="#">Test</a></li>
    </ul>
</div>

{if isset($smarty.session.ulogiran) && ($smarty.session.ulogiran == true)}
<div class="click-nav">
    <ul class="no-js">
        <li>
            <a href="#" class="clicker" style="background: none; border: none;"><img src="img/settings.png" style="width: 20px; height: 20px;" alt="postavke"></a>
            <ul>
                {if isset($smarty.session.tipKorisnika) && ($smarty.session.tipKorisnika == 3)}
                <li><a href="dnevnik.php">Dnevnik sustava</a></li>
                <li><a href="postavke.php">Postavke sustava</a></li>
                <li><a href="izmjena.php"><img src="{$slika}" style="width: 25px; height: 25px;">Profil</a></li>
                <li><a href="korisnici.php">Korisnici</a></li>
                <li><a href="odjava.php">Odjavi se</a></li>
                {else}
                <li><a href="class/izmjena.php?idKorisnika={$smarty.session.idKorisnika}"><img src="{$slika}" style="width: 25px; height: 25px;">Profil</a></li>
                <li><a href="odjava.php">Odjavi se</a></li>
                {/if}
            </ul>
        </li>
    </ul>
</div>
{/if}

{include file='podnozje.tpl'}