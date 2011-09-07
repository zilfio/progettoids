package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Registrazione;

public class RegistrazioneFeedback {

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
		System.out.println("Test: Registrazione Feedback Corretto");
		System.out.print("Inserisci Guid: ");
		String guid = util.Read.readString();
		System.out.print("Inserisci Title: ");
		String title = util.Read.readString();
		System.out.print("Inserisci Description: ");
		String description = util.Read.readString();
		String url = guid+"action=NEWCOMMENT"+"&title="+title+"&description="+description;
		String expResult = null;
		String result = Registrazione.inviourl(url);
		assertEquals(expResult, result);
	}
}
