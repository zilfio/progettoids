package lettura;

import java.util.ArrayList;
import java.util.Collection;

import rss.Feed;
import rss.FeedMessage;
import rss.RSSFeedParser;

public class LetturaPost {
	
	/**
	 * 
	 * @param uri
	 * @return
	 */
	 public static Collection<FeedMessage> parsingPost(String uri){
		 
		 RSSFeedParser parser = new RSSFeedParser(uri);
		 Feed feed = parser.readFeed();
		 Collection<FeedMessage> post = new ArrayList<FeedMessage>();
		 for (FeedMessage message : feed.getMessages()) {
			 post.add(message);

		 }
		 return post;
	 }
	 
}
