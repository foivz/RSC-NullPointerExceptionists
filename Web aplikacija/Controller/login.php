<?php
header('Content-Type: text/html; charset=utf-8');
require_once("base.php");

session_start();

if (isset($_SESSION['logged']) && $_SESSION['logged'] == true) {
    header("Location: " . dirname($_SERVER['REQUEST_URI']) . '/index.php');
    exit();
}

$base = new base();

if(isset($_POST['submit'])) {
    auth($_POST['username'], $_POST['password']);
}

function auth($username, $password) {
    global $base;
    $connection = $base->connectBase();

    $query = "SELECT * FROM user WHERE username = \"{$username}\" AND password = \"{$password}\";";

    $user = $base->select($query, $connection);

    if($user->fetch(PDO::FETCH_NUM) != 0) {
        $row = $user->fetch(PDO::FETCH_ASSOC);
        if($row['account_blocked'] != 1) {
            createSession($row['id']);
            $base->closeConnection($connection);
            header("Location: " . dirname(dirname($_SERVER['REQUEST_URI'])) . '/index.php');
            exit();
        }
    }
}

function createSession($userId) {
    global $base;
    $connection = $base->connectBase();

    $query = "SELECT * FROM user WHERE id = \"{$userId}\";";
    $user = $base->select($query, $connection);
    $row = $user->fetch(PDO::FETCH_ASSOC);

    session_start();

    $_SESSION['userId'] = $userId;
    $_SESSION['username'] = $row['username'];
    $_SESSION['name'] = $row['name'];
    $_SESSION['surname'] = $row['surname'];
    $_SESSION['date_of_birth'] = $row['date_of_birth'];
    $_SESSION['weight'] = $row['weight'];
    $_SESSION['gender'] = $row['gender'];
    $_SESSION['email'] = $row['email'];
    $_SESSION['city'] = $row['city'];
    $_SESSION['oib'] = $row['oib'];
    $_SESSION['blood_type'] = $row['blood_type'];
    $_SESSION['intitution'] = $row['intitution'];
}

?>