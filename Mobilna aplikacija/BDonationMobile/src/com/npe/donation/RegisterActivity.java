package com.npe.donation;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.npe.helpers.DatePickerClass;

public class RegisterActivity extends Activity {

	Button buttonDate;
	
	EditText editName;
	EditText editLastName;
	
	Spinner spinnerCity;
	
	TextView labelDate;
	
	String date = "";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		findViews();
	}// end onCreate()
	
	
	private void findViews(){
		buttonDate = (Button) findViewById(R.id.button_date_register);
		
		editName = (EditText) findViewById(R.id.edit_ime_register);
		editLastName = (EditText) findViewById(R.id.edit_prezime_register);
				
		spinnerCity = (Spinner) findViewById(R.id.spinner_grad);
		
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
						date = dayOfMonth + "." + (monthOfYear+1) + "." + year;
						labelDate.setText("Datum roðenja: " + date);
					}
				});
				dp.createPicker().show();
			}//onClick
		});
	}// setButtonClick()
	
	
}// end class RegisterActivity