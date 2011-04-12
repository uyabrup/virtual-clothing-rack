package edu.ycp.android.bowlingconcepts;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Quad {
	private FloatBuffer mVertexBuffer;
	private FloatBuffer mTextureBuffer;
	private ByteBuffer mIndexBuffer;

	

	private float vertices[] = {
			-1.0f, -1.0f,  1.0f,  // 0. left-bottom
			1.0f, -1.0f,  1.0f,  // 1. right-bottom
			-1.0f,  1.0f,  1.0f,  // 2. left-top
			1.0f,  1.0f,  1.0f   // 3. right-top
	};

	private float texture[] = {
			0.0f,0.0f,
			0.0f,1.0f,
			1.0f,0.0f,
			1.0f,1.0f
	};

	private byte indices[] = {
			0,1,3,	0,3,2
	};

	public Quad()
	{
		ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
		vbb.order(ByteOrder.nativeOrder());
		mVertexBuffer = vbb.asFloatBuffer();
		mVertexBuffer.put(vertices);
		mVertexBuffer.position(0);

		ByteBuffer tbb = ByteBuffer.allocateDirect(texture.length * 4);
		tbb.order(ByteOrder.nativeOrder());
		mTextureBuffer = tbb.asFloatBuffer();
		mTextureBuffer.put(texture);
		mTextureBuffer.position(0);

		mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
		mIndexBuffer.put(indices);
		mIndexBuffer.position(0);
	}



	public void draw(GL10 gl, int tex)
	{
		//gl.glBindTexture(0, textureptr[tex]);

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		gl.glFrontFace(GL10.GL_CCW);

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
		gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, mTextureBuffer);

		gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, mIndexBuffer);

		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
	}
}
