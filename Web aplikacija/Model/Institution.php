<?php

	class Institution
	{
		private $id;
		private $name;
		private $location;
		private $description;
		private $bloodStorage

		function __construct() {}

		function __construct($id, $name, $location, $description, $bloodStorage)
		{
			$this->id = $id;
			$this->name = $name;
			$this->location = $location;
			$this->description = $description;
			$this->dosage = $dosage;
			$this->criticalDosage = $criticalDosage;
		}

		public function getID() 
		{
			return $this->id;
		}

		public function getName()
		{
			return $this->name;
		}

		public function getLocation()
		{
			return $this->location;
		}

		public function getDescription()
		{
			return $this->description;
		}

		public function getBloodStorage()
		{
			return $this->bloodStorage;

		public function setName($name)
		{
			$this->name = $name;
		}

		public function setLocation($location)
		{
			$this->location = $location;
		}

		public function setDescription($description)
		{
			$this->description = $description;
		}

		public function setBloodStorage($bloodStorage)
		{
			$this->bloodStorage = $bloodStorage;
		}
	}

?>