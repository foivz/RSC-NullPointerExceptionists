<?php
require_once('base.php');

session_start();

$base = new base();

$error = "";

$username = "";
$password1 = "";
$password2 = "";
$name = "";
$surname = "";
$date_of_birth = "";
$weight = "";
$gender = "";
$email = "";
$city = "";
$oib = "";
$blood_type = "";
$institution = "";

if(isset($_POST['submit'])) {
    $username = $_POST['username'];
    $password1 = $_POST['password1'];
    $password2 = $_POST['password2'];
    $name = $_POST['name'];
    $surname = $_POST['surname'];
    $date_of_birth = $_POST['date_of_birth'];
    $weight = $_POST['weight'];
    $gender = $_POST['gender'];
    $email = $_POST['email'];
    $city = $_POST['city'];
    $oib = $_POST['oib'];
    $blood_type = $_POST['blood_type'];
    $institution = $_POST['institution'];

    foreach ($_POST as $key => $value) {
        if ($value == "")
            $error .= "<br />You didn't fill field: {$key}!";
    }

    if (preg_match('/[0-9]/', $name)) {
        $error .= "<br />Name must contain only letters!";
    }

    if (preg_match('/[0-9]/', $surname)) {
        $error .= "<br />Surname must contain only letters!";
    }

    if (preg_match('/[0-9]/', $username)) {
        $error .= "<br />Username must contain only letters!";
    }

    if(strcmp($password1, $password2) != 0) {
        $error .= "<br />Both password must be same!";
//    } elseif (!preg_match('/^(?=.*\d)(?=.*[A-Za-z])[0-9A-Za-z!@#$%]{8,12}$/', $lozinka1)) {
//        $error .= "<br />Password is not strong enough!";
    }

    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $error .= "<br />Wrong email format!";
    }

    $query = "SELECT * FROM user WHERE email = '" . $email . "'";

    $rows = $base->select($query);

    var_dump($rows);
    if ($rows->fetch(PDO::FETCH_NUM) != 0) {

        $error .= "<br />Email is already taken!";
    }

    $query = "SELECT * FROM user WHERE username = '" . $username . "'";
    $rows = $base->select($query);
    if ($rows->fetch(PDO::FETCH_NUM) != 0) {
        $error .= "<br />Username is already taken!";
    }

    if(isset($_POST['recaptcha_response_field'])) {
        $resp = recaptcha_check_answer ($privatekey,
            $_SERVER["REMOTE_ADDR"],
            $_POST["recaptcha_challenge_field"],
            $_POST["recaptcha_response_field"]);
    }

    if ($error == "") {

        $query = "INSERT INTO user(username, password, name, surname, date_of_birth, weight, gender, email, city, oib, blood_type, institution)
                  VALUES ('{$username}', '{$password1}', '{$name}', '{$surname}', {$date_of_birth}, '{$weight}', '{$gender}', '{$email}', '{$city}', '{$oib}', '{$blood_type}', '{$institution}');";
        $result = $base->insertUpdate($query);
        $base->closeConnection($connection);
        header("Location: " . dirname($_SERVER['REQUEST_URI']) . '/index.php');
        }
}