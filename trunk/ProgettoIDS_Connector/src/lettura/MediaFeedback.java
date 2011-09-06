package lettura;

import java.util.Collection;

import rss.FeedMessage;



public class MediaFeedback {
	
	  static final String a="AGGREE";
      static final String b="DISAGREE";
      static final String c="PARTIALLY_AGREE";
      static final String d="DETRACTOR";
      
	public static String calcola_media(Collection<FeedMessage>feedback){
		int feedcount = 0;
		int feedsum = 0;
		String average = new String();
		System.out.println("sto qui");
		for(FeedMessage f : feedback){
			if (f != null){
				if (f.getTitle().equals("AGREE")){
					feedcount++;
					feedsum += 4;
				}
				
				else if(f.getTitle().equals("DISAGREE")){
					feedcount++;
					feedsum -= 4;
				}
				
				else if(f.getTitle().equals("PARTIALLY_AGREE")){
					feedcount++;
					feedsum += 2;
				}
				
				else if(f.getTitle().equals("DECTRACTOR")){
					feedcount++;
					feedsum -= 8;
				}
			}
			
		}
		
		feedsum = (int)(feedsum/feedcount);
		System.out.println("Feedsum: "+feedsum);
		
		if (feedsum < -4){
			average = "DETRACTOR";
		}
		else if (feedsum < 0 && feedsum >= -4){
			average = "DISAGREE";
		}
		else if (feedsum >= 0 && feedsum < 4){
			average = "PARTIALLY_AGREE";
		}
		else if (feedsum >= 4){
			average = "AGREE";
		}
		System.out.println("Average: "+average);
		return average;
    }	
}