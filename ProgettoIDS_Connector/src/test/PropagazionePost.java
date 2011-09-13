package test;

import static org.junit.Assert.*;

import inoltro.InoltroPost;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

import lettura.LetturaPost;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controllo.ControlloPost;

import rss.FeedMessage;

public class PropagazionePost {

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
	public void testInviourl() {
		System.out.println("Propagazione Post");
		
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

		Collection<FeedMessage> postA = LetturaPost.parsingPost(URI_A_POST_READ);
		Collection<FeedMessage> postB = LetturaPost.parsingPost(URI_B_POST_READ);
		
		//Controllo delle bacheche
		Collection<FeedMessage> postC = ControlloPost.checkpost(postA, postB, FILTRO);
		
		//Inoltro nuovi Post
		boolean result = InoltroPost.postForward(postC, URI_A_FEED, URI_B_FEED, URI_A_POST_NEW, URI_B_POST_NEW);
		
		assertTrue(result);
	}
}
