package edu.ycp.android.bowlingconcepts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import edu.ycp.android.bowlingconcepts.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BlogActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewlayout);
		try {
			blogListener = new HttpListener(new URL("http://feeds.feedburner.com/bowlingconcepts/bvjv?format=xml"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		blogListener.readSite();
		
		LinkedList<ArrayList<String>> temp = blogListener.getSiteText();
		Iterator<ArrayList<String>> itr = temp.iterator();
		
		//blogPosts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, );
		ArrayList<String> tempList = new ArrayList<String>();
		final ArrayList<String> urlList = new ArrayList<String>();
		
		while(itr.hasNext())
		{
			ArrayList<String> temp2 = itr.next();
			tempList.add(temp2.get(0));
			urlList.add(temp2.get(1));
		}
		blogPosts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tempList );
		
		ListView blogListView = (ListView)findViewById(R.id.listview1);
		blogListView.setAdapter(blogPosts);
		
		blogListView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent webIntent = new Intent(BlogActivity.this,PageViewer.class);
				webIntent.putExtra("url", urlList.get(position));
				startActivity(webIntent);
			}
			
		});
	}
	
	private HttpListener blogListener;
	private ArrayAdapter<String> blogPosts;
}
