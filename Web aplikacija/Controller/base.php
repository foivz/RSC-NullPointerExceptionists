<?php

class base {

    static $hostname = 'localhost';
    static $username = 'root';
    static $password = 'root';
    static $dbname = 'WebDiP2013_015';
    private $mysqli;

    function connectBase()
    {
        $this->mysqli = new mysqli(self::$hostname, self::$username, self::$password, self::$dbname);
    }

    function runQuery($query) {

        $result = $this->mysqli->query($query);

        if (!$result) {
            $result = null;
        }
        return $result;
    }

    function insUpd($query) {

        $result = $this->mysqli->query($query);
        return $result;
    }

    function lastId() {
        return $this->mysqli->insert_id;
    }

    function closeConn()
    {
        $this->mysqli->close();
    }
}