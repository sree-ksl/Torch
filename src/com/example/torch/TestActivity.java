package com.example.torch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TestActivity extends Activity {
	LinearLayout layout;
	private Button btnOn;
	private Button btnOff;
	CloudLed led;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		layout = new LinearLayout(this);
		btnOn = new Button(this);
		btnOn.setText("ON");
		btnOn.setWidth(150);
		btnOff = new Button(this);
		btnOff.setText("OFF");
		btnOff.setWidth(150);
		led = new CloudLed();
		btnOn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
			   led.turnOn();
			}
			
		});
		btnOff.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				led.turnOff();
			}
			
		});
		layout.setHorizontalFadingEdgeEnabled(false);
		layout.setVerticalFadingEdgeEnabled(true);
		layout.addView(btnOn);
		layout.addView(btnOff);
		setContentView(layout);
	}
	
	@Override
	public void onPause(){
		super.onPause();
		led.turnOff();
	}
	
	@Override
	public void onResume(){
		super.onResume();
	}

}
