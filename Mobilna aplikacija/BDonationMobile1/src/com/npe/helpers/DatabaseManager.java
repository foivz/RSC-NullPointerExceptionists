package com.npe.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseManager extends SQLiteOpenHelper {

	private final static String DB_NAME = "blood_donations.db";
	private final static int DB_VER = 5;
	
	private Context context;
	
	
	
	public DatabaseManager (Context context){
		super(context, DB_NAME, null, DB_VER);
		this.context = context;
	}



	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(Queries.CREATE_USER);
		db.execSQL(Queries.CREATE_BLOOD_TYPE);
		db.execSQL(Queries.CREATE_DONATIONS);
		db.execSQL(Queries.CREATE_INSTITUTIONS);
		db.execSQL(Queries.CREATE_LOGGED_IN);
	}



	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(Queries.DROP_INSTITUTIONS);
		db.execSQL(Queries.DROP_BLOOD_TYPE);
		db.execSQL(Queries.DROP_DONATIONS);
		db.execSQL(Queries.DROP_USER);
		db.execSQL(Queries.DROP_LOGGED_IN);
		onCreate(db);
	}
	
	
	
/*
 * -------------------------------------   Upiti   ------------------------------------- 
 */
	
	
	public boolean userExists(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(Queries.countUsers, null);
		cursor.moveToFirst();
		
		boolean exists = false;
		if(cursor.getInt(0) > 0)
			exists = true;
		
		cursor.close();
		db.close();
		
		return exists;
	}// end userExists()
	
	
	
	
	public boolean userLoggedIn(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(Queries.countLoggedIn, null);
		cursor.moveToFirst();
		
		boolean loggedIn = false;
		if(cursor.getInt(0) > 0)
			loggedIn = true;
		
		cursor.close();
		db.close();
		
		return loggedIn;
	}// end userLogedIn()
	
	
	
	public boolean checkUserCredentials(String mail, String password){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(Queries.checkCredentials(mail, password), null);
		cursor.moveToFirst();
		
		boolean exists = false;
		if(cursor.getCount() > 0)
			exists = true;
		
		cursor.close();
		db.close();
		
		return exists;
	}
	
	
/*
 * -------------------------------------   INSERTOVI   ------------------------------------- 
 */
	
	public void insertUser(String []array){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		
		values.put("name", array[0]);
		values.put("lastname", array[1]);
		values.put("date_of_birth", array[2]);
		values.put("gender", array[3]);
		values.put("weight", Float.parseFloat(array[4]));
		values.put("city", array[5]);
		values.put("mail", array[6]);
		values.put("password", array[7]);
		values.put("number", array[8]);
		
		db.insert("user", null, values);
		values.clear();
		db.close();
	}// end void insertUser()
	
	
	
	
	public void insertLoggedIn(String username, String pass){
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("username", username);
		values.put("password", pass);
		db.insert("logged_in", null, values);
		db.close();
	}// end void insertLoggedIn()
	
}// end class DatabaseManager
