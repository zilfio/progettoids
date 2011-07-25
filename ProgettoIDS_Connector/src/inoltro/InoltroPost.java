package inoltro;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
					HttpURLConnection uc = (HttpURLConnection)url.openConnection();
					 uc.setDoOutput(true);
					 PrintWriter out = new PrintWriter (uc.getOutputStream());
					 out.println(uri);
				 } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }
				 

				
				
				 
			 }
			 
			 else {
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
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 try {
					HttpURLConnection uc = (HttpURLConnection)url.openConnection();
					 uc.setDoOutput(true);
					 PrintWriter out = new PrintWriter (uc.getOutputStream());
					 out.println(uri);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }

		 }
	}
}
