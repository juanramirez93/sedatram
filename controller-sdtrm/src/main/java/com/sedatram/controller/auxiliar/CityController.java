package com.sedatram.controller.auxiliar;
import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.auxiliar.City;

import javax.persistence.TypedQuery;
import java.util.List;

public class CityController extends EM {

    private static CityController instance;

    public static CityController getInstance() {
        if(instance == null) {
            instance = new CityController();
        }
        return instance;
    }

    public void save(City city) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(city);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    public List<City> getAll() {
        open();
        TypedQuery<City> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT c FROM City c", City.class);
        return query.getResultList();
    }

    public boolean exist(String city) {
        for(City city1 : getAll()) {
            if(city1.getId().equals(city)) {
                return true;
            }
        }
        return false;
    }
}
