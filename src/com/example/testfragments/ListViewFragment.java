package com.example.testfragments;

import java.util.ArrayList;

import com.example.testfragments.FirstFragment.OnFragmentClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ListViewFragment extends Fragment{
	
	ListView lv;
	private onListItemClickListener listener;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.list_fragment, container,false);
		lv = (ListView) view.findViewById(R.id.listView1);
		ArrayList<String> myList = new ArrayList<String>();
		
		for(int i=0; i<5; i++)
		{
			myList.add("Item "+i);
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,myList);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				loadContent(position);
			}
		});
		return view;
	}
	
	public interface onListItemClickListener
	{
		public void onListItemClick(int position);
	}
	
	public void loadContent(int position)
	{
		listener.onListItemClick(position);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if (activity instanceof onListItemClickListener) 
		{
			listener = (onListItemClickListener) activity;
	    } else {
	        throw new ClassCastException(activity.toString()
	            + " must implemenet ListViewFragment.onListItemClickListener");
	      }
	}
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		listener = null;
	}

}
