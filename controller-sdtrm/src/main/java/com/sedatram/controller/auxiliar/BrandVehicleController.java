package com.sedatram.controller.auxiliar;
import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.auxiliar.BrandVehicle;

import javax.persistence.TypedQuery;
import java.util.List;

public class BrandVehicleController extends EM {

    private static BrandVehicleController instance;

    public static BrandVehicleController getInstance() {
        if(instance == null) {
            instance = new BrandVehicleController();
        }
        return instance;
    }

    public void save(String brandVehicle) {
        if(!exist(brandVehicle) && brandVehicle.length() != 0) {
            open();
            BrandVehicle brand = new BrandVehicle(brandVehicle);
            EntityManagerHandler.INSTANCE.getEntityManager().persist(brand);
            EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
        }
    }

    public List<BrandVehicle> getAll() {
        open();
        TypedQuery<BrandVehicle> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT b FROM BrandVehicle b", BrandVehicle.class);
        return query.getResultList();
    }

    private boolean exist(String brandV) {
        for(BrandVehicle brandVehicle : getAll()) {
            if(brandVehicle.getId().equals(brandV)) {
                return true;
            }
        }
        return false;
    }
}
