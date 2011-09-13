package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import inoltro.InoltroFeedback;
import lettura.LetturaFeedback;
import lettura.LetturaPost;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rss.FeedMessage;

public class PropagazioneFeedback {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPropagazioneFeedback() {
		
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
		
		boolean result = false;
		
		System.out.println("Test: Propagazione Feedback");
		FeedMessage feed = new FeedMessage();
		FeedMessage post = new FeedMessage();
		System.out.println ("Inserire il Guid del post originale (assicurandosi che" +
				" il post sia già stato propagato nell'altra bacheca): ");
		String guid2 = util.Read.readString();
		System.out.println("ciao");
		if (guid2.contains(URI_A_FEED)){
			System.out.println("Ci siamo");
			Collection<FeedMessage> postA = LetturaPost.parsingPost(URI_A_POST_READ);
			for (FeedMessage m : postA){
				System.out.println("Ci siamo3");
				if (m.getGuid().equals(guid2)){
					post = m;
				}
			}
		}
		else {
			System.out.println("Ci siamo2");
			Collection<FeedMessage> postB = LetturaPost.parsingPost(URI_B_POST_READ);
			for (FeedMessage m : postB){
				System.out.println("Ci siamo4");
				if (m.getGuid().equals(guid2)){
					post = m;
				}
			}
		}
		guid2 = guid2.replace("?", "?action=READ&");
		System.out.println(guid2);
		feed = LetturaFeedback.parsingFeed(guid2);
		System.out.println("Feed: "+feed);
		if(feed!=null){
			String guid = InoltroFeedback.findFeedback(post, URI_A_FEED, URI_B_FEED, URI_A_POST_READ, URI_B_POST_READ);
			result = InoltroFeedback.feedbackForward(feed, guid);
		}
		assertTrue(result);
	}

}
