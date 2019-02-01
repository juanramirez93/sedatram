package com.sedatram.controller.auxiliar;
import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.auxiliar.TypeVehicle;

import javax.persistence.TypedQuery;
import java.util.List;

public class TypeVehicleController extends EM {

    private static TypeVehicleController instance;

    public static TypeVehicleController getInstance() {
        if(instance == null) {
            instance = new TypeVehicleController();
        }
        return instance;
    }

    public void save(String typeVehicle) {
        if(!exist(typeVehicle) && typeVehicle.length() != 0) {
            open();
            TypeVehicle type = new TypeVehicle(typeVehicle);
            EntityManagerHandler.INSTANCE.getEntityManager().persist(type);
            EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
        }
    }

    public List<TypeVehicle> getAll() {
        open();
        TypedQuery<TypeVehicle> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT t FROM TypeVehicle t", TypeVehicle.class);
        return query.getResultList();
    }

    private boolean exist(String typeV) {
        for(TypeVehicle typeVehicle : getAll()) {
            if(typeVehicle.getId().equals(typeV)) {
                return true;
            }
        }
        return false;
    }
}
