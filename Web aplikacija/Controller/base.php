<?php

class base {

    static $hostname = 'localhost';
    static $username = 'WebDiP2013_015';
    static $password = 'admin_QzTV';
    static $dbname = 'WebDiP2013_015';

    function connectBase()
    {
        $mysqli = new mysqli(self::$hostname, self::$username, self::$password, self::$dbname);

        return $mysqli;
    }

    function runQuery($query, $connection) {

        $result = $connection->query($query);

        if (!$result) {
            $result = null;
        }
        return $result;
    }

    function insUpd($query, $connection) {

        $result = $connection->query($query);
        return $result;
    }

    function lastId($connection) {
        return $connection->insert_id;
    }

    function closeConn($connection)
    {
        $connection->close();
    }
}