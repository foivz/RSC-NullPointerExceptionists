<?php

	class BloodStorage
	{
		private $dosage;
		private $criticalDosage;
		private $bloodType;

		function __construct() {}

		function __construct($dosage, $criticalDosage, $bloodType)
		{
			$this->dosage = $dosage;
			$this->criticalDosage = $criticalDosage;
			$this->bloodType = $bloodType;
		}

		public function getDosage()
		{
			return $this->dosage;
		}

		public function getCriticalDosage()
		{
			return $this->criticalDosage;
		}

		public function getBloodType()
		{
			return $this->bloodType
		}

		public function setDosage($dosage)
		{
			$this->dosage = $dosage;
		}

		public function setCriticalDosage($criticalDosage)
		{
			$this->criticalDosage = $criticalDosage;
		}

		public function setBloodType($bloodType)
		{
			$this->bloodType = $bloodType;
		}
	}

?>