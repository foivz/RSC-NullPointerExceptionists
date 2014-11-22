<?php

class base {

    static private $hostname = 'localhost';
    static private $username = 'root';
    static private $password = '';
    static private $dbname = 'b_donator';
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