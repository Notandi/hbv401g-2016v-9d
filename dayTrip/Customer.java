package dayTrip;

public class Customer {
	private String name;
	private int age;
	private String gender;
	private String nationality;
	private String email;
	
	public Customer (String name, int age, String gender, String nationality, String email ) {
		this.setName(name);
		this.setAge(age);
		this.setGender(gender);
		this.setNationality(nationality);
		this.setEmail(email);		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
