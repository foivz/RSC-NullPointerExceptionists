<?php

class base {

    function connectBase() {
        $mysqli = new mysqli('localhost', 'WebDiP2013_015', 'admin_QzTV', 'WebDiP2013_015');

        if ($mysqli->connect_errno) {
            echo($mysqli->connect_error);
            exit();
        }
        return $mysqli;
    }

    function query($query, $connection) {
        $result = $connection->query($query);

        if(!result)
            $result = null;
    }

    function insertUpdate($query, $connection) {
        $result = $connection->query($query);
        return $result;
    }

    function closeConnection($connection) {
        $connection->close();
    }
}