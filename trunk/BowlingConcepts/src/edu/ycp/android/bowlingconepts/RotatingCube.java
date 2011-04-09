package edu.ycp.android.bowlingconepts;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;

public class RotatingCube extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		mGLSurfaceView = new TouchGLSurfaceView(this);
		//mGLSurfaceView.setRenderer(new CubeRenderer(this));
		
	
		setContentView(mGLSurfaceView);
		//mGLSurfaceView.setOnClickListener(this);
		
	}
	@Override
    protected void onResume()
    {
    	super.onResume();
    	mGLSurfaceView.onResume();
    }
    
    @Override
    protected void onPause()
    {
    	super.onPause();
    	mGLSurfaceView.onPause();
    }
    
    public boolean onTouchEvent(MotionEvent e)
    {
		float startX = (e.getX(0) + e.getX(1))/2.0f;
		switch(e.getAction())
		{
		case(MotionEvent.ACTION_MOVE):
			if(startX < endX)
			{
				finish();
				Intent myIntent = new Intent(RotatingCube.this, Catalog.class);
				RotatingCube.this.startActivity(myIntent);
			}
			break;
		default:
			break;
		}
		endX = startX;
		return true;
    }
    
	private GLSurfaceView mGLSurfaceView;
	private float endX;
}
