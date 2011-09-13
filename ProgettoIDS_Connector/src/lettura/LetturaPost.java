package lettura;

import java.util.ArrayList;
import java.util.Collection;

import rss.Feed;
import rss.FeedMessage;
import rss.RSSFeedParser;

/**
 * 
 * @author Zilfio
 *
 */
public class LetturaPost {
	
	/**
	 * 
	 * @param uri
	 * @return il metodo ritorna una collezione di FeedMessage
	 */
	 public static Collection<FeedMessage> parsingPost(String uri){
		 try{
			 RSSFeedParser parser = new RSSFeedParser(uri);
			 Feed feed = parser.readFeed();
			 Collection<FeedMessage> post = new ArrayList<FeedMessage>();
			 for (FeedMessage message : feed.getMessages()) {
				 post.add(message);
			 }
			 return post;
		 }
		 
		 catch(NullPointerException e){
			 
			 // LOG
			 System.out.println(". Non ci sono elementi nella bacheca: " + uri);
			 
			 return null;
		 }
		 catch(RuntimeException e){
			 return null;
		 }
	 }
	 
}
