package com.thedeveloperworldisyours.withoutlayout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TheDeveloperWorldIsYours extends Activity {

	private TextView valueTV;
	private Button valueB;
	private TextView valueRelativeLayoutTV;
	private Button valueRelativeLayoutB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		//create LInearLayout
		LinearLayout myLInearLayout = new LinearLayout(getApplicationContext());

		//add LayoutParams
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		myLInearLayout.setOrientation(LinearLayout.VERTICAL);
		
		//set Content View
		setContentView(myLInearLayout);

		//add textView
		valueTV = new TextView(this);
		valueTV.setText("LinearLayout");
		valueTV.setId(5);
		valueTV.setLayoutParams(params);

		// add Button
		valueB = new Button(this);
		valueB.setText("RelativeLayout");
		valueB.setId(5);

		//add the textView and the Button to LinearLayout
		myLInearLayout.addView(valueTV);
		myLInearLayout.addView(valueB);
		
		valueB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				// add Button
        		valueRelativeLayoutB = new Button(getApplicationContext());
        		valueRelativeLayoutB.setText("RelativeLayout");
        		valueRelativeLayoutB.setId(5);
				
        		//add RelativeLayout
				RelativeLayout mainLayout = new RelativeLayout(getApplicationContext());
                RelativeLayout.LayoutParams lyp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
                mainLayout.setLayoutParams(lyp);
                
                //android:layout_below
        		lyp.addRule(RelativeLayout.BELOW, valueRelativeLayoutB.getId());
        		v.setLayoutParams(lyp);
                
        		//The most important line
        		setContentView(mainLayout);
                
              //add textView
                valueRelativeLayoutTV = new TextView(getApplicationContext());
        		valueRelativeLayoutTV.setText("RelativeLayout");
        		valueRelativeLayoutTV.setId(5);
        		valueRelativeLayoutTV.setLayoutParams(lyp);

        		
        		
        		
        		mainLayout.addView(valueRelativeLayoutTV);
        		mainLayout.addView(valueRelativeLayoutB);
        		
        		valueRelativeLayoutB.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						//Exit app
						System.exit(0);
					}
				});
        		
			}
		});


	}

}
