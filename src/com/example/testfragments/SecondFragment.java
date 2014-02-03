package com.example.testfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    
	TextView t;
    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
       
        View v = inflater.inflate(R.layout.second_fragment,
                container, false);
        //Do stuff to the fragment view in here if you want
 
        return v;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onActivityCreated(savedInstanceState);
    	t = (TextView) getActivity().findViewById(R.id.my_textview);
    }
 
    public void setText(String str)
    {
    	t.setText("Item "+str+" was clicked!");
    }
}
