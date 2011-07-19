package manager;

import java.util.List;
import java.util.Scanner;

import lettura.LetturaPost;

public class Connector {

	private String uriA;
	private String uriB;
	private String filter;
	
	
	
	public Connector(String uriA, String uriB, String filter) {
	
		this.uriA = uriA;
		this.uriB = uriB;
		this.filter = filter;
	}
	public String getUriA() {
		return uriA;
	}
	public void setUriA(String uriA) {
		this.uriA = uriA;
	}
	public String getUriB() {
		return uriB;
	}
	public void setUriB(String uriB) {
		this.uriB = uriB;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.print("inserisci uri bacheca A:");
		String uriA = in.next();
		System.out.print("inserisci uri bacheca B:");
		String uriB = in.next();		
	    System.out.print("vuopi filtrare i post da inoltrare?[S/N]");
		String filter = in.next();
		if(filter.equals("S")){
			System.out.print("inserisci categoria:");
			String category =in.next();
			System.out.print("inserisci autore:");
			String author =in.next();
		} else if(filter.equals("N")){
			System.out.println("non hai impostato nessun filtro!");
		}else{
			System.exit(0);
		}
	}
	
}
