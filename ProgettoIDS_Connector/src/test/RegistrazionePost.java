package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Registrazione;

public class RegistrazionePost {

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
		System.out.println("Test: Registrazione Post Corretto");
		System.out.print("Inserisci il Titolo del post: ");
		String title = util.Read.readString();
		System.out.print("Inserire il Link del post: ");
		String link = util.Read.readString();
		System.out.print("Inserire la Descrizione del post: ");
		String description = util.Read.readString();
		System.out.print("Inserire la Categoria del post: ");
		String category = util.Read.readString();
		System.out.print("Inserisci l'Autore del post : ");
		String author = util.Read.readString();
		String atlantis = "http://atlantis.isti.cnr.it:8080/virtualNoticeBoard/postboard?action=NEWPOST"+"&"+title+"&"+link+"&"+description+"&"+category+"&"+author;
		String expResult = null;
		String result = Registrazione.inviourl(atlantis);
		assertEquals(expResult, result);
	}
}
