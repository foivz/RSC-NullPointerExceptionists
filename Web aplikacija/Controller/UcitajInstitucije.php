<?php
	
	require_once "base.php";

	$institutions;

	$b = new base;
	$b->connectBase();
	$rows = $b->insUpd("INSERT INTO institution(name, location, description) VALUES ('Institucija 4', 'Varaždin, Trenkova 33', 'Sitno, ali dinamitno!')");
	echo $rows;
	$b->closeConn();



