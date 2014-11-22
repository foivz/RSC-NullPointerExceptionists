<?php

	class Achievement
	{
		private $id;
		private $name;
		private $description

		function __construct($id)
		{
			$this->id = $id;
		}

		function __construct($id, $name, $description)
		{
			$this->id = $id;
			$this->name = $name;
			$this->description = $description;
		}

		public function getID()
		{
			return $this->id;
		}

		public function getName()
		{
			return $this->name;
		}

		public function getDescription()
		{
			return $this->description;
		}

		public function setID($id)
		{
			$this->id = $id;
		}

		public function setName($name)
		{
			$this->name = $name;
		}

		public function setDescription($description)
		{
			$this->description = $description;
		}
	}

?>