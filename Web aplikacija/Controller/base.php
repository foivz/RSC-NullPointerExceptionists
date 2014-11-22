<?php

class base {

    static $hostname = 'localhost';
    static $username = 'WebDiP2013_015';
    static $password = 'WebDiP2013_015';
    static $dbname = 'WebDiP2013_015';

    function connectBase() {
        try {
            $base = new PDO("mysql:host=" . self::$hostname . ";dbname=" . self::$dbname . ", " . self::$username . ", " . self::$password);

        }
        catch(PDOException $e) {
            echo $e->getMessage();
        }
        return $base;
    }

    function insertUpdate($query, $connection) {

        try {

            $result = $connection->exec($query);
            return $result;
        } catch(PDOException $e) {
            echo $e->getMessage();
        }

    }

    function select($query, $connection) {
        try {

            $result = $connection->query($query);
            return $result;
        } catch(PDOException $e) {
            echo $e->getMessage();
        }
    }

    function closeConnection($connection) {
        $connection = null;
    }
}