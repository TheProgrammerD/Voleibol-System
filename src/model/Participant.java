package model;

public class Participant extends Candidate {
	
	private Participant previous;
	private Participant next;

	public Participant(String id, String fisrtName, String lastName, String email, String gender, String country,
			String photo, String birthDay) {
		super(id, fisrtName, lastName, email, gender, country, photo, birthDay);
		previous = null;
		next = null;
	}

	public Participant getprevious() {
		return previous;
	}

	public void setprevious(Participant previous) {
		this.previous = previous;
	}

	public Participant getNext() {
		return next;
	}

	public void setNext(Participant next) {
		this.next = next;
	}


	
	
	
	
	
}
