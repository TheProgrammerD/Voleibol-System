package model;

public class pruebas {
	
	
	public static void main(String[] args) {
		Amphitryon a = new Amphitryon("", "");
		
		a.loadParticipants("./files/loadData.csv");
		a.loadSpectator("./files/loadData.csv");
		System.out.println(a.paintRecursive(a.getFirst()));
		a.f(a.getRoot());
		
		
	}
	
	
}
