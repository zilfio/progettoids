package lettura;

import java.util.Collection;

import rss.FeedMessage;

/**
 * 
 * @author Zilfio
 *
 */
public class LetturaFeedback {
	/**
	 * 
	 * @param guid
	 * @return il metodo ritorna il sunto(feedback univoco) se esiste almeno un commento, null altrimenti
	 */
	public static FeedMessage parsingFeed(String guid){
		Collection<FeedMessage> feedToT = LetturaPost.parsingPost(guid);
		System.out.println("FeedTot: "+feedToT);
		try{
			String media = MediaFeedback.calcola_media(feedToT);
			System.out.println("Media: "+media);
			// creazione feedback univoco
			FeedMessage feed = new FeedMessage();
			feed.setDescription("Media Matematica Personalizzata");
			feed.setAuthor("Connector");
			feed.setTitle(media);
			
			return feed;
		}
		catch(NullPointerException e){
			return null;
		}
		
	}
}