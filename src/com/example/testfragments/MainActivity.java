package com.example.testfragments;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.audiofx.BassBoost.Settings;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements FirstFragment.OnFragmentClickListener{

       
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
	            
	            SecondFragment secondFrag = new SecondFragment();
	            // In case this activity was started with special instructions from an
	            // Intent, pass the Intent's extras to the fragment as arguments
	            firstFrag.setArguments(getIntent().getExtras());
	            
	            // Add the fragment to the 'fragment_container' FrameLayout
	            getSupportFragmentManager().beginTransaction()
	                    .add(R.id.fragment_container_left, firstFrag).commit();
	            
	         
	   	        }
	    
	}

		@Override
		public void OnFragmentClick() {
			// TODO Auto-generated method stub
			SecondFragment frag = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container_right) ;
			
			if(frag == null){
				FragmentTransaction ft = getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_right, new SecondFragment());
				//FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_left, new SecondFragment());

				ft.addToBackStack(null);
				ft.commit();
				
			}else{
				Toast.makeText(getApplicationContext(), "Already added the Second Fragment! ", 500).show();
			}
			
		}
		
		
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
			
			Intent i = new Intent(this, MainActivity.class
					);
		return super.onOptionsItemSelected(item);
		
		}

}

