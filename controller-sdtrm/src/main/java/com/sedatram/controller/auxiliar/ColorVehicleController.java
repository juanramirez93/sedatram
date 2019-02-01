package com.sedatram.controller.auxiliar;
import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.auxiliar.ColorVehicle;

import javax.persistence.TypedQuery;
import java.util.List;

public class ColorVehicleController extends EM {

    private static ColorVehicleController instance;

    public static ColorVehicleController getInstance() {
        if(instance == null) {
            instance = new ColorVehicleController();
        }
        return instance;
    }

    public void save(String colorVehicle) {
        if(!exist(colorVehicle) && colorVehicle.length() != 0) {
            open();
            ColorVehicle color = new ColorVehicle(colorVehicle);
            EntityManagerHandler.INSTANCE.getEntityManager().persist(color);
            EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
        }
    }

    public List<ColorVehicle> getAll() {
        open();
        TypedQuery<ColorVehicle> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT c FROM ColorVehicle c", ColorVehicle.class);
        return query.getResultList();
    }

    private boolean exist(String colorV) {
        for(ColorVehicle colorVehicle : getAll()) {
            if(colorVehicle.getId().equals(colorV)) {
                return true;
            }
        }
        return false;
    }
}
