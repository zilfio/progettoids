package inoltro;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;

import rss.FeedMessage;
import lettura.LetturaPost;
import manager.Feedback;
import manager.Post;


public class InoltroFeedback {
	public static String findFeedback (FeedMessage post, String urifeedA, String urifeedB, String uriA, String uriB){
		
		String guid = post.getGuid();
		int uriAfeedlength = urifeedA.length();
		if(urifeedA==(guid.substring(0, uriAfeedlength))){
			Collection<FeedMessage> postB = new ArrayList<FeedMessage>();
			postB = LetturaPost.parsingPost(uriB);
			
			for(FeedMessage message:postB){
				if(post.getTitle() == message.getTitle() && post.getDescription() == message.getDescription()){
					return message.getGuid();
				}
			}
		}
		else if(urifeedA!=(guid.substring(0, uriAfeedlength))){
			Collection<FeedMessage> postA = new ArrayList<FeedMessage>();
			postA = LetturaPost.parsingPost(uriA);
			
			for(FeedMessage message:postA){
				if(post.getTitle() == message.getTitle() && post.getDescription() == message.getDescription()){
					return message.getGuid();
				}
			}
		}
		return null;
	}
	
	public static void feedbackForward(FeedMessage feedback,String guid){
		String uri = (guid + "&author=" + feedback.getAuthor() + "&title=" + feedback.getTitle() + "&description=" + feedback.getDescription());
		uri = uri.replaceAll(" ", "%20");
		
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
	

