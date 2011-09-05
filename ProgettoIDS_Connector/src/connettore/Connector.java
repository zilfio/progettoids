package connettore;

import inoltro.InoltroFeedback;
import inoltro.InoltroPost;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import controllo.ControlloPost;

import lettura.LetturaFeedback;
import lettura.LetturaPost;
import rss.FeedMessage;

public class Connector {
	public static void main(String args[]){
		
		//Carichiamo la Configurazione
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
		
		/* Recuperiamo il valore della proprietà */
		String URI_A_POST = p.getProperty("uri_post_bacheca_a");
		String URI_A_POST_READ = p.getProperty("uri_post_bacheca_a") +  p.getProperty("action_readpost");
		String URI_A_POST_NEW = p.getProperty("uri_post_bacheca_a") +  p.getProperty("action_newpost");
		String URI_A_FEED = p.getProperty("uri_feedback_bacheca_a");
		String URI_A_FEED_READ = p.getProperty("uri_feedback_bacheca_a") +  p.getProperty("action_readfeed");
		String URI_A_FEED_NEW = p.getProperty("uri_feedback_bacheca_a") +  p.getProperty("action_newfeed");
		String URI_B_POST = p.getProperty("uri_post_bacheca_b");
		String URI_B_POST_READ = p.getProperty("uri_post_bacheca_b") +  p.getProperty("action_readpost");
		String URI_B_POST_NEW = p.getProperty("uri_post_bacheca_b") +  p.getProperty("action_newpost");
		String URI_B_FEED = p.getProperty("uri_feedback_bacheca_b");
		String URI_B_FEED_READ = p.getProperty("uri_feedback_bacheca_b") +  p.getProperty("action_readfeed");
		String URI_B_FEED_NEW = p.getProperty("uri_feedback_bacheca_b") +  p.getProperty("action_newfeed");
		
		//System.out.print("Inserisci l'uri dei Post bacheca A: ");
		//String uriApost = Read.readString();
		//System.out.print("Inserisci l'uri dei Feedback bacheca A: ");
		//String uriAfeed = Read.readString();
		//System.out.print("Inserisci l'uri dei Post bacheca B: ");
		//String uriBpost = Read.readString();	
		//System.out.print("Inserisci l'uri dei Feedback bacheca B: ");
		//String uriBfeed = Read.readString();
		
		System.out.println("Eseguo lettura post!");
		
		//Lettura Post di entrambe le bacheche
		Collection<FeedMessage> postA = LetturaPost.parsingPost(URI_A_POST_READ);
		Collection<FeedMessage> postB = LetturaPost.parsingPost(URI_B_POST_READ);
		
		System.out.println("Lettura post fine!");
		
		if(postA == null && postB == null){
			System.exit(0);
		}
		
		
		//Controllo delle bacheche
		Collection<FeedMessage> postC = ControlloPost.checkpost(postA, postB);
		
		//Inoltro nuovi Post
		InoltroPost.PostForward(postC, URI_A_FEED, URI_B_FEED, URI_A_POST_NEW, URI_B_POST_NEW);
		
		//Lettura FeedBack dei nuovi Post
		
		for(FeedMessage m : postC){
			if (m != null){
				FeedMessage feed = new FeedMessage();
				String guid2 = m.getGuid();
				guid2 = guid2.replace("?", "?action=READ&");
				System.out.println("Guid2: "+guid2);
				feed = LetturaFeedback.parsingFeed(guid2);
				System.out.println("Feed: "+feed);
				if(feed!=null){
					System.out.println("diverso da null");
					String guid = InoltroFeedback.findFeedback(m, URI_A_FEED, URI_B_FEED, URI_A_POST_READ, URI_B_POST_READ);
					System.out.println("Guid: "+guid);
					InoltroFeedback.feedbackForward(feed, guid);
				}
			}
		}
	}
}
