package edu.ycp.android.bowlingconcepts;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class Catalog extends Activity{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);        
		setContentView(R.layout.listviewlayout);

		catalogOptions = new ArrayList<String>();
		catalogOptions.add(new String("Bowling Shirts"));
		catalogOptions.add(new String("Billiard Shirts"));
		catalogOptions.add(new String("Retro Polos"));
		
		
		
		aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catalogOptions);
		ListView catalogListView = (ListView) findViewById(R.id.listview1);

		catalogListView.setAdapter(aa);

		catalogListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if(position == 0)
				{
					Toast toast = Toast.makeText(Catalog.this, "Welcome to the Virtual Closet", Toast.LENGTH_SHORT);
					toast.show();
					//finish();
					Intent myIntent = new Intent(Catalog.this, RotatingCube.class);
					Catalog.this.startActivity(myIntent);
				}
				else
				{
					//TODO: Get Rid of this and add something useful in
					AlertDialog.Builder alertTemp = new AlertDialog.Builder(Catalog.this);
					alertTemp.setTitle("Content not here");
					alertTemp.setMessage("TO DO: Add in Content");
					alertTemp.setPositiveButton("OK", null);
					alertTemp.show();
				}
			}
		});

	}

	@Override
	public boolean onTouchEvent(MotionEvent e){
		if(e.getPointerCount() >1){
			float startX = (e.getX(0) + e.getX(1))/2.0f;
			switch(e.getAction())
			{
			case(MotionEvent.ACTION_MOVE):
				if(startX < endX)
				{
					finish();
				}
			break;
			default:
				break;
			}
			endX = startX;
		}
		return true;
	}

	private ArrayAdapter<String> aa;
	private ArrayList<String> catalogOptions;
	private float endX;
}