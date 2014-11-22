package com.npe.helpers;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;

public class DatePickerClass {

	private Context context;
	private OnDateSetListener listener;
	
	
	public DatePickerClass(Context context, OnDateSetListener listener){
		this.context = context;
		this.listener = listener;
	}
	
	
	
	public DatePickerDialog createPicker(){
		final Calendar c = Calendar.getInstance();
		int d = c.get(Calendar.DAY_OF_MONTH);
		int m = c.get(Calendar.MONTH);
		int y = c.get(Calendar.YEAR);
		
		return new DatePickerDialog(context, listener, y, m, d); 
	}

}