package edu.ycp.android.bowlingconepts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import android.app.Activity;
import android.os.Bundle;

public class BlogActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		try {
			blogListener = new HttpListener(new URL("http://feeds.feedburner.com/bowlingconcepts/bvjv?format=xml"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		blogListener.readSite();
		
		LinkedList<ArrayList<String>> temp = blogListener.getSiteText();
		Iterator<ArrayList<String>> itr = temp.iterator();
		
		while(itr.hasNext())
		{
			ArrayList<String> temp2 = itr.next();
			
			//TODO: more stuff with Strings and adapters
			
		}
		
	}
	
	private HttpListener blogListener;
}
