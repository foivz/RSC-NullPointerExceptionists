package com.npe.donate;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity {
	private Button sign_in;
	private Button sign_up;
	public String userName,passWord;
	private EditText password;
	private EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        sign_in=(Button) findViewById(R.id.sign_in_button);
        sign_up=(Button) findViewById(R.id.sign_up_button);
        
        username=(EditText) findViewById(R.id.user_email);
        password=(EditText) findViewById(R.id.user_email);
        //sign_in gumb pretisnut
        sign_in.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 userName=username.getText().toString();
			     passWord=password.getText().toString();
				
			}
		});
       
    }
}
