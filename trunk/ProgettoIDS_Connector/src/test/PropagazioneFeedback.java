package test;

import static org.junit.Assert.*;
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
		System.out.println("Test: Propagazione Feedback");
		FeedMessage feed = new FeedMessage();
		System.out.println ("Inserire il Titolo del commento: ");
		feed.setTitle(util.Read.readString());
		System.out.println ("Inserire la Descrizione del commento: ");
		feed.setTitle(util.Read.readString());
		System.out.println ("Inserire l'Autore del commento: ");
		feed.setTitle(util.Read.readString());
		System.out.println ("Inserire il Guid del post da commentare: ");
		String guid = util.Read.readString();
		Boolean result = InoltroFeedback.feedbackForward(feed, guid);
		assertTrue(result);
	}

}
