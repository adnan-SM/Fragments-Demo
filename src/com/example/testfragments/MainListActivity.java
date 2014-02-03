package com.example.testfragments;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

public class MainListActivity extends FragmentActivity implements ListViewFragment.onListItemClickListener{

       
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        ActionBar aBar = getActionBar();
	        aBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#86B404" )));
	       
	        if (findViewById(R.id.fragment_container_left) != null) {

	            // However, if we're being restored from a previous state,
	            // then we don't need to do anything and should return or else
	            // we could end up with overlapping fragments.
	        
	        	if (savedInstanceState != null) {
	                return;
	            }
				
	            // Create a new Fragment to be placed in the activity layout
	            FirstFragment firstFrag = new FirstFragment();
	            ListViewFragment listFrag = new ListViewFragment();
	            SecondFragment secondFrag = new SecondFragment();
	            // In case this activity was started with special instructions from an
	            // Intent, pass the Intent's extras to the fragment as arguments
	            firstFrag.setArguments(getIntent().getExtras());
	            listFrag.setArguments(getIntent().getExtras());
	            // Add the fragment to the 'fragment_container' FrameLayout
	            getSupportFragmentManager().beginTransaction()
	                    .add(R.id.fragment_container_left, listFrag).commit();
	            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_right, new SecondFragment()).commit();
	            
	   	        }
	    
	}

		

		@Override
		public void onListItemClick(int position) {
			
			SecondFragment secFrag = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_right);
			if(secFrag != null)
			{
			secFrag.setText(""+position);
			
			}else
			{
				Toast.makeText(getApplicationContext(), "Null", 500).show();
			}
			
			
		}

}

