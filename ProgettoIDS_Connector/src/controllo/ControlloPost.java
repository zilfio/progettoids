package controllo;

import java.util.ArrayList;
import java.util.Collection;

import rss.FeedMessage;

public class ControlloPost {
	public static Collection<FeedMessage> checkpost (Collection<FeedMessage>postA, Collection<FeedMessage>postB, String filtro){
		
		Collection<FeedMessage> c = new ArrayList<FeedMessage>();
		boolean trovato = true;
		
		filtro = filtro + ",";
		filtro = filtro.replaceAll(" ", "");
		
		//Controllo da A a B
		if(postA!=null){
			for(FeedMessage f : postA){
				//if (f.getCategory().equals(filtro)){
					trovato = false;
					if(postB!=null){
						for(FeedMessage m : postB){
							if(( (f.getTitle().equals(m.getTitle()) && (f.getDescription().equals(m.getDescription()))) && (f.getCategory().equals(m.getCategory())) )){
								trovato = true;
							}
						}
					}
				//}
				if(trovato == false){
					c.add(f);
				}
			}
		}
		
		
		//Controllo da B ad A
		if(postB!=null){
			for(FeedMessage f : postB){
				//if (f.getCategory().equals(filtro)){
					trovato = false;
					if(postA!=null){
						for(FeedMessage m : postA){
							if(( (f.getTitle().equals(m.getTitle()) && (f.getDescription().equals(m.getDescription())))  && (f.getCategory().equals(m.getCategory())) )){
								trovato = true;
							}
						}
					}
				//}
				if(trovato == false){
					c.add(f);
				}
			}
		}
		return c;
	}
}