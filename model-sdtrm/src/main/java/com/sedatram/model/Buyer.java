package com.sedatram.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private int id;
	private String typeDocument;
	@Column(nullable = false, unique = true)
	private String identification;
	private String firstName;
	private String lastName = "";
	private String acronym = "";
	private String phone = "";
	private String cell = "";
	private String email = "";
	private String address = "";
	private String city = "";
	private String department = "";
	private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String editedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date editedAt;
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public Date getEditedAt() {
		return editedAt;
	}

	public void setEditedAt(Date editedAt) {
		this.editedAt = editedAt;
	}

	public List<Formality> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Formality> procedures) {
		this.procedures = procedures;
	}

	@ManyToMany(mappedBy = "buyers")
	private List<Formality> procedures = new ArrayList<>();

	public Buyer() {
	}

	public String getAcronym() {
		return acronym;
	}

	public String getAddress() {
		return address;
	}

	public String getCell() {
		return cell;
	}

	public String getCity() {
		return city;
	}

	public void getDataFromPerson(Person person) {
		this.typeDocument = person.getTypeDocument();
		this.identification = person.getIdentification();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.acronym = person.getAcronym();
		this.address = person.getAddress();
		this.cell = person.getCell();
		this.city = person.getCity();
		this.department = person.getDepartment();
		this.email = person.getEmail();
		this.phone = person.getPhone();
	}

	public String getDepartment() {
		return department;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public List<Formality> getFormalities() {
		return procedures;
	}

	public int getId() {
		return id;
	}

	public String getIdentification() {
		return identification;
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		if (typeDocument == null) {
			return "";
		}
		if (typeDocument.equals("NIT")) {
			if (acronym.isEmpty()) {
				return firstName;
			}
			return acronym + " - " + firstName;
		}
		return firstName + " " + lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFormalities(List<Formality> procedures) {
		this.procedures = procedures;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

}
