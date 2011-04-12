package edu.ycp.android.bowlingconcepts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		Thread splashThread = new Thread(){
			@Override
			public void run() {
				try{
					int waited =0;
					while(waited < 3000){
						sleep(100);
						waited += 100;
					}
				}catch(Exception e)
				{
					
				}finally{
					finish();
					Intent myIntent = new Intent(SplashActivity.this, Catalog.class);
					SplashActivity.this.startActivity(myIntent);
				}
			}

		};
		splashThread.start();
	}
}
