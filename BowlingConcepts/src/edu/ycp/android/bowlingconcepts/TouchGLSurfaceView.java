package edu.ycp.android.bowlingconcepts;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

public class TouchGLSurfaceView extends GLSurfaceView {

	public TouchGLSurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		mCubeRender = new VirtualClosetRenderer(context);
		setRenderer(mCubeRender);
		setRenderMode(RENDERMODE_WHEN_DIRTY);
	}

	public boolean onTouchEvent(final MotionEvent event){
		if(event.getPointerCount() > 1)
		{
			return super.onTouchEvent(event);
		}
		else
		{
			float startX = event.getX();

			switch(event.getAction()){
			case (MotionEvent.ACTION_MOVE):
				//endX = event.getX();
				float dx = startX - endX;
			mCubeRender.mAngle += dx*TOUCH_SCALE_FACTOR;

			if(mCubeRender.mAngle < -7.0f)
			{
				mCubeRender.mAngle = 1.0f;
			}
			if(mCubeRender.mAngle >1.0f)
			{
				mCubeRender.mAngle = -7.0f;
			}
			requestRender();
			break;
			default:
				break;
			}

			endX = startX;
			return true;
		}
	}

	public float getAngle()
	{
		return mCubeRender.mAngle;
	}
	private VirtualClosetRenderer mCubeRender;
	private float endX;
	private static final float TOUCH_SCALE_FACTOR = 1.0f/320.0f;
}
