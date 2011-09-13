package inoltro;

import java.util.ArrayList;
import java.util.Collection;

import rss.FeedMessage;
import util.Registrazione;
import lettura.LetturaPost;

/**
 * 
 * @author Zilfio
 *
 */
public class InoltroFeedback {
	/**
	 * 
	 * @param post
	 * @param urifeedA
	 * @param urifeedB
	 * @param uriA
	 * @param uriB
	 * @return il metodo ritorna il guid del messaggio se è stato trovato il feedback, null altrimenti
	 */
	public static String findFeedback (FeedMessage post, String urifeedA, String urifeedB, String uriA, String uriB){
		
		String guid = post.getGuid();		
		
		//Controllo presenza post originale in Bacheca A o B
		int uriAfeedlength = urifeedA.length();

		if(urifeedA.equals(guid.substring(0, uriAfeedlength))){
			Collection<FeedMessage> postB = LetturaPost.parsingPost(uriB);
			
			for(FeedMessage message:postB){
				if(post.getTitle().equals(message.getTitle()) && post.getDescription().equals(message.getDescription()) ){
					return message.getGuid();
				}
			}
		}
		else if( !(urifeedA.equals(guid.substring(0, uriAfeedlength - 1))) ){
			Collection<FeedMessage> postA = new ArrayList<FeedMessage>();
			postA = LetturaPost.parsingPost(uriA);
			
			for(FeedMessage message:postA){
				if(post.getTitle().equals(message.getTitle()) && post.getDescription().equals(message.getDescription()) ){
					return message.getGuid();
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param feedback
	 * @param guid
	 */
	public static boolean feedbackForward(FeedMessage feedback,String guid){
		guid = guid.replace("?", "?action=NEWCOMMENT&");
		String uri = (guid + "&author=" + feedback.getAuthor() + "&title=" + feedback.getTitle() + "&description=" + feedback.getDescription());
		uri = uri.replaceAll(" ", "%20");
		
		String inputLine = Registrazione.inviourl(uri);
		 
		 if(inputLine == null){
			 return true;
		 }
		return false;
	}
}
	

