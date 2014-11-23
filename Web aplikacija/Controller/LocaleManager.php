<?php

	class LocaleManager
	{
		private static $home = "Početna";
		private static $institutions = "Institucije";
		private static $donators = "Donatori";
		private static $login = "Prijava";
		private static $logout = "Odjava";
		private static $username = "Korisničko ime";
		private static $password = "Lozinka";
		private static $signIn = "Prijavi se";


		public static function GetValue($value)
		{
			$returnValue;

			switch ($value) {
				case "home": $returnValue = self::$home; break;
				case "institutions": $returnValue = self::$institutions; break;
				case "donators": $returnValue = self::$donators; break;
				case "login": $returnValue = self::$login; break;
				case "logout": $returnValue = self::$logout; break;
				case "username": $returnValue = self::$username; break;
				case "password": $returnValue = self::$password; break;
				case "sign in": $returnValue = self::$signIn; break;
				default: $returnValue = "error";
			}

			return $returnValue;
		}

		public static function ChangeLocale($locale)
		{
			if ($locale === "HRV") {
				self::$home = "Početna";
				self::$institutions = "Institucije";
				self::$donators = "Donatori";
				self::$login = "Prijava";
				self::$logout = "Odjava";
				self::$username = "Korisničko ime";
				self::$password = "Lozinka";
				self::$signIn = "Prijavi se";
			}
			else if ($locale === "ENG") {
				self::$home = "Home";
				self::$institutions = "Institutions";
				self::$donators = "Donators";
				self::$login = "Login";
				self::$logout = "Logout";
				self::$username = "Username";
				self::$password = "Password";
				self::$signIn = "Sign in";
			}
			else if ($locale === "DEU") {
				self::$home = "Zuhause";
				self::$institutions = "Institutionen";
				self::$donators = "Spender";
				self::$login = "Login";
				self::$logout = "Kasse";
				self::$username = "Benutzernamen";
				self::$password = "Passwort";
				self::$signIn = "Anmelden";
			}
		}
	}