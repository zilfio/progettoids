package manager;

import java.util.Collection;

import controllo.ControlloPost;

import lettura.LetturaPost;
import rss.FeedMessage;

import util.Read;

public class Connector {

	private String uriA;
	private String uriB;
	private String filter;
	
	
	
	public Connector(String uriA, String uriB, String filter) {
	
		this.uriA = uriA;
		this.uriB = uriB;
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
		System.out.print("Inserisci uri bacheca A: ");
		String uriA = Read.readString();
		System.out.print("Inserisci uri bacheca B: ");
		String uriB = Read.readString();	
		Collection<FeedMessage> postA = LetturaPost.parsingPost(uriA);
		Collection<FeedMessage> postB = LetturaPost.parsingPost(uriB);
		ControlloPost c = new ControlloPost();
		Collection<FeedMessage> postC = c.checkpost(postA, postB);
		System.out.println(c);
		for(FeedMessage m : postC){
			System.out.println(m);
		}
	}
	
}
