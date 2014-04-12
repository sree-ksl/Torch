package com.example.torch;

import android.hardware.Camera;
import android.util.Log;

public class CloudLed {
	
	boolean isOn;
	Camera camera;
	
	public boolean getIsOn() {
		return isOn;
	}
	
	public CloudLed(){
		isOn = false;
	}
	
	public void turnOn(){
		if(isOn){
			isOn = true;
			try
			{
				Log.i("ledtorch", "CloudLed.java.turnOn()");
				camera = Camera.open();
				Log.i("ledtorch","CloudLed.java.turnOn() 1");
				Camera.Parameters parameters;
				parameters = camera.getParameters();
				Log.i("ledtorch", "CloudLed.java.turnOn() 2");
				parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
				Log.i("ledtorch", "CloudLed.java.turnOn() 3");
				camera.setParameters(parameters);
				Log.i("ledtorch", "CloudLed.java.turnOn() 4");
				
			}
			catch(Exception e){
				
			}
		}
		
	}
	
	public void turnOff(){
		if(isOn){
			isOn = false;
			try{
				Camera.Parameters parameters;
				parameters = camera.getParameters();
				parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
				camera.setParameters(parameters);
				camera.release();
				
			}catch(Exception e){
				
			}
		}
	}

}
