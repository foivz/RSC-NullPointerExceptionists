<?php
header('Content-Type: text/html; charset=utf-8');
require_once("base.php");

session_start();

$base = new base();
$base ->connectBase();

if(isset($_POST['submit'])) {
    auth($_POST['username'], $_POST['password']);
}

function auth($username, $password) {
    global $base;
    $query = "SELECT * FROM user WHERE username = \"{$username}\" AND password = \"{$password}\";";

    $user = $base->runQuery($query);

    if($user->num_rows != 0) {
        $row = $user->fetch_assoc();
        if($row['account_blocked'] != 1) {
            createSession($row['id']);
            $base->closeConn();
            header("Location: " . dirname(dirname($_SERVER['REQUEST_URI'])) . '/index.php');
            exit();
        } else {
            echo "Blokiran račun";
        }
    }
}

function createSession($userId) {
    global $base;

    $query = "SELECT * FROM user WHERE id = \"{$userId}\";";
    $user = $base->runQuery($query);
    $row = $user->fetch_assoc();

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
    $_SESSION['institution'] = $row['institution'];
}
?>