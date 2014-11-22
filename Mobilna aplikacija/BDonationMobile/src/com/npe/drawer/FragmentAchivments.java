package com.npe.drawer;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.npe.donation.R;


public class FragmentAchivments extends Fragment {
	ListView lista;
	
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.fragment_achivments_layout, container, false);
        lista=(ListView) view.findViewById(R.id.listView1);
        String[] items={"1 donacija","3 donacija","10 donacija","balal","balal","balal","balal","balal","balal","balal"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        lista.setAdapter(adapter);
        return view;
    }
}
