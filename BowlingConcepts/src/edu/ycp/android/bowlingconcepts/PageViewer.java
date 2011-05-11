package edu.ycp.android.bowlingconcepts;

import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class PageViewer extends Activity {
	final Activity activity = this;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.weblayout);
		WebView mWebView = (WebView) findViewById(R.id.webview1);
		mWebView.setWebChromeClient(new WebChromeClient(){
			public void onProgressChanged(WebView view, int progress){
				activity.setTitle("Loading...");
				activity.setProgress(progress*100);
				if(progress == 100){
					activity.setTitle(R.string.app_name);
				}
			}
		});
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
