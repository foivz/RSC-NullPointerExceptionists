package com.npe.donation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.npe.helpers.DatabaseManager;

public class LoginActivity extends ActionBarActivity {

	private Button buttonLogin;
	
	private EditText editPassword;
	private EditText editUsername;
	
	private String strUserName = "";
	private String strPassWord = "";
	
	private DatabaseManager database;
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = new DatabaseManager(this);
    }// end onCreate()
    
    
    @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	new CheckUser().execute();
    }
    
    
    
    private void findViews(){
    	setContentView(R.layout.activity_login);
    	buttonLogin = (Button) findViewById(R.id.button_login);
    	
    	editUsername = (EditText) findViewById(R.id.edit_username_login);
    	editPassword = (EditText) findViewById(R.id.edit_password_login);
    	
    	setEditListeners();
    	setLoginButton();
    }// end void findViews()
    
    
    
    
    private void setEditListeners(){
    	editPassword.setTransformationMethod(new PasswordTransformationMethod());
    	
    	editUsername.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				strUserName = getEditText(editUsername);
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				strUserName = getEditText(editUsername);
			}
		});
    	
    	
    	editPassword.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				strPassWord = getEditText(editPassword);
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				strPassWord = getEditText(editPassword);
			}
		});
    }// end void setEditListeners()
    
    
    
    
    private void setLoginButton(){
    	buttonLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(strUserName.isEmpty() || strPassWord.isEmpty())
					Toast.makeText(LoginActivity.this, "Nisu uneseni svi podaci!", Toast.LENGTH_SHORT).show();
				else{
					new LogUserIn().execute();
				}
			}//onClick
		});
    }// end void setLoginButton()
    
    
    
    
    private String getEditText(EditText e){
    	return e.getText().toString();
    }// end String getEditText()
    
   
    
 /*
  * --------------------------------   ASYNCTASKOVI   --------------------------------
  */ 
  

    private class CheckUser extends AsyncTask<Void, Void, Boolean>{
    	private ProgressDialog pd;
    	private boolean logiran;
    	
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		pd = new ProgressDialog(LoginActivity.this);
    		pd.show();
    	}
    	
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO Auto-generated method stub
			if(database.userExists()){
				logiran = database.userLoggedIn();
				Log.e("LOGIRAN? ", Boolean.toString(logiran));
				return true;
			}
			else
				return false;
		}
		
		@Override
		protected void onPostExecute(Boolean result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		if(pd.isShowing())
			pd.dismiss();
		if(result){
			if(logiran){
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				finish();
				startActivity(intent);
			}
			else
				findViews();
			}
		else{
			Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
			finish();
			startActivity(intent);
			}
		}// end void onPostExecute()
    }// end class checkUser
    
    
    
    
    private class LogUserIn extends AsyncTask<Void, Void, Boolean>{
    	@Override
    	protected Boolean doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		if(database.checkUserCredentials(strUserName, strPassWord)){
    			database.insertLoggedIn(strUserName, strPassWord);
    			return true;
    		}
    		else
    			return false;
    	}
    	
    	@Override
    	protected void onPostExecute(Boolean result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);
    		if(result){
    			Intent intent = new Intent(LoginActivity.this, MainActivity.class);
    			finish();
    			startActivity(intent);
    		}
    		else
    			Toast.makeText(LoginActivity.this, "Krivo kor. ime ili lozinka", Toast.LENGTH_SHORT).show();
    	}
    }// end class LogUserIn
    
    
}
