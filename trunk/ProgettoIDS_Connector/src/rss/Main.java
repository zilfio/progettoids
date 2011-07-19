package rss;

public class Main {
	public static void main(String[] args) {
		RSSFeedParser parser = new RSSFeedParser(
				"http://informatica.univaq.it/infoataq.php?fid=rss&pid=193&lid=it");
		Feed feed = parser.readFeed();
		System.out.println(feed);
		for (FeedMessage message : feed.getMessages()) {
			
		}
	}
}