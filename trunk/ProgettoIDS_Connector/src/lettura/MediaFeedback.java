package lettura;

import java.util.Collection;

import manager.Feedback;


public class MediaFeedback {
	
	  static final String a="AGGREE";
      static final String b="DISAGREE";
      static final String c="PARTIALLY_AGREE";
      static final String d="DETRACTOR";
      
	public static int calcola_media(Collection<Feedback>feedback){
		int feedcount = 0;
		int feedsum = 0;
if(feedback.equals(a)){
	feedsum += 4;
	}else if(feedback.equals(b)){
		feedsum -= 4;
	}	else if(feedback.equals(c)){
		feedsum += 2;
	}else if(feedback.equals(d)){
		
	}
feedcount ++;
	
      return feedsum;
      }



	
	
}

