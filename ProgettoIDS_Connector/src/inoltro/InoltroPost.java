package inoltro;

import java.util.Collection;

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
				 
				 uri = uri + "&author=Connector";
				 
				 
				 uri = uri.replaceAll(" ", "%20");
				 
				 //LOG
				 System.out.println(". Il seguente messaggio è stato propagato dalla bacheca \"B\" alla bacheca \"A\":" + uri);
				 
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
				 if ( !(message.getAuthor().isEmpty()) )
					 uri = uri + "&author=" + message.getAuthor();
				 
				 
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
