package edu.ycp.android.bowlingconcepts;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.LinkedList;

import android.os.Environment;

public class ImageCache {
	
	public ImageCache()
	{
		//hashTable = new HashMap<Integer, LinkedList<ShirtImage>>();
		imageCache = new LinkedList<ShirtImage>();
		cacheDirectory = Environment.getExternalStorageDirectory().toString();
	}
	
	@SuppressWarnings("unchecked")
	public void preLoad() throws IOException, ClassNotFoundException
	{
		//load the cache from the sd card memory
		//This increases load time but utilizes the sd card instead of ram
		//and decreases memory usage. From my point of view this is better
		InputStream file = new FileInputStream(cacheDirectory + "imageCache.cache");
		if(file != null)
		{
			BufferedInputStream buffer = new BufferedInputStream(file);
			ObjectInputStream input = new ObjectInputStream(buffer);
			imageCache = (LinkedList<ShirtImage>) input.readObject();
		}
	}
	
	public void commitToMemory() throws IOException
	{
		//write the object to a file when the app is exited
		//or when the object is onPause and memory is needed.
		 
		OutputStream file = new FileOutputStream(cacheDirectory+"imageCache.cache");
		OutputStream buffer = new BufferedOutputStream(file);
		ObjectOutput output = new ObjectOutputStream(buffer);
		try
		{
			output.writeObject(imageCache);
		}
		finally
		{
			output.close();
		}
	}
	 
	public void addAll(URL xmlFeed)
	{
		
	}
	
	public void add(String link, String ImageURL, String description) throws IOException{
		ShirtImage temp = new ShirtImage(link, ImageURL, description);
		if(imageCache.contains(temp))
		{
			//do nothing
		}
		else{
			imageCache.add(temp);
		}
		
	}
	
	//private Map<Integer ,ShirtImage> images;
	//private Map<Integer,LinkedList<ShirtImage>> hashTable;
	private LinkedList<ShirtImage> imageCache;
	private String cacheDirectory;
}
