<?php
	
	require_once "base.php";
	require_once "../Model/Institution.class.php";

	class Ucitavac
	{
		private function __construct() {}

		public static function UcitajInstitucije()
		{
			$institucije = array();
			$veza = new base;
			$veza->connectBase();

			$rez = $veza->runQuery("SELECT * FROM institution");
			while ($red = $rez->fetch_assoc()) {
				$institucija = new Institution($red['id'], $red['name'], $red['location'], $red['description'], null);
				array_push($institucije, $institucija);
			}

			$veza->closeConn();
			return $institucije;
		}

		public static function UcitajSpremisteKrvi()
		{
			
		}
	}



