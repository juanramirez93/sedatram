package com.sedatram.controller;

import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.Buyer;
import com.sedatram.model.Person;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonController extends EM {

	/**
	 * static Singleton instance.
	 */
	private static volatile PersonController instance;

	/**
	 * Private constructor for singleton.
	 */
	private PersonController() {
	}

	/**
	 * Return a singleton instance of PersonController.
	 */
	public static PersonController getInstance() {
		// Double lock for thread safety.
		if (instance == null) {
			synchronized (PersonController.class) {
				if (instance == null) {
					instance = new PersonController();
				}
			}
		}
		return instance;
	}

	public void save(Person person) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().persist(person);
		EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
	}

	public List<Person> getAllCustomers() {
		open();
		TypedQuery<Person> query = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(
				"SELECT p FROM Person p WHERE p.customer = true " + "ORDER BY p.identification ASC", Person.class);
		List<Person> people = query.getResultList();
		return sort(people);
	}

	public List<Person> getAll() {
		open();
		TypedQuery<Person> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT p FROM Person p ORDER BY p.identification ASC", Person.class);
		return sort(query.getResultList());
	}

	public List<Person> searchCustomer(String str) {
		open();
		TypedQuery<Person> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT p FROM Person p WHERE p.typePerson = 'Cliente' AND p" + ".identification like '%"
						+ str + "%' OR REPLACE(p.identification" + ", '.', '') like '%" + str
						+ "%' OR p.acronym like '%" + str + "%' OR p.firstName like '%" + str
						+ "%' OR p.lastName like '%" + str + "%' ORDER BY p.identification ASC", Person.class);
		return sort(query.getResultList());
	}

	public boolean existCustomer(String id) {
		for (Person person : getAllCustomers()) {
			if (person.getIdentification().equals(id)) {
				return true;
			}
		}
		return false;
	}

	public Person getCustomer(String personId) {
		for (Person person : getAllCustomers()) {
			if (person.getIdentification().equals(personId)) {
				return person;
			}
		}
		return null;
	}

	public Person getPerson(String personId) {
		for (Person person : getAll()) {
			if (person.getIdentification().equals(personId)) {
				return person;
			}
		}
		return null;
	}

	public List<Person> sort(List<Person> people) {
		Collections.sort(people, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				long result = (extractLong(o1.getIdentification()) - extractLong(o2.getIdentification()));
				if (result > 0) {
					return 1;
				} else {
					return -1;
				}
			}

			long extractLong(String s) {
				String num = s.replaceAll("\\.", "");
				num = num.replaceAll("-", "");
				return Long.valueOf(num);
			}
		});
		return people;
	}

	public void saveBuyerAsPerson(Buyer data) {
		Person person = getCustomer(data.getIdentification());
		if (person == null) {
			person = new Person();
		}
		person.setAcronym(data.getAcronym());
		person.setAddress(data.getAddress());
		person.setCell(data.getCell());
		person.setCity(data.getCity());
		person.setDepartment(data.getDepartment());
		person.setEmail(data.getEmail());
		person.setFirstName(data.getFirstName());
		person.setIdentification(data.getIdentification());
		person.setLastName(data.getLastName());
		person.setPhone(data.getPhone());
		person.setTypeDocument(data.getTypeDocument());
		this.save(person);
	}
}
