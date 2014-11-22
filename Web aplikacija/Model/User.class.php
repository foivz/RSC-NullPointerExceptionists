<?php

	class User
	{
		private $id;
		private $username;
		private $password;
		private $name;
		private $surname;
		private $dateOfBirth;
		private $weight;
		private $gender;
		private $email;
		private $city;
		private $oib;
		private $bloodType;
		private $donorStatus;
		private $userType;
		private $institution;
		private $accountBlocked;
		private $achievements;
		private $donations;

		function __construct($id)
		{
			$this->id = $id;
		}

		function __construct($id, $username, $password, $name, $surname, $dateOfBirth, $weight,
			$gender, $email, $city, $oib, $bloodType, $donorStatus, $userType, #institution,
			$achievements, $donations, $accountBlocked)
		{
			$this->id = $id;
			$this->username = $username;
			$this->password = $password;
			$this->name = $name;
			$this->surname = $surname;
			$this->dateOfBirth = $dateOfBirth;
			$this->weight = $weight;
			$this->gender = $gender;
			$this->email = $email;
			$this->city = $city;
			$this->oib = $oib;
			$this->bloodType = $bloodType;
			$this->donorStatus = $donorStatus;
			$this->userType = $userType;
			$this->institution = $institution;
			$this->accountBlocked = $accountBlocked; 
			$this->achievements = $achievements;
			$this->donations = $donations;
		}

		public function getID()
		{
			return $this->id;
		}

		public function getUsername()
		{
			return $this->username;
		}
		
		public function getPassword()
		{
			return $this->password;
		}
		
		public function getName()
		{
			return $this->name;
		}
		
		public function getSurname()
		{
			return $this->surname;
		}
		
		public function getDateOfBirth()
		{
			return $this->dateOfBirth;
		}
		
		public function getWeight()
		{
			return $this->weight;
		}
		
		public function getGender()
		{
			return $this->gender;
		}
		
		public function getEmail()
		{
			return $this->email;
		}
		
		public function getCity()
		{
			return $this->city;
		}
		
		public function getOIB()
		{
			return $this->oib;
		}
		
		public function getBloodType()
		{
			return $this->bloodType;
		}
		
		public function getUserType()
		{
			return $this->userType;
		}
		
		public function getInstitution()
		{
			return $this->institution;
		}
		
		public function getAchievements()
		{
			return $this->achievements;
		}

		public function getDonations()
		{
			return $this->donations;
		}

		public function getAccountStatus()
		{
			return $this->accountBlocked;
		}
	}

?>