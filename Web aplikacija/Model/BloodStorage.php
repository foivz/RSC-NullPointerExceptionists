<?php

	class BloodStorage
	{
		private $dosage;
		private $criticalDosage

		function __construct() {}

		function __construct($dosage, $criticalDosage)
		{
			$this->dosage = $dosage;
			$this->criticalDosage = $criticalDosage;
		}

		public function getDosage()
		{
			return $dosage;
		}

		public function getCriticalDosage()
		{
			return $criticalDosage;
		}

		public function setDosage($dosage)
		{
			$this->dosage = $dosage;
		}

		public function setCriticalDosage($criticalDosage)
		{
			$this->criticalDosage = $criticalDosage;
		}
	}

?>