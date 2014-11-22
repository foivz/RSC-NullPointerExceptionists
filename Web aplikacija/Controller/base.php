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

    function query($query, $connection) {

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

    function zadnjiId($connection) {
        return $connection->insert_id;
    }

    function ubijKonekciju($connection) {
        $connection->close();
    }
}