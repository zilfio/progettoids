package lettura;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import rss.FeedMessage;

/**
 * 
 * @author Zilfio
 *
 */
public class LetturaFeedback {
	/*
	static final String a="AGREE";
    static final String b="DISAGREE";
    static final String c="PARTIALLY_AGREE";
    static final String d="DETRACTOR";
    */
    
	/**
	 * 
	 * @param guid
	 * @return il metodo ritorna il sunto(feedback univoco) se esiste almeno un commento, null altrimenti
	 */
	public static FeedMessage parsingFeed(String guid){
		Collection<FeedMessage> feedToT = LetturaPost.parsingPost(guid);
		if ((feedToT != null)){
			

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
			
			/* Creiamo l'oggetto istanza della classe properties */
			Properties p  = new Properties();
			
			/* Creiamo un oggetto File a cui passiamo come parametro */
			/* il path del file di properties */
			File f = new File("./config.properties");
			
			/* Carichiamo lo stream nell'oggetto properties */
			try {
				p.load(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			feed.setAuthor(p.getProperty("autore_commento"));
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