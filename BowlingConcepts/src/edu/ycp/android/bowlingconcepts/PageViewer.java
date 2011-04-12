package edu.ycp.android.bowlingconcepts;

import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PageViewer extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weblayout);
		WebView mWebView = (WebView) findViewById(R.id.webview1);
		mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.getSettings().setAppCacheEnabled(true);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setPluginsEnabled(true);
		mWebView.setWebViewClient(new PageViewerWebClient());
		
		Bundle extras = getIntent().getExtras();
		@SuppressWarnings("unused")
		URL url;
		if(extras != null)
		{
			mWebView.loadUrl(extras.getString("url"));
		}
		
	
	}
	private class PageViewerWebClient extends WebViewClient{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url){
			view.loadUrl(url);
			return true;
		}
	}
}
