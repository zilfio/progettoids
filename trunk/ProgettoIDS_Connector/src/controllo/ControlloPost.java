package controllo;

import java.util.ArrayList;
import java.util.Collection;

import rss.FeedMessage;

public class ControlloPost {
	public Collection<FeedMessage> checkpost (Collection<FeedMessage>postA, Collection<FeedMessage>postB){
		//controllo da 'a' a 'b'
		Collection<FeedMessage> c = new ArrayList<FeedMessage>();
		boolean trovato;
		for(FeedMessage f : postA){
			trovato = false;
			for(FeedMessage m : postB){
				if(!(f.getTitle().equals(m.getTitle())) && !trovato){
					trovato = true;
					c.add(f);
				}
			}
		}
		return c;
	}
}
