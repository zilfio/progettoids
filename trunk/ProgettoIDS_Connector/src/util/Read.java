package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 * 
 * @author Zilfio
 *
 */
public class Read{
	
	private static BufferedReader br;
	private static String _String;
	
	public static String readString(){
	   
      br = new BufferedReader(new InputStreamReader(System.in));
 
      try {
         _String = br.readLine();
      }
      catch (IOException e){
         System.out.println ("Errore di flusso!");
      }
 
      return(_String);
   }
}