package model;

public class Candidate {
	
	private String id;
	private String fisrtName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthDay;
	
	public Candidate(String id, String fisrtName, String lastName, String email, String gender, String country,
			String photo, String birthDay) {
		
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", country=" + country + ", photo=" + photo + ", birthDay=" + birthDay + "]";
	}

	public String getId() {
		return id;
	}


	
	
	
	
	
}
