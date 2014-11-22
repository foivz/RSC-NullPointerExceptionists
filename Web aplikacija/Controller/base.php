<?php

class base {

        static $hostname = 'localhost';
        static $username = 'WebDiP2013_015';
        static $password = 'admin_QzTV';
        static $dbname = 'WebDiP2013_015';

    function connectBase() {

        try {
            $base = new PDO("mysql:host=" . self::$hostname . ";dbname=" . self::$dbname, self::$username, self::$password);
        }
        catch(PDOException $e) {
            echo $e->getMessage();
        }
        return $base;
    }

    function insertUpdate($query) {

        try {
            $base = new PDO("mysql:host=" . self::$hostname . ";dbname=" . self::$dbname, self::$username, self::$password);
            $result = $base->exec($query);
            return $result;
        } catch(PDOException $e) {
            echo $e->getMessage();
        }

    }

    function select($query) {
        try {

            $base = new PDO("mysql:host=" . self::$hostname . ";dbname=" . self::$dbname, self::$username, self::$password);
            $res = $base->query($query);
            $result = $res->fetch(PDO::FETCH_ASSOC);
            return $result;
        } catch(PDOException $e) {
            echo $e->getMessage();
        }
    }

    function closeConnection($connection) {
        $connection = null;
    }
}