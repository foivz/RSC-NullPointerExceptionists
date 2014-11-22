package com.npe.drawer;

import android.app.Fragment;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.npe.donation.R;
import com.npe.donation.RegisterActivity;
import com.npe.helpers.DatePickerClass;


public class FragmentDoniraj extends Fragment {
    TextView text;
    Spinner spinnerCity;
    Button buttonDate;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.fragment_doniraj_layout, container, false);
        spinnerCity = (Spinner) view.findViewById(R.id.spinner_grad_donacija);
        buttonDate=(Button) view.findViewById(R.id.button_datum);
        setButtonClick();
        return view;
    }
    private void setButtonClick(){
		
		buttonDate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DatePickerClass dp = new DatePickerClass(getActivity(), new OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int monthOfYear,
							int dayOfMonth) {
						// TODO Auto-generated method stub
						String date = dayOfMonth + "." + (monthOfYear+1) + "." + year;
						//labelDate.setText("Datum roðenja: " + date);
					}
				});
				dp.createPicker().show();
			}//onClick
		});
	}// setButtonClick()
}
