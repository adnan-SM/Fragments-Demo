package com.example.testfragments;


import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {
    
	Button btn;
	private OnFragmentClickListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState) {
       
        View v = inflater.inflate(R.layout.first_fragment,
                container, false);
        //Do stuff to the fragment view in here if you want
        
        btn = (Button) v.findViewById(R.id.breplace);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateDetail();
			}
		});
        
        return v;
    }
    
    public interface OnFragmentClickListener {
        public void OnFragmentClick();
    }
    
    
    @Override
    public void onAttach(Activity activity) {
      super.onAttach(activity);
      if (activity instanceof OnFragmentClickListener) {
        listener = (OnFragmentClickListener) activity;
      } else {
        throw new ClassCastException(activity.toString()
            + " must implemenet ArticleFragment.OnFragmentClickListener");
      }
    }
    

    @Override
    public void onDetach() {
      super.onDetach();
      listener = null;
    }

    
    public void updateDetail() {

        // Inform the Activity about the change based
        // interface defintion
        listener.OnFragmentClick();
    }
    
   
    
 
}
