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
   public static String readString()
   {
      br = new BufferedReader(new InputStreamReader(System.in));
 
      try
      {
         _String = br.readLine();
      }
      catch (IOException e)
      {
         System.out.println ("Errore di flusso!");
      }
 
      return(_String);
   }
 
   public static int readInt()
   {
      br = new BufferedReader(new InputStreamReader(System.in));
 
      try
      {
         _String = br.readLine();
         _int = Integer.parseInt(_String);
      }
      catch (IOException e1)
      {
         System.out.println ("Errore di flusso!");
      }
      catch (NumberFormatException e2)
      {
         System.out.println ("Errore di input da tastiera!");
         return(0);
      }
 
      return(_int);
   }
 
   public static char readChar()
   {
      br = new BufferedReader(new InputStreamReader(System.in));
 
      try
      {
         _String = br.readLine();
 
         if (_String.length() > 1)
            throw new NumberFormatException();
 
         _char = _String.charAt(0);
      }
      catch (IOException e1)
      {
         System.out.println ("Errore di flusso!");
      }
      catch (NumberFormatException e2)
      {
         System.out.println ("Errore di input da tastiera!");
         return(0);
      }
      catch(StringIndexOutOfBoundsException e3){
    	  System.out.println ("Impossibile inserire carattere vuoto!");
    	  return(0);
      }
      catch(NullPointerException e4){
    	  return(0);
      }
 
      return(_char);
   }
 
   public static float readFloat()
   {
      br = new BufferedReader(new InputStreamReader(System.in));
 
      try
      {
         _String = br.readLine();
         _float = Float.parseFloat(_String);
      }
      catch (IOException e1)
      {
         System.out.println ("Errore di flusso!");
      }
      catch (NumberFormatException e2)
      {
         System.out.println ("Errore di input da tastiera!");
         return(0);
      }
 
      return(_float);
   }
 
   public static double readDouble()
   {
      br = new BufferedReader(new InputStreamReader(System.in));
 
      try
      {
         _String = br.readLine();
         _double = Double.parseDouble(_String);
      }
      catch (IOException e1)
      {
         System.out.println ("Errore di flusso!");
      }
      catch (NumberFormatException e2)
      {
         System.out.println ("Errore di input da tastiera!");
         return(0);
      }
 
      return(_double);
   }
 
   private static BufferedReader br;
 
   private static String _String;
   private static int _int;
   private static char _char;
   private static float _float;
   private static double _double;
}