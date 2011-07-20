package controllo;

import java.util.ArrayList;
import java.util.Collection;

import rss.FeedMessage;

public class ControlloPost {
	public Collection<FeedMessage> checkpost (Collection<FeedMessage>postA, Collection<FeedMessage>postB){

		Collection<FeedMessage> c = new ArrayList<FeedMessage>();
		boolean trovato;
		
		//Controllo da A a B
		for(FeedMessage f : postA){
			trovato = false;
			for(FeedMessage m : postB){
				if((f.getTitle().equals(m.getTitle()))){
					trovato = true;
				}
			}
			if(!trovato){
				c.add(f);
			}
		}
		
		//Controllo da B ad A
		for(FeedMessage f : postB){
			trovato = false;
			for(FeedMessage m : postA){
				if((f.getTitle().equals(m.getTitle()))){
					trovato = true;
				}
			}
			if(!trovato){
				c.add(f);
			}
		}
		
		
		return c;
	}
}
