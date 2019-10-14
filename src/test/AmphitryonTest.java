package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.crypto.AEADBadTagException;

import org.junit.jupiter.api.Test;

import model.Amphitryon;
import model.Spectator;

class AmphitryonTest {
	private Amphitryon amphy;
	
	private void setupScenary1() {
		amphy = new Amphitryon("DinoLandia", "F");
	}
	
	private void setupScenary2() {
		amphy = new Amphitryon("DinoLandia", "F");
		
		amphy.addSpectatorBinaryTreeABB("B", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("F", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("D", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("AB", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
	}
	
	@Test
	void testAddSpectatorBinaryTreeABB() {
		setupScenary1();
		amphy.addSpectatorBinaryTreeABB("B", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("F", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("D", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("AB", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		amphy.addSpectatorBinaryTreeABB("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		
		assertEquals("B", amphy.getRoot().getId());
	}
	
	@Test
	void testAddSpectatorRecursive() {
		setupScenary1();
		Spectator s = new Spectator("B", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s1 = new Spectator("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s2 = new Spectator("F", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s3 = new Spectator("D", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s4 = new Spectator("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s5 = new Spectator("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s6 = new Spectator("AB", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s7 = new Spectator("M", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s8 = new Spectator("O", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		Spectator s9 = new Spectator("A", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		
		amphy.addSpectatorRecursive(s, amphy.getRoot());
		amphy.addSpectatorRecursive(s1, amphy.getRoot());
		amphy.addSpectatorRecursive(s2, amphy.getRoot());
		amphy.addSpectatorRecursive(s3, amphy.getRoot());
		amphy.addSpectatorRecursive(s4, amphy.getRoot());
		amphy.addSpectatorRecursive(s5, amphy.getRoot());
		amphy.addSpectatorRecursive(s6, amphy.getRoot());
		amphy.addSpectatorRecursive(s7, amphy.getRoot());
		amphy.addSpectatorRecursive(s8, amphy.getRoot());
		amphy.addSpectatorRecursive(s9, amphy.getRoot());
		
		assertEquals("B", amphy.getRoot().getId());
	}
	
	@Test
	void testSearchByIDABB() {
		setupScenary2();
		
		Spectator s2 = new Spectator("F", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		assertEquals(s2.toString(), amphy.searchInABB("F", amphy.getRoot()));
		
	}
	
	@Test
	void testSearchByIDABB2() {
		setupScenary2();
		
		Spectator s2 = new Spectator("F", "Nombre", "Apellido", "email", "gender", "country", "photo", "birthDay");
		assertEquals("No hay registros en el sistema", amphy.searchInABB("AM", amphy.getRoot()));
		
	}
	@Test
	void testSearchByIDABBCase2() {
		setupScenary1();
		assertEquals("No hay registros en el sistema", amphy.searchInABB("F", amphy.getRoot()));
		
	}

}
