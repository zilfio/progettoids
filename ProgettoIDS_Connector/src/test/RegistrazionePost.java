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
		System.out.println("Dove vuoi fare il post?\n1: atlantis - 2: pc-ericlab");
		String bacheca = util.Read.readString();
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
		String uri = new String();
		if(bacheca.equals("1")){
			uri = "http://atlantis.isti.cnr.it:8080/virtualNoticeBoard/postboard?action=NEWPOST"+"&title="+title+"&link="+link+"&description="+description+"&category="+category+"&author="+author;
		}
		else if(bacheca.equals("2")){
			uri = "http://pc-ericlab11.isti.cnr.it:8080/virtualNoticeBoard/postboard?action=NEWPOST"+"&title="+title+"&link="+link+"&description="+description+"&category="+category+"&author="+author;
		}
		String expResult = null;
		String result = Registrazione.inviourl(uri);
		assertEquals(expResult, result);
	}
}
