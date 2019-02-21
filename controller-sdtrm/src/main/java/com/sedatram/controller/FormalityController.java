package com.sedatram.controller;

import java.util.List;

import javax.persistence.TypedQuery;

import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.Formality;
import com.sedatram.model.auxiliar.FormalityHandler;
import com.sedatram.model.auxiliar.TypeFormality;

public class FormalityController extends EM {

	private static FormalityController instance;

	private FormalityController() {
	}

	public static FormalityController getInstance() {
		if (instance == null) {
			instance = new FormalityController();
		}
		return instance;
	}

	public List<Formality> getAll() {
		open();
		TypedQuery<Formality> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT f FROM Formality f ORDER BY f" + ".initDate ASC", Formality.class);
		return query.getResultList();
	}

	public List<Formality> search(String s) {
		open();
		TypedQuery<Formality> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery(
						"SELECT f FROM Formality f WHERE f.customer.identification LIKE '%" + s + "%' OR f"
								+ ".customer.firstName LIKE '%" + s + "%' OR f.customer.lastName LIKE '%" + s + "%' OR "
								+ "f.status LIKE '%" + s + "%' OR f.type.name LIKE '%" + s
								+ "%' OR f.vehicle.plaque LIKE '%" + s + "%'  ORDER BY f.initDate ASC",
						Formality.class);
		return query.getResultList();
	}

	public List<TypeFormality> getAllTypes() {
		open();
		TypedQuery<TypeFormality> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT t FROM TypeFormality t order by t.name", TypeFormality.class);
		return typedQuery.getResultList();
	}

	public TypeFormality[] getAllTypesArray() {
		List<TypeFormality> formalities = getAllTypes();
		TypeFormality[] typeFormalities = new TypeFormality[formalities.size()];
		int i = 0;
		for (TypeFormality typeFormality : formalities) {
			typeFormalities[i] = typeFormality;
			i++;
		}
		return typeFormalities;
	}

	public void save(Formality formality) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().persist(formality);
		EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();

	}

	public FormalityHandler[] getAllHandlers() {
		open();
		TypedQuery<FormalityHandler> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT h FROM FormalityHandler h order by h.name", FormalityHandler.class);
		FormalityHandler[] handlers = new FormalityHandler[typedQuery.getResultList().size()];
		int i = 0;
		for (FormalityHandler handler : typedQuery.getResultList()) {
			handlers[i] = handler;
			i++;
		}
		return handlers;
	}

	public TypeFormality getType(Object object) {
		open();
		TypedQuery<TypeFormality> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createQuery(
				"SELECT t FROM TypeFormality t where t.name = '" + object + "' order by t.name", TypeFormality.class);
		return typedQuery.getSingleResult();
	}

	public void saveType(TypeFormality type) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().persist(type);
		EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
	}

	public void remove(TypeFormality type) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().remove(type);
		EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
	}
}
