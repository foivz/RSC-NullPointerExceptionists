package com.npe.donation;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.npe.helpers.DatabaseManager;
import com.npe.helpers.DatePickerClass;

public class RegisterActivity extends Activity {

	private Button buttonDate;
	private Button buttonConfirm;
	
	private EditText editName;
	private EditText editLastName;
	private EditText editMobitel;
	private EditText editPassword;
	private EditText editWeight;
	private EditText editMail;
	
	private Spinner spinnerCity;
	private Spinner spinnerGender;
	private TextView labelDate;
	
	private String date = "";
	private String name = "";
	private String lastName = "";
	private String city = "";
	
	private DatabaseManager database;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		database = new DatabaseManager(this);
		findViews();
	}// end onCreate()
	
	
	private void findViews(){
		buttonDate = (Button) findViewById(R.id.button_date_register);
		buttonConfirm = (Button) findViewById(R.id.button_confirm_register);
		
		editName = (EditText) findViewById(R.id.edit_ime_register);
		editLastName = (EditText) findViewById(R.id.edit_prezime_register);
		editMobitel = (EditText) findViewById(R.id.edit_mobitel);
		editPassword= (EditText) findViewById(R.id.edit_password_register);
		editWeight = (EditText) findViewById(R.id.edit_weight);
		editMail = (EditText) findViewById(R.id.edit_mail);
				
		spinnerCity = (Spinner) findViewById(R.id.spinner_grad);
		spinnerGender = (Spinner) findViewById(R.id.spinner_spolovi);
		labelDate = (TextView) findViewById(R.id.label_date_register);
		
		setButtonClick();
	}// end void findViews()
	
	
	
	
	
	private void setButtonClick(){
		buttonDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DatePickerClass dp = new DatePickerClass(RegisterActivity.this, new OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						if(dayOfMonth < 10)
							date += '0';
						date += dayOfMonth + "-";
						if((monthOfYear+1) < 10)
								date+= '0';
						date += (monthOfYear+1) + "-" + year;
						labelDate.setText("Datum roðenja: " + date);
					}
				});
				dp.createPicker().show();
			}//onClick
		});
		
		
		buttonConfirm.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String[] string = new String[9];
				string[0] = getEditText(editName);
				string[1] = getEditText(editLastName);
				string[2] = date;
				string[3] = spinnerGender.getSelectedItem().toString();
				string[4] = getEditText(editWeight);
				string[5] = spinnerCity.getSelectedItem().toString();
				string[6] = getEditText(editMail);
				string[7] = getEditText(editPassword);
				string[8] = getEditText(editMobitel);
				
				boolean sve = true;
				for(int i=0; i<string.length; i++){
					if(string[i].isEmpty()){
						sve = false;
						break;
					}
				}
					
				if(sve){
					database.insertUser(string);
					Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
					finish();
					startActivity(intent);
				}
				else
					Toast.makeText(RegisterActivity.this, "Nisu uneseni svi podaci", Toast.LENGTH_SHORT).show();
			}
		});
	}// setButtonClick()
	
	
	
	
	private String getEditText(EditText e){
    	return e.getText().toString();
    }// end String getEditText()
	
}// end class RegisterActivity