package lettura;

import java.util.ArrayList;
import java.util.Collection;

import rss.FeedMessage;

import manager.Feedback;
import manager.Post;



public class LetturaFeedback {
	public static FeedMessage parsingFeed(String guid){
		
		Collection<FeedMessage> feedToT = LetturaPost.parsingPost(guid);
		String media = MediaFeedback.calcola_media(feedToT);
		
		// creazione feedback univoco
		FeedMessage feed = new FeedMessage();
		feed.setDescription("Media Matematica Personalizzata");
		feed.setAuthor("Connector");
		feed.setTitle(media);
		
		return feed;
	}
}