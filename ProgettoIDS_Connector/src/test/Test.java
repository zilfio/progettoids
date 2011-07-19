package test;

import java.util.Collection;

import rss.FeedMessage;

import lettura.LetturaPost;

public class Test {
	public static void main(String[]args){
		Collection<FeedMessage> c = LetturaPost.parsingPost("http://informatica.di.univaq.it/infoataq.php?fid=rss&pid=193&lid=it");
		System.out.println(c);
	}
}
