package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Amphitryon {
	/*
	 * Attributes
	 */
	private String country;
	private String cupFile;
	/*
	 * Binary tree ABB
	 */
	private Spectator root;
	/*
	 * 
	 */
	private Participant first;

	/*
	 * Constructor method
	 */
	public Amphitryon(String country, String cupFile) {

		this.country = country;
		this.cupFile = cupFile;
		root = null;
		first = null;

	}
	//------------------------------------------------------------------------------------------------------------------------//
	public void loadParticipants(String archive) throws InvalidRouteException {
		File file = new File(archive);
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines;
				while ((lines = br.readLine()) != null) {
					lines = br.readLine();
					String[] read = lines.split(",");
					addParticipantsLinkedList(read[0], read[1], read[2], read[3], read[4], read[5], read[6], read[7]);
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			throw new InvalidRouteException("La ruta ingresada no existe en el sistema");
		}

	}
	//------------------------------------------------------------------------------------------------------------------------//
	public void loadSpectator(String archive)throws InvalidRouteException {
		File file = new File(archive);
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines;
				while ((lines = br.readLine()) != null) {
					String[] read = lines.split(",");
					addSpectatorBinaryTreeABB(read[0], read[1], read[2], read[3], read[4], read[5], read[6], read[7]);
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new InvalidRouteException("La ruta ingresada no existe en el sistema");
		}
	}
	//------------------------------------------------------------------------------------------------------------------------//
	public Spectator getRoot() {
		return root;
	}
	//------------------------------------------------------------------------------------------------------------------------//
	public Participant getFirst() {
		return first;
	}
	//------------------------------------------------------------------------------------------------------------------------//
	/**
	 * Description: This method allows to insert in the binary tree, a spectator.
	 * 
	 * @param id
	 * @param fisrtName
	 * @param lastName
	 * @param email
	 * @param gender
	 * @param country
	 * @param photo
	 * @param birthDay
	 */
	public void addSpectatorBinaryTreeABB(String id, String fisrtName, String lastName, String email, String gender,
			String country, String photo, String birthDay) {

		Spectator s = new Spectator(id, fisrtName, lastName, email, gender, country, photo, birthDay);
		addSpectatorRecursive(s, this.root);
	}
	//------------------------------------------------------------------------------------------------------------------------//
	/**
	 * 
	 * @param spectator
	 * @param root
	 */
	public void addSpectatorRecursive(Spectator spectator, Spectator rootA) {

		if (root == null) {
			root = spectator;
		} else {
			if (spectator.getId().compareTo(rootA.getId()) < 0) {
				if (rootA.getLeft() == null) {
					rootA.setLeft(spectator);
				} else {
					addSpectatorRecursive(spectator, rootA.getLeft());
				}
			} else {
				if (rootA.getRigth() == null) {
					rootA.setRigth(spectator);
				} else {
					addSpectatorRecursive(spectator, rootA.getRigth());
				}

			}
		}
	}
	//------------------------------------------------------------------------------------------------------------------------//
	public void addParticipantsLinkedList(String id, String fisrtName, String lastName, String email, String gender,
			String country, String photo, String birthDay) {
		Participant p = new Participant(id, fisrtName, lastName, email, gender, country, photo, birthDay);
		addParticipantRecursive(this.first, p);
	}
    //------------------------------------------------------------------------------------------------------------------------//
	public void addParticipantRecursive(Participant firstA, Participant participant) {
		try {
			if (first == null) {
				first = participant;
				participant.setNext(null);
			} else {
				if (firstA.getNext() != null) {
					addParticipantRecursive(firstA.getNext(), participant);
				} else {
					firstA.setNext(participant);
					participant.setprevious(firstA);
					participant.setNext(null);
				}
			}
		} catch (StackOverflowError e) {
			e.getMessage();
		}
		
	}
	//------------------------------------------------------------------------------------------------------------------------//
	public void printBinaryTree(Spectator root, int level) {
		if (root == null)
			return;
		printBinaryTree(root.getRigth(), level + 1);
		if (level != 0) {
			for (int i = 0; i < level - 1; i++) {
				System.out.print("|\t");
			}
				System.out.println("|-------" + root.getId());
		} else {
			System.out.println(root.getId());
		}
		printBinaryTree(root.getLeft(), level + 1);
		
	}
	//------------------------------------------------------------------------------------------------------------------------//
	public String paintRecursive(Participant node) {
		String msj = "";
		if (node == null) {
			msj += "";
		} else {
			msj += "\n" + node + paintRecursive(node.getNext());
		}
		return msj;
	}
	//------------------------------------------------------------------------------------------------------------------------//
	public String searchInABB(String id,Spectator rootA) {
		if (rootA == null) {
			return "No hay registros en el sistema";
		}
		
		if (id.compareTo(rootA.getId())<0) {
			return searchInABB(id, rootA.getLeft());
		} else if(id.compareTo(rootA.getId())>0) {
			return searchInABB(id, rootA.getRigth());
		} else if(id.compareTo(rootA.getId())==0) {
			return rootA.toString();
		} else {
			return "El codigo buscado no se encuentra registrado en el arbol ABB";
		}

	}
	//------------------------------------------------------------------------------------------------------------------------//
	public String searchInLinkedList(String id,Participant firstA) {
		if (firstA==null) {
			return "No hay registros en el sistema";
		}
		if(id.compareTo(firstA.getId())!=0 && firstA.getNext() != null){
			return searchInLinkedList(id, firstA.getNext());
		} else if (id.compareTo(firstA.getId())==0) {
			return firstA.toString();
		} else {
			return "El codigo buscado no se encuentra registrado en la lista";
		}

	}
	//------------------------------------------------------------------------------------------------------------------------//
}
