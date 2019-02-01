package com.sedatram.controller;

import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.Vehicle;

import javax.persistence.TypedQuery;
import java.util.List;

public class VehicleController extends EM {

    private static VehicleController instance;

    public static VehicleController getInstance() {
        if (instance == null) {
            instance = new VehicleController();
        }
        return instance;
    }

    public void save(Vehicle vehicle) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(vehicle);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    public List<Vehicle> getAll() {
        open();
        TypedQuery<Vehicle> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT v FROM Vehicle v ORDER BY v.plaque ASC",
                        Vehicle.class);
        return query.getResultList();
    }

    public List<Vehicle> search(String s) {
        open();
        TypedQuery<Vehicle> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT v FROM Vehicle v WHERE v.plaque LIKE '%" + s + "%' OR v" +
                                ".service LIKE '%" + s + "%' OR v.type LIKE '%" + s + "%' OR v" +
                                ".brand LIKE '%" + s + "%' OR v.line LIKE '%" + s + "%' OR v" +
                                ".model LIKE '%" + s + "%' ORDER BY v.plaque ASC",
                        Vehicle.class);
        return query.getResultList();
    }

    public void delete(Vehicle vehicle) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().remove(vehicle);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    public Vehicle getVehicle(String text) {
        for (Vehicle vehicle : getAll()) {
            if (vehicle.getPlaque().equals(text)) {
                return vehicle;
            }
        }
        return null;
    }
}
