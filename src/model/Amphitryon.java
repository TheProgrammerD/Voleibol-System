package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

	public void loadParticipants(String archive) {
		File file = new File(archive);
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				int iterator = 0;
				String lines;
				while ((lines = br.readLine()) != null) {

					lines = br.readLine();
					String[] read = lines.split(",");
					addParticipantsLinkedList(read[0], read[1], read[2], read[3], read[4], read[5], read[6], read[7]);

					iterator++;
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void loadSpectator(String archive) {
		File file = new File(archive);
		if (file.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String lines;
				while ((lines = br.readLine()) != null) {
					lines = br.readLine();
					String[] read = lines.split(",");
					addSpectatorBinaryTreeABB(read[0], read[1], read[2], read[3], read[4], read[5], read[6], read[7]);
				}
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Spectator getRoot() {
		return root;
	}

	public Participant getFirst() {
		return first;
	}

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

	public int countNodesABB(Spectator rootA) {
		int count = 0;
		if (rootA == null) {
			count = 0;
		} else {
			count = 1 + countNodesABB(rootA.getLeft()) + countNodesABB(rootA.getRigth());
		}
		return count;
	}

	public void addParticipantsLinkedList(String id, String fisrtName, String lastName, String email, String gender,
			String country, String photo, String birthDay) {
		Participant p = new Participant(id, fisrtName, lastName, email, gender, country, photo, birthDay);
		addParticipantRecursive(this.first, p);
	}

	public void addParticipantRecursive(Participant firstA, Participant participant) {
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
	}
	
	public void f(Spectator r) {
		if(r!=null) {
			f(r.getLeft());
			System.out.println(r);
			f(r.getRigth());
		}
	}

	public String paintRecursive(Participant node) {
		String msj = "";
		if (node == null) {
			msj += "";
		} else {
			msj += "\n" + node + paintRecursive(node.getNext());
		}
		return msj;
	}

}
