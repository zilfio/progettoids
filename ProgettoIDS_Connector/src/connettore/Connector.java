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
		
		//	LOG
		System.out.println ("***Inizio LOG***\n");
		
		
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
		String FILTRO = p.getProperty("filtro");
		
		//	LOG
		System.out.println (". Valori di configurazione caricati correttamente.");
		
		
		//System.out.print("Inserisci l'uri dei Post bacheca A: ");
		//String uriApost = Read.readString();
		//System.out.print("Inserisci l'uri dei Feedback bacheca A: ");
		//String uriAfeed = Read.readString();
		//System.out.print("Inserisci l'uri dei Post bacheca B: ");
		//String uriBpost = Read.readString();	
		//System.out.print("Inserisci l'uri dei Feedback bacheca B: ");
		//String uriBfeed = Read.readString();
		
		
		// LOG
		if(FILTRO.equals("")){
			System.out.println(". Nessun filtro impostato.");
		}
		else{
			System.out.println(". Filtro configurato: "+FILTRO);
		}
		
		// LOG
		System.out.println(". Esecuzione parsing dei Post.");
		
		//Lettura Post di entrambe le bacheche
		Collection<FeedMessage> postA = LetturaPost.parsingPost(URI_A_POST_READ);
		Collection<FeedMessage> postB = LetturaPost.parsingPost(URI_B_POST_READ);
		
		//LOG
		System.out.println(". Esecuzione parsing dei Post conclusa.");
		
		if(postA == null && postB == null){
			
			// LOG
			System.out.println(". Entrambe le bacheche non contengono Post.\n***Fine LOG***");
			
			System.exit(0);
		}
		
		
		//Controllo delle bacheche
		
		//LOG
		System.out.println (". Inizio controllo dei post da propagare.");
		
		Collection<FeedMessage> postC = ControlloPost.checkpost(postA, postB, FILTRO);
		
		//LOG
		System.out.println (". Fine controllo dei post da propagare.");
		
		
		
		//Inoltro nuovi Post
		
		//LOG
		System.out.println (". Inizio propagazione dei post.");
		
		InoltroPost.postForward(postC, URI_A_FEED, URI_B_FEED, URI_A_POST_NEW, URI_B_POST_NEW);
		
		//LOG
		System.out.println (". Fine propagazione dei post.");

		
		
		//Lettura FeedBack dei nuovi Post
		
		//LOG
		System.out.println (". Inizio parsing e propagazione dei feedbacks.");
		for(FeedMessage m : postC){
			if (m != null){
				FeedMessage feed = new FeedMessage();
				String guid2 = m.getGuid();
				guid2 = guid2.replace("?", "?action=READ&");
				feed = LetturaFeedback.parsingFeed(guid2);
				if(feed!=null){
					String guid = InoltroFeedback.findFeedback(m, URI_A_FEED, URI_B_FEED, URI_A_POST_READ, URI_B_POST_READ);
					InoltroFeedback.feedbackForward(feed, guid);
				}
			}
		}
		
		//LOG
		System.out.println(". Fine propagazione dei feedbacks.");
		System.out.println("***Fine LOG***");
	}
}
