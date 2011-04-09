package edu.ycp.android.bowlingconepts;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;
import android.opengl.GLUtils;
public class VirtualClosetRenderer implements GLSurfaceView.Renderer {

    private Quad mQuad;
    public float mAngle;
    private Context mContext;
    private int texID[];
    private int[] textureptr1 = new int[5];
    
	public VirtualClosetRenderer(Context context)
	{
		//mCube = new Cube();
		mQuad = new Quad();
		mAngle = 0.0f;
		mContext = context;
		texID = new int[5];
		texID[0] = R.drawable.coolshirt;
		texID[1] = R.drawable.hotshirt;
		texID[2] = R.drawable.fooshirt;
		texID[3] = R.drawable.shirt;
		texID[4] = R.drawable.closet;
	}
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glTranslatef(mAngle + 0.0f, 0, -5.0f);
		gl.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
		gl.glScalef(0.8f, 0.8f, 0.8f);
		
		
		
		//gl.glActiveTexture(0);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureptr1[0]);
		mQuad.draw(gl,0);
		
		gl.glLoadIdentity();
		gl.glTranslatef(mAngle + 2.0f, 0, -5.0f);
		gl.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
		gl.glScalef(0.8f, 0.8f, 0.8f);
		
		//gl.glActiveTexture(1);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureptr1[1]);
		mQuad.draw(gl,1);
		
		gl.glLoadIdentity();
		gl.glTranslatef(mAngle + 4.0f, 0, -5.0f);
		gl.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
		gl.glScalef(0.8f, 0.8f, 0.8f);
		
		
		//gl.glActiveTexture(2);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureptr1[2]);
		mQuad.draw(gl,2);
		
		gl.glLoadIdentity();
		gl.glTranslatef(mAngle + 6.0f, 0, -5.0f);
		gl.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
		gl.glScalef(0.8f, 0.8f, 0.8f);
		
		
		//gl.glActiveTexture(3);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureptr1[3]);
		mQuad.draw(gl,3);
		
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, 0, -10.0f);
		gl.glRotatef(0.0f, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
		gl.glScalef(4.0f, 4.0f, 4.0f);
		
		
		//gl.glActiveTexture(3);
		gl.glBindTexture(GL10.GL_TEXTURE_2D, textureptr1[4]);
		mQuad.draw(gl,4);
		
		//mAngle +=1.2f;
		
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		gl.glViewport(0, 0, width, height);
		
		float ratio = (float) width / height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		//gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
		GLU.gluPerspective(gl, 45.0f, ratio, 0.1f, 100.0f);
	}

	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// TODO Auto-generated method stub
		//gl.glDisable(GL10.GL_DITHER);
		//mQuad.loadTexture(gl, mContext, texID);

		
	    gl.glEnable(GL10.GL_TEXTURE_2D);         //Enable Texture Mapping ( NEW )
	    gl.glShadeModel(GL10.GL_SMOOTH);          //Enable Smooth Shading
	    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);    //Yellow Background
	    gl.glClearDepthf(1.0f);                //Depth Buffer Setup
	    gl.glEnable(GL10.GL_DEPTH_TEST);          //Enables Depth Testing
	    gl.glDepthFunc(GL10.GL_LEQUAL);          //The Type Of Depth Testing To Do
	    gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA); //enable transparency
	    gl.glEnable(GL10.GL_BLEND); //enable transparency blending
	    gl.glEnable(GL10.GL_CULL_FACE);
		
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                GL10.GL_FASTEST);
		//create the number of textures
		gl.glGenTextures(5, textureptr1, 0);
		// load the textures
		loadTexture(gl, textureptr1, texID[0], 0,256,256);
		loadTexture(gl, textureptr1, texID[1], 1,256,256);
		loadTexture(gl, textureptr1, texID[2], 2, 256,256);
		loadTexture(gl, textureptr1, texID[3], 3, 256,256);
		loadTexture(gl, textureptr1, texID[4], 4, 512,512);
		
		//gl.glBindTexture(0, textureptr1[0]);
		//gl.glBindTexture(1, textureptr1[1]);
		//gl.glBindTexture(2, textureptr1[2]);
		//gl.glBindTexture(3, textureptr1[3]);
	}
	
	public void addToAngle(float amountToAdd)
	{
		if(amountToAdd > 0.0f)
		{
			mAngle += 0.5f;
			if(mAngle > 0.0f)
			{
				mAngle = -4.0f;
			}
		}
		else if(amountToAdd < 0.0f)
		{
			mAngle -= 0.5f;
			if(mAngle < -4.0f)
			{
				mAngle = 0.0f;
			}
		}
		else
		{
			mAngle +=0.0f;
		}
	}
	
	public void loadTexture(GL10 gl, int[] textureptr,  int textureLocation, int offset, int sizeX, int sizeY)
	{
		//int count = 0;
		//for(int i : textureLocation){
			InputStream is = mContext.getResources().openRawResource(textureLocation);
			Bitmap bitmap = null;

			try
			{
				bitmap = BitmapFactory.decodeStream(is);
			}
			finally
			{
				try
				{
					is.close();
					is = null;
				}
				catch(IOException e)
				{

				}
			}
			Bitmap bitmap2 = null;
			bitmap2 = Bitmap.createScaledBitmap(bitmap, sizeX, sizeY,false);
			gl.glBindTexture(GL10.GL_TEXTURE_2D, textureptr[offset]);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT);
			gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT);

			GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap2, 0);
			bitmap.recycle();
		}
	//}
}
