package test;

import static org.junit.Assert.*;

import java.util.Properties;

import inoltro.InoltroFeedback;
import lettura.LetturaFeedback;

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
		
		/* Recuperiamo il valore della propriet� */
		Properties p  = new Properties();
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
		
		Boolean result = false;
		
		System.out.println("Test: Propagazione Feedback");
		FeedMessage feed = new FeedMessage();
		System.out.println ("Inserire il Guid del post originale (assicurandosi che" +
				" il post sia gi� stato propagato nell'altra bacheca): ");
		String guid2 = util.Read.readString();
		guid2 = guid2.replace("?", "?action=READ&");
		feed = LetturaFeedback.parsingFeed(guid2);
		System.out.println("Feed: "+feed);
		if(feed!=null){
			String guid = InoltroFeedback.findFeedback(guid2, URI_A_FEED, URI_B_FEED, URI_A_POST_READ, URI_B_POST_READ);
			result = InoltroFeedback.feedbackForward(feed, guid);
		}
		assertTrue(result);
	}

}