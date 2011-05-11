package edu.ycp.android.bowlingconcepts;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Categories extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewlayout);
		
		catagories = new ArrayList<String>();
		catagories.add("Catalog");
		catagories.add("Blog");
		/*
		if(!(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())))
		{
			AlertDialog.Builder sdAlert = new AlertDialog.Builder(Categories.this);
			sdAlert.setTitle("No SD Card inserted");
			sdAlert.setMessage("This app requires an SD card. Please insert an SD card");
			sdAlert.setPositiveButton("okay", new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
				}
			});
			sdAlert.show();
		}
		*/
		listaa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catagories);
		ListView categoryListView = (ListView)findViewById(R.id.listview1);
		categoryListView.setAdapter(listaa);
		
		categoryListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(position == 0)
				{
					Intent myIntent = new Intent(Categories.this, Catalog.class);
					startActivity(myIntent);
				}
				else if (position == 1)
				{
					Intent myIntent = new Intent(Categories.this, BlogActivity.class);
					startActivity(myIntent);
				}
				
			}
		});
	}
	private ArrayList<String> catagories;
	private ArrayAdapter<String> listaa;
}
