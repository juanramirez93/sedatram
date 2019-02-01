package com.sedatram.controller;

import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.Formality;
import com.sedatram.model.auxiliar.TypeFormality;

import javax.persistence.TypedQuery;
import java.util.List;

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
                .createQuery("SELECT f FROM Formality f ORDER BY f" +
                                ".initDate ASC",
                        Formality.class);
        return query.getResultList();
    }

    public List<Formality> search(String s) {
        open();
        TypedQuery<Formality> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT f FROM Formality f WHERE f.customer.identification LIKE '%" + s + "%' OR f" +
                                ".customer.firstName LIKE '%" + s + "%' OR f.customer.lastName LIKE '%" + s + "%' OR " +
                                "f.status LIKE '%" + s + "%' OR f.type.name LIKE '%" + s + "%' OR f.vehicle.plaque LIKE '%" +
                                s + "%'  ORDER BY f.initDate ASC",
                        Formality.class);
        return query.getResultList();
    }

    public TypeFormality[] getAllTypes() {
        open();
        TypedQuery<TypeFormality> typedQuery = EntityManagerHandler.INSTANCE.getEntityManager().createQuery("SELECT t" +
                " FROM TypeFormality t order by t.name", TypeFormality.class);
        TypeFormality[] typeFormalities = new TypeFormality[typedQuery.getResultList().size()];
        int i = 0;
        for (TypeFormality typeFormality : typedQuery.getResultList()) {
            typeFormalities[i] = typeFormality;
            i++;
        }
        return typeFormalities;
    }
}
