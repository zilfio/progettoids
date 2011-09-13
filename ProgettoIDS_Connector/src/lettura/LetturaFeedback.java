package lettura;

import java.util.Collection;

import rss.FeedMessage;

/**
 * 
 * @author Zilfio
 *
 */
public class LetturaFeedback {
	
	static final String a="AGGREE";
    static final String b="DISAGREE";
    static final String c="PARTIALLY_AGREE";
    static final String d="DETRACTOR";
    
	/**
	 * 
	 * @param guid
	 * @return il metodo ritorna il sunto(feedback univoco) se esiste almeno un commento, null altrimenti
	 */
	public static FeedMessage parsingFeed(String guid){
		Collection<FeedMessage> feedToT = LetturaPost.parsingPost(guid);
		if (!(feedToT.isEmpty())){
			

			//LOG
			System.out.println(". Sono presenti " + feedToT.size() + " feedback per il post: "+ guid);
		}

		try{
			
			//LOG
			System.out.println (". Generazione del feedback di sunto per il post: "+ guid);
			
			String media = calcola_media(feedToT);
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
	
	/**
     * 
     * @param feedback
     * @return il metodo ritorna la media aritmetica personalizzata
     */
	private static String calcola_media(Collection<FeedMessage>feedback){
		int feedcount = 0;
		int feedsum = 0;
		String average = new String();
		for(FeedMessage f : feedback){
			if (f != null){
				if (f.getTitle().equals("AGREE")){
					feedcount++;
					feedsum += 4;
				}
				
				else if(f.getTitle().equals("DISAGREE")){
					feedcount++;
					feedsum -= 4;
				}
				
				else if(f.getTitle().equals("PARTIALLY_AGREE")){
					feedcount++;
					feedsum += 2;
				}
				
				else if(f.getTitle().equals("DECTRACTOR")){
					feedcount++;
					feedsum -= 8;
				}
			}
			
		}
		
		feedsum = (int)(feedsum/feedcount);
		System.out.println("Feedsum: "+feedsum);
		
		if (feedsum < -4){
			average = "DETRACTOR";
		}
		else if (feedsum < 0 && feedsum >= -4){
			average = "DISAGREE";
		}
		else if (feedsum >= 0 && feedsum < 4){
			average = "PARTIALLY_AGREE";
		}
		else if (feedsum >= 4){
			average = "AGREE";
		}
		System.out.println("Average: "+average);
		return average;
    }
}