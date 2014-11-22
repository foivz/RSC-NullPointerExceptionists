<?php
header('Content-Type: text/html; charset=utf-8');
require_once("base.php");

session_start();

if (isset($_SESSION['logged']) && $_SESSION['logged'] == true) {
    header("Location: " . dirname($_SERVER['REQUEST_URI']) . '/index.php');
    exit();
}

$base = new base();
$connection = $base->connectBase();


?>