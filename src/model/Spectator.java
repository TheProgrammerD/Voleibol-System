package model;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class Spectator extends Candidate {

	private Spectator left;
	private Spectator rigth;

	public Spectator(String id, String fisrtName, String lastName, String email, String gender, String country,
			String photo, String birthDay) {
		super(id, fisrtName, lastName, email, gender, country, photo, birthDay);
		this.left = null;
		this.rigth = null;
	}

	public Spectator getLeft() {
		return left;
	}

	public void setLeft(Spectator left) {
		this.left = left;
	}

	public Spectator getRigth() {
		return rigth;
	}

	public void setRigth(Spectator rigth) {
		this.rigth = rigth;
	}

	

}
