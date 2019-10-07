package model;

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

	public void loadParticipants() {

	}

	public void loadSpectator() {

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
		this.addSpectatorRecursive(s, this.root);

	}

	/**
	 * 
	 * @param spectator
	 * @param root
	 */
	public void addSpectatorRecursive(Spectator spectator, Spectator root) {
		if (root == null) {
			root = spectator;
		} else {
			if (spectator.getId().compareTo(root.getId()) < 0) {
				if (root.getLeft() == null) {
					root.setLeft(spectator);
				} else {
					addSpectatorRecursive(spectator, root.getLeft());
				}
			} else {
				if (root.getRigth() == null) {
					root.setRigth(spectator);
				} else {
					addSpectatorRecursive(spectator, root.getRigth());
				}

			}
		}
	}

	public void addParticipantLinkedList(String id, String fisrtName, String lastName, String email, String gender,
			String country, String photo, String birthDay) {

		Participant p = new Participant(id, fisrtName, lastName, email, gender, country, photo, birthDay);
		addParticipantSortRecursive(this.first, p);

	}

	/**
	 * Description: This method allows to insert a participant in the double linked list keeping it sort. 
	 * @param node  The node to realize comparisons.
	 * @param participant The new node to insert.
	 */
	public void addParticipantSortRecursive(Participant node, Participant participant) {
		//check if the first node is null, if it is true,the node will be insert here
		if (first == null) {
			first = participant;
			participant.setNext(null);
		}else if(node!=null) { //The first node is not null.
			if (node.getprevious()==null) {
				if (node.getId().compareTo(participant.getId())>0) {//The new participant is "minor" that the first
					participant.setNext(node);
					first = participant;
					node.setprevious(participant);
				} else {//The new participant is "major" that the first
					if (node.getNext() == null) {
						node.setNext(participant);
						participant.setprevious(node);
					} else {//Recursive method
						addParticipantSortRecursive(node.getNext(), participant);
					}
				}
			} else if(node.getNext()==null) {//The actual node is the last
				if (node.getId().compareTo(participant.getId())>0) {//The new participant is "minor" that the first
					Participant previous = node.getprevious();
					previous.setNext(participant);
					participant.setprevious(previous);
					participant.setNext(node);
				} else if (node.getId().compareTo(participant.getId())<=0) {//The new participant is "mayor" that the last
					node.setNext(participant);
					participant.setprevious(node);
					participant.setNext(null);
				} else {//Recursive method
					addParticipantSortRecursive(node.getNext(), participant);
				}
			} else if (node.getprevious()!=null && node.getNext() !=null) {
				if (node.getId().compareTo(participant.getId())>=0) {//The actual node is in the middle of the linked list
					Participant previous = node.getprevious();
					previous.setNext(participant);
					participant.setprevious(previous);
					participant.setNext(node);
				} else {//Recursive method
					addParticipantSortRecursive(node.getNext(), participant);
				}
			}	
		}
	}
	
	public String paintRecursive(Participant node) {
		String msj = "";
		if (node == null) {
			msj += "";
		}else {
			msj += "\n" + node + paintRecursive(node.getNext());
		}
		return msj;
	}

}
