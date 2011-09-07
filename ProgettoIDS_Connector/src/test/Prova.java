package test;

import java.util.StringTokenizer;

public class Prova {
	public static void main(String[]args){
		String category = "ciao,ciao1,ciao2";
		String filtro = "bo,ciao";
		StringTokenizer cat = new StringTokenizer(category, ",");
		String[] category2 = new String[cat.countTokens()];
		for(int i=0;i<category2.length;i++){
			category2[i] = cat.nextToken();
			System.out.println(category2[i]);
		}
		StringTokenizer  fil = new StringTokenizer(filtro, ",");
		String[] filtro2 = new String[fil.countTokens()];
		for(int i=0;i<filtro2.length;i++){
			filtro2[i] = fil.nextToken();
			System.out.println(filtro2[i]);
		}
		for(int i=0;i<filtro2.length;i++){
			for(int j=0;j<category2.length;j++){
				if(filtro2[i].equals(category2[j])){
					System.out.println("Trovato XD");
					break;
				}
			}
		}
	}
}