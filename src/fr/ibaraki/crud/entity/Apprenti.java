package fr.ibaraki.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apprentis")
public class Apprenti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String propotion;

    private String lastName;
    
    private String firstName;
    
    private String phone;
    
    private int absences;
    
    private boolean delegue;

    private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropotion() {
		return propotion;
	}

	public void setPropotion(String propotion) {
		this.propotion = propotion;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAbsences() {
		return absences;
	}

	public void setAbsences(int absences) {
		this.absences = absences;
	}

	public boolean getDelegue() {
		return delegue;
	}

	public void setDelegue(boolean delegue) {
		this.delegue = delegue;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Apprenti{" +
				"\"id\":\"" + this.id + "\"," +
				"\"promotion\":\"" + this.propotion + "\"," +
				"\"lastName\":\"" + this.lastName+ "\"," +
				"\"firstName\":\"" + this.firstName + "\"," +
				"\"phone\":\"" + this.phone + "\"," +
				"\"abscences\":\"" + this.absences+ "\"," +
				"\"delegue\":\"" + this.delegue + "\"," +
				"\"email\":\"" + this.email + "\"" +
		"}";
	}
    
}
