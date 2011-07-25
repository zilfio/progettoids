package lettura;

import java.util.Collection;

import rss.FeedMessage;

import manager.Feedback;


public class MediaFeedback {
	
	  static final String a="AGGREE";
      static final String b="DISAGREE";
      static final String c="PARTIALLY_AGREE";
      static final String d="DETRACTOR";
      
	public static String calcola_media(Collection<FeedMessage>feedback){
		int feedcount = 0;
		int feedsum = 0;
		String average = new String();
		
		for(FeedMessage f : feedback){
			if (f != null){
				if (f.getTitle() == "AGREE"){
					feedcount ++;
					feedsum += 4;
				}
				
				else if(f.getTitle() == "DISAGREE"){
					feedcount ++;
					feedsum -= 4;
				}
				
				else if(f.getTitle() == "PARTIALLY AGREE"){
					feedcount ++;
					feedsum += 2;
				}
				
				else if(f.getTitle() == "DECTRACTOR"){
					feedcount ++;
					feedsum -= 8;
				}
			}
			
		}
		
		feedsum = (int)(feedsum/feedcount);
		
		if (feedsum < -4){
			average = "DETRACTOR";
		}
		else if (feedsum < 0 && feedsum >= -4){
			average = "DISAGREE";
		}
		else if (feedsum >= 0 && feedsum < 4){
			average = "PARTIALLY AGREE";
		}
		else if (feedsum >= 4){
			average = "AGREE";
		}
		return average;
	    }	
}