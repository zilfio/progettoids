package inoltro;

import java.util.Collection;

import rss.FeedMessage;

import manager.Post;


public class InoltroPost {
	public static void PostForward(Collection<FeedMessage>post, String uriBfeed, String uriA, String uriB){
		
		int uriLength = uriBfeed.length();
		for (FeedMessage message : post) {
			String guid = message.getGuid();
			 if ((uriLength < guid.length()) && (uriBfeed.equals(guid.substring(0, uriLength)))){
				 //Sostituire il S.o.P con l'invio dell'uri
				 System.out.println ("Fa parte della bacheca B");
				 String uri = uriA + "?action=NEWPOST" + "&title=" + message.getTitle() + "&description="
				 + message.getDescription() + "&link=" + message.getLink() + "&category=" + message.getCategory()
				 + "&author=" + message.getAuthor() + "&pubDate=" + message.getPubdate();
				 uri = uri.replaceAll(" ", "%20");
				 System.out.println(uri);
				 
			 }
			 
			 else {
				 //Sostituire il S.o.P con l'invio dell'uri
				 System.out.println ("Fa parte della bacheca A");
				 String uri = uriB + "?action=NEWPOST" + "&title=" + message.getTitle() + "&description="
				 + message.getDescription() + "&link=" + message.getLink() + "&category=" + message.getCategory()
				 + "&author=" + message.getAuthor() + "&pubDate=" + message.getPubdate();
				 uri = uri.replaceAll(" ", "%20");
				 System.out.println(uri);
				 
			 }

		 }
	}
}
