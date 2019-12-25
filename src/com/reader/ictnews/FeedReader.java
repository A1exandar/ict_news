package com.reader.ictnews;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class FeedReader {
	
	private String rssUrl;

	/**
	 * Constructor
	 * 
	 * @param rssUrl
	 */
	public FeedReader(String rssUrl) {
		this.rssUrl = rssUrl;
	}
	
	/**
	 * Get RSS items.
	 * 
	 * @return
	 */
	public List<RssItem> getItems() throws Exception {
		// SAX parse RSS data
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();

		FeedParser handler = new FeedParser();
		
		saxParser.parse(rssUrl, handler);

		return handler.getItems();
		
	}
	
}
