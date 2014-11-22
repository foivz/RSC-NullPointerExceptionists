<?php
session_start();

$_SESSION = array();
session_unset();
session_destroy();

header("Location: " . dirname(dirname($_SERVER['REQUEST_URI'])) . '/index.php');

?>
