package com.npe.helpers;

public class Queries {

	public static final String CREATE_USER = 
			"CREATE TABLE user(id INTEGER PRIMARY KEY AUTOINCREMENT, username VARCHAR(15), password VARCHAR(20), " +
			"name VARCHAR (20), lastname VARCHAR (25), date_of_birth DATE, weight REAL, " + 
			"gender CHAR(1), mail VARCHAR(35), number VARCHAR(15), city VARCHAR(40), " +
			"blood_type INTEGER  REFERENCES blood_type(id), " +
			"donation INTEGER REFERENCES donations(id))";
	
	public static final String CREATE_BLOOD_TYPE = 
			"CREATE TABLE blood_type(id INTEGER PRIMARY KEY AUTOINCREMENT, type VARCHAR(3), " + 
			"rh_factor CHAR(1))";
	
	public static final String CREATE_DONATIONS = 
			"CREATE TABLE donations(id INTEGER PRIMARY KEY AUTOINCREMENT, date DATE)";

	public static final String CREATE_INSTITUTIONS = 
			"CREATE TABLE institutions(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(30), " +
			"city VARCHAR(40))";
	
	public static final String CREATE_LOGGED_IN = "CREATE TABLE logged_in(username VARCHAR(30), " + 
								"password VARCHAR(30), PRIMARY KEY(username, password))";
	
	
	public static final String DROP_USER = "DROP TABLE IF EXISTS user";
	public static final String DROP_BLOOD_TYPE = "DROP TABLE IF EXISTS blood_type";
	public static final String DROP_DONATIONS = "DROP TABLE IF EXISTS donations";
	public static final String DROP_INSTITUTIONS = "DROP TABLE IF EXISTS institutions";
	public static final String DROP_LOGGED_IN = "DROP TABLE IF EXISTS logged_in";
	
	
	
/*
 * -----------------------------------------   UPITI  ----------------------------------------- 
 */
	
	public static String countUsers = "SELECT COUNT(*) FROM user";
	
	public static String countLoggedIn = "SELECT COUNT(*) FROM logged_in";
	
	public static String checkCredentials(String mail, String pass){
		return "SELECT * FROM user WHERE mail = '" + mail + "' " +
				"AND password = '" + pass + "' ";
	}
	
	
}
