package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import lettura.LetturaFeedback;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rss.FeedMessage;

import util.Registrazione;

public class ValutazioneFunzioneTrustInterBacheca {

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
	public void testTrust() {
		System.out.println("Test: Valutazione Funzione di Trust Inter-Bacheca");
		FeedMessage feed = new FeedMessage();
		System.out.println ("Inserire il Guid di un Post: ");
		String guid = util.Read.readString();
		guid = guid.replace("?", "?action=READ&");
		feed = LetturaFeedback.parsingFeed(guid);
		System.out.println ("Inserire il risultato atteso tra: AGREE, PARTIALLY_AGREE, DISAGREE, DETRACTOR.");
		String result = util.Read.readString();
		assertEquals(result, feed.getTitle());
	}

}
