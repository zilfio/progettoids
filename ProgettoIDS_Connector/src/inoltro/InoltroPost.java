package inoltro;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;

import rss.FeedMessage;


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
				 + message.getDescription() + "&link=" + message.getLink() + "&category=" + message.getCategory()
				 + "&author=" + message.getAuthor() + "&pubDate=" + message.getPubdate();
				 uri = uri.replaceAll(" ", "%20");
				 
				 System.out.println(uri);
				 URL url = null;
				 try {
					url = new URL(uri);
				 } catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				 }
				 try {
					URLConnection yc = url.openConnection();
					yc.connect();
				 } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }		 
			 }
			 
			 else if((uriALength < guid.length()) && (uriAfeed.equals(guid.substring(0, uriALength)))) {
				 //Sostituire il S.o.P con l'invio dell'uri
				 System.out.println ("Fa parte della bacheca A");
				 String uri = uriB + "&title=" + message.getTitle() + "&description="
				 + message.getDescription() + "&link=" + message.getLink() + "&category=" + message.getCategory()
				 + "&author=" + message.getAuthor() + "&pubDate=" + message.getPubdate();
				 uri = uri.replaceAll(" ", "%20");

				 System.out.println(uri);
				 
				 URL url = null;
				try {
					url = new URL(uri);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 try {
					URLConnection yc = url.openConnection();
					yc.connect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }

		 }
	}
}
