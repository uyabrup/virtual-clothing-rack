package edu.ycp.android.bowlingconcepts;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;

public class RotatingCube extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		mGLSurfaceView = new TouchGLSurfaceView(this);

		setContentView(mGLSurfaceView);

		urlList = new ArrayList<String>();

		urlList.add("http://www.bowlingconcepts.com/shirts-bowling/charlie-sheen-shirt-s/high-roller-bowling-shirt-s.html");
		urlList.add("http://www.bowlingconcepts.com/shirts-bowling/charlie-sheen-shirt-s/card-suit-retro-poker-shirt-s.html");
		urlList.add("http://www.bowlingconcepts.com/shirts-bowling/charlie-sheen-shirt-s/bowling-wear-double-diamond-285.html");
		urlList.add("http://www.bowlingconcepts.com/shirts-bowling/charlie-sheen-shirt-s/retro-bowling-shirt-s-rockafeller-18.html");

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
	public boolean onTouchEvent(final MotionEvent event){
		float startY = (float) ((event.getY(0)+event.getY(1))/2.0);

		switch(event.getAction()){
		case(MotionEvent.ACTION_MOVE):
			if(endY - startY <0)
			{
				AlertDialog.Builder alert = new Builder(RotatingCube.this);
				alert.setTitle("Open Web Page?");
				alert.setMessage("Open description page for this shirt?");
				alert.setPositiveButton("OPEN", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent myIntent = new Intent(RotatingCube.this, PageViewer.class);
						//utilize integer division to get the indices of the shirts
						int temp = (int) ((TouchGLSurfaceView) mGLSurfaceView).getAngle();
						temp =-1* temp /2;
						myIntent.putExtra("url", urlList.get(temp));
						startActivity(myIntent);
					}
				});
				alert.setNegativeButton("CANCEL", null);
				alert.show();
				return true;
			}
		break;
		default:
			break;
		}
		endY = startY;

		return true;
	}
	private ArrayList<String> urlList;
	private GLSurfaceView mGLSurfaceView;
	private float endY;
}
