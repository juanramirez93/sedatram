package com.sedatram.controller.auxiliar;
import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.auxiliar.Department;

import javax.persistence.TypedQuery;
import java.util.List;

public class DepartmentController extends EM {

    private static DepartmentController instance;

    public static DepartmentController getInstance() {
        if(instance == null) {
            instance = new DepartmentController();
        }
        return instance;
    }

    public void save(Department department) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().merge(department);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }

    public List<Department> getAll() {
        open();
        TypedQuery<Department> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT d FROM Department d order by d.id", Department.class);
        return query.getResultList();
    }

    public boolean exist(String department) {
        for(Department dp : getAll()) {
            if(dp.getId().equals(department)) {
                return true;
            }
        }
        return false;
    }
}
