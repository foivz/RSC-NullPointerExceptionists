package com.npe.drawer;



import java.util.ArrayList;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.npe.donation.R;
import com.npe.holographlibrary.Bar;
import com.npe.holographlibrary.BarGraph;
import com.npe.holographlibrary.PieGraph;
import com.npe.holographlibrary.PieSlice;


public class FragmentInstitucija extends Fragment {
    TextView text;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle args) {
        View view = inflater.inflate(R.layout.fragment_institucija_layout, container, false);
        PieGraph pg = (PieGraph) view.findViewById(R.id.graph);
        PieSlice slice = new PieSlice();
        slice.setColor(Color.parseColor("#99CC00"));
        slice.setValue(2);
        pg.addSlice(slice);
        slice = new PieSlice();
        slice.setColor(Color.parseColor("#FFBB33"));
        slice.setValue(3);
        pg.addSlice(slice);
        slice = new PieSlice();
        slice.setColor(Color.parseColor("#AA66CC"));
        slice.setValue(8);
        pg.addSlice(slice);
        pg.setInnerCircleRatio(150);
        return view;
    }
}
