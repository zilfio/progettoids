package controllo;

import java.util.ArrayList;
import java.util.Collection;

import rss.FeedMessage;

public class ControlloPost {
	public static Collection<FeedMessage> checkpost (Collection<FeedMessage>postA, Collection<FeedMessage>postB){
		
		Collection<FeedMessage> c = new ArrayList<FeedMessage>();
		boolean trovato;
		
		//Controllo da A a B
		if(postA!=null){
			for(FeedMessage f : postA){
				trovato = false;
				if(postB!=null){
					for(FeedMessage m : postB){
						if((f.getTitle().equals(m.getTitle()))){
							trovato = true;
						}
					}
				}
				if(!trovato){
					c.add(f);
				}
			}
		}
		
		
		//Controllo da B ad A
		if(postB!=null){
			for(FeedMessage f : postB){
				trovato = false;
				if(postA!=null){
					for(FeedMessage m : postA){
						if((f.getTitle().equals(m.getTitle()))){
							trovato = true;
						}
					}
				}
				if(!trovato){
					c.add(f);
				}
			}
		}
		return c;
	}
}