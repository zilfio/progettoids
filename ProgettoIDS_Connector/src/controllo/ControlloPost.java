package controllo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import rss.FeedMessage;

/**
 * 
 * @author Zilfio
 *
 */
public class ControlloPost {
	/**
	 * 
	 * @param postA
	 * @param postB
	 * @param filtro
	 * @return il metodo ritorna una collezione di FeedMessage
	 */
	public static Collection<FeedMessage> checkpost (Collection<FeedMessage>postA, Collection<FeedMessage>postB, String filtro){
		
		Collection<FeedMessage> c = new ArrayList<FeedMessage>();
		boolean trovato = true;
		
		//Controllo da A a B
		
		//LOG
		System.out.println (". Controllo Post presenti nella bacheca \"A\" e non nella bacheca \"B\".");
		if(postA!=null){
			for(FeedMessage f : postA){
				if(ControlloPost.controllofiltro(filtro, f.getCategory())){
				trovato = false;
					if(postB!=null){
						for(FeedMessage m : postB){
							if(( (f.getTitle().equals(m.getTitle()) && (f.getDescription().equals(m.getDescription()))) && (f.getCategory().equals(m.getCategory())) )){
								trovato = true;
							}
						}
					}
					if(trovato == false){
						c.add(f);
					}
				}
				
				else continue;
			}
		}
		
		
		//Controllo da B ad A
		
		//LOG
		System.out.println (". Controllo Post presenti nella bacheca \"B\" e non nella bacheca \"A\".");

		if(postB!=null){
			for(FeedMessage f : postB){
				if(ControlloPost.controllofiltro(filtro, f.getCategory())){
				trovato = false;
					if(postA!=null){
						for(FeedMessage m : postA){
							if(( (f.getTitle().equals(m.getTitle()) && (f.getDescription().equals(m.getDescription())))  && (f.getCategory().equals(m.getCategory())) )){
								trovato = true;
							}
						}
					}
					if(trovato == false){
						c.add(f);
					}
				}
				else continue;
			}
		}
		
		//LOG
		System.out.println ("Sono stati trovati " + c.size() + " Post da propagare.");
		return c;
	}
	
	/**
	 * 
	 * @param filtro
	 * @param category
	 * @return il metodo ritorna un boolean a seconda che il filtro � uguale o no alle categorie di un post
	 */
	private static boolean controllofiltro(String filtro,String category){
		StringTokenizer cat = new StringTokenizer(category, ",");
		String[] category2 = new String[cat.countTokens()];
		for(int i=0; i<category2.length; i++){
			category2[i] = cat.nextToken();
		}
		
		StringTokenizer  fil = new StringTokenizer(filtro, ",");
		String[] filtro2 = new String[fil.countTokens()];
		for(int i=0; i<filtro2.length; i++){
			filtro2[i] = fil.nextToken();
		}
		
		int conta_filtri = filtro2.length;
		int contatore = 0;
		for(int i=0; i<filtro2.length; i++){
			for(int j=0; j<category2.length;j ++){
				if(filtro2[i].equals(category2[j])){
					contatore++;
					}
				}
			}
		if(contatore == conta_filtri)
			return true;
		return false;
	}
}