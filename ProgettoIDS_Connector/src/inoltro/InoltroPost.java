package inoltro;

import java.util.Collection;

import rss.FeedMessage;
import util.Registrazione;


public class InoltroPost {

	public static void PostForward(Collection<FeedMessage>post, String uriAfeed, String uriBfeed, String uriA, String uriB){
		
		int uriALength = uriAfeed.length();
		int uriBLength = uriBfeed.length();
		for (FeedMessage message : post) {
			String guid = message.getGuid();
			 if ((uriBLength < guid.length()) && (uriBfeed.equals(guid.substring(0, uriBLength)))){
				 //Sostituire il S.o.P con l'invio dell'uri
				 System.out.println ("Fa parte della bacheca B");
				 String uri = uriA + "&title=" + message.getTitle() + "&description="
				 + message.getDescription() + "&link=" + message.getLink() + "&pubDate=" + message.getPubdate();
				 
				 //Controllo Bug Category
				 if ( !(message.getCategory().isEmpty()) )
					 uri = uri + "&category=" + message.getCategory();
				 if ( !(message.getAuthor().isEmpty()) )
					 uri = uri + "&author=" + message.getAuthor();
				 
				 
				 uri = uri.replaceAll(" ", "%20");
				 
				 System.out.println(uri);
				 Registrazione.inviourl(uri);
			 }
			 
			 else if((uriALength < guid.length()) && (uriAfeed.equals(guid.substring(0, uriALength)))) {
				 //Sostituire il S.o.P con l'invio dell'uri
				 System.out.println ("Fa parte della bacheca A");
				 String uri = uriB + "&title=" + message.getTitle() + "&description="
				 + message.getDescription() + "&link=" + message.getLink() + "&pubDate=" + message.getPubdate();
				 
				 //Controllo Bug Category
				 if ( !(message.getCategory().isEmpty()) )
					 uri = uri + "&category=" + message.getCategory();
				 if ( !(message.getAuthor().isEmpty()) )
					 uri = uri + "&author=" + message.getAuthor();
				 
				 
				 uri = uri.replaceAll(" ", "%20");

				 System.out.println(uri);
				 Registrazione.inviourl(uri);
			 }

		 }
	}
}
