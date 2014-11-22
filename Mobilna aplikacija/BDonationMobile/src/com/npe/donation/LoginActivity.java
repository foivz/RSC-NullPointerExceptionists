package com.npe.donation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity {

	private Button buttonLogin;
	private Button buttonRegister;
	
	private EditText editPassword;
	private EditText editUsername;
	
	private String strUserName = "";
	private String strPassWord = "";
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        findViews();
    }// end onCreate()
    
    
    
    
    
    private void findViews(){
    	buttonLogin = (Button) findViewById(R.id.button_login);
    	buttonRegister = (Button) findViewById(R.id.button_register);
    	
    	editUsername = (EditText) findViewById(R.id.edit_username_login);
    	editPassword = (EditText) findViewById(R.id.edit_password_login);
    	
    	setEditListeners();
    	setLoginButton();
    	setRegisterButton();
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
					Toast.makeText(LoginActivity.this, "Username: " + strUserName + "\nPass: " + strPassWord, Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
				}
			}//onClick
		});
    }// end void setLoginButton()
    
    
    
    
    private void setRegisterButton(){
    	buttonRegister.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
				startActivity(intent);
			}//onClick
		});
    }
    
    
    
    private String getEditText(EditText e){
    	return e.getText().toString();
    }// end String getEditText()
    
   
}
