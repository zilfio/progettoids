package inoltro;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import rss.FeedMessage;
import util.Registrazione;

/**
 * 
 * @author Zilfio
 *
 */
public class InoltroPost {
	/**
	 * 
	 * @param post
	 * @param uriAfeed
	 * @param uriBfeed
	 * @param uriA
	 * @param uriB
	 * @return il metodo ritorna true se il post è stato inoltrato correttamente, false altrimenti
	 */
	public static boolean postForward(FeedMessage message, String uriAfeed, String uriBfeed, String uriA, String uriB){
		
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
		
		int uriALength = uriAfeed.length();
		int uriBLength = uriBfeed.length();

			String guid = message.getGuid();
			 if ((uriBLength < guid.length()) && (uriBfeed.equals(guid.substring(0, uriBLength)))){
				 //Sostituire il S.o.P con l'invio dell'uri
				 String uri = uriA + "&title=" + message.getTitle() + "&description="
				 + message.getDescription() + "&link=" + message.getLink() + "&pubDate=" + message.getPubdate();
				 
				 //Controllo Bug Category
				 if ( !(message.getCategory().isEmpty()) )
					 uri = uri + "&category=" + message.getCategory();
				 
				 uri = uri + "&author="+p.getProperty("autore_post");
				 
				 
				 uri = uri.replaceAll(" ", "%20");
				 String inputLine = Registrazione.inviourl(uri);
				 
				 if(inputLine == null){
					 
					 //LOG
					 System.out.println(". Il seguente messaggio è stato propagato dalla bacheca \"B\" alla bacheca \"A\":" + uri);

					 return true;
				 }
				 else {
					 
					 //LOG
					 System.out.println(". Il seguente messaggio non è stato propagato dalla bacheca \"B\" alla bacheca \"A\":" + uri);

					 return false;
					 
				 }
			 }
			 
			 else if((uriALength < guid.length()) && (uriAfeed.equals(guid.substring(0, uriALength)))) {
				 //Sostituire il S.o.P con l'invio dell'uri
				 String uri = uriB + "&title=" + message.getTitle() + "&description="
				 + message.getDescription() + "&link=" + message.getLink() + "&pubDate=" + message.getPubdate();
				 
				 //Controllo Bug Category
				 if ( !(message.getCategory().isEmpty()) )
					 uri = uri + "&category=" + message.getCategory();
				 
				 uri = uri + "&author="+p.getProperty("autore_post");
				 
				 
				 uri = uri.replaceAll(" ", "%20");
				 String inputLine = Registrazione.inviourl(uri);
				 
				 if(inputLine == null){

					 //LOG
					 System.out.println(". Il seguente messaggio è stato propagato dalla bacheca \"A\" alla bacheca \"B\":" + uri);
					 
					 return true;
				 }
				 
				 else{

					 //LOG
					 System.out.println(". Il seguente messaggio non è stato propagato dalla bacheca \"A\" alla bacheca \"B\":" + uri);
					 
					 return false;
					 
				 }
			 }
			return false;
	}
}
