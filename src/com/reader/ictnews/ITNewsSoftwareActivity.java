package com.reader.ictnews;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ITNewsSoftwareActivity extends Activity{
	
	private ITNewsSoftwareActivity local;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        // Set view
	        setContentView(R.layout.activity_itnews_main);
	        
	        // Set reference to this activity
	        local=this;
	        
	        GetRSSDataTask task = new GetRSSDataTask();
	         
	        // Start download RSS task
	        task.execute("http://www.itvesti.info/feeds/posts/default/-/Softver?alt=rss");
	         
	        // Debug the thread name
	        Log.d("ICSTRssReader", Thread.currentThread().getName());
	    }
	 
	 private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
	        @Override
	        protected List<RssItem> doInBackground(String... urls) {
	             
	            // Debug the task thread name
	            Log.d("ICTRssReader", Thread.currentThread().getName());
	             
	            try {
	                // Create RSS reader
	                FeedReader rssReader = new FeedReader(urls[0]);
	             
	                // Parse RSS, get items
	                return rssReader.getItems();
	             
	            } catch (Exception e) {
	                Log.e("ICTRssReader", e.getMessage());
	            }
	             
	            return null;
	        }
	        
	        @Override
	        protected void onPostExecute(List<RssItem> result) {
	        	
	        	 // Get a ListView from main view
	            ListView itcItems = (ListView) findViewById(R.id.listView1);
	            
	         // Create a list adapter
	            ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(local,android.R.layout.simple_list_item_1, result);
	            // Set list adapter for the ListView
	            itcItems.setAdapter(adapter);
	            
	         // Set list view item click listener
	            itcItems.setOnItemClickListener(new ListListener(result, local));
	        }
	    }  
}
