package model;

public class pruebas {
	
	
	public static void main(String[] args) {
		Amphitryon a = new Amphitryon("", "");
		
		a.addParticipantLinkedList("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("F", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("D", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("B", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("AB", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		a.addParticipantLinkedList("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		
		
		System.out.println(a.paintRecursive(a.getFirst()));
		
	}
	
	
}
