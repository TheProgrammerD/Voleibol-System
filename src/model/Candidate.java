package model;

public class Candidate {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthDay;
	
	public Candidate(String id, String firstName, String lastName, String email, String gender, String country,
			String photo, String birthDay) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", fisrtName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", country=" + country + ", photo=" + photo + ", birthDay=" + birthDay + "]";
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public String getPhoto() {
		return photo;
	}

	public String getBirthDay() {
		return birthDay;
	}
	
	


	
	
	
	
	
}
