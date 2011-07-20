package manager;

import inoltro.InoltroPost;

import java.util.ArrayList;
import java.util.Collection;

import controllo.ControlloPost;

import lettura.LetturaFeedback;
import lettura.LetturaPost;
import rss.FeedMessage;

import util.Read;

public class Connector {

	private String uriA;
	private String uriB;
	private String uriAfeed;
	private String uriBfeed;
	private String filter;
	
	
	
	public Connector(String uriA, String uriB, String uriAfeed, String uriBfeed, String filter) {
	
		this.uriA = uriA;
		this.uriB = uriB;
		this.uriAfeed = uriAfeed;
		this.uriBfeed = uriBfeed;
		this.filter = filter;
	}
	public String getUriA() {
		return uriA;
	}
	public void setUriA(String uriA) {
		this.uriA = uriA;
	}
	public String getUriB() {
		return uriB;
	}
	
	public String getUriAfeed() {
		return uriAfeed;
	}
	
	public String getUriBfeed() {
		return uriBfeed;
	}
	public void setUriBfeed(String uriBfeed) {
		this.uriBfeed = uriBfeed;
	}
	
	public void setUriAfeed(String uriAfeed) {
		this.uriAfeed = uriAfeed;
	}
	public void setUriB(String uriB) {
		this.uriB = uriB;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public static void main(String args[]){
		
		//Configurazione
		System.out.print("Inserisci l'uri dei Post bacheca A: ");
		String uriA = Read.readString();
		System.out.print("Inserisci l'uri dei Feedback bacheca A: ");
		String uriAfeed = Read.readString();
		System.out.print("Inserisci l'uri dei Post bacheca B: ");
		String uriB = Read.readString();	
		System.out.print("Inserisci l'uri dei Feedback bacheca B: ");
		String uriBfeed = Read.readString();
		
		//Lettura Post di entrambe le bacheche
		Collection<FeedMessage> postA = LetturaPost.parsingPost(uriA);
		Collection<FeedMessage> postB = LetturaPost.parsingPost(uriB);
		
		//Controllo delle bacheche
		ControlloPost c = new ControlloPost();
		Collection<FeedMessage> postC = c.checkpost(postA, postB);
		
		//Inoltro nuovi Post
		InoltroPost.PostForward(postC, uriBfeed, uriA, uriB);
		
		//Lettura FeedBack dei nuovi Post
		/*for(FeedMessage m : postC){
			if (m != null){
				FeedMessage feed = new FeedMessage();
				feed = LetturaFeedback.parsingFeed(m.getGuid());
				
				
				
			}
		}*/
		
		
		//System.out.println(c);
		for(FeedMessage m : postC){
			if(m == null){
				System.out.println("null");
			}
			else{
				System.out.println(m.getTitle());
			}
		}
	}


	
}
