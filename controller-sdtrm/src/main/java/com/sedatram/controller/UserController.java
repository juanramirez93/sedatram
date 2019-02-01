package com.sedatram.controller;

import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserController extends EM {

    private static UserController instance;

    private UserController() {
    }

    public static UserController getInstance() {
        if(instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public List<User> getAll() {
        open();
        TypedQuery<User> query = EntityManagerHandler.INSTANCE.getEntityManager()
                .createQuery("SELECT u FROM User u ORDER BY u.user ASC", User.class);
        List<User> users = query.getResultList();
        return users;
    }

    public User[] getAllUsers() {
        List<User> users = getAll();
        if(users.isEmpty()) {
            User user = new User();
            user.setUser("admin");
            user.setPassword("admin");
            save(user);
            users.add(user);
        }
        User[] usersArray = new User[users.size()];
        usersArray = users.toArray(usersArray);
        return usersArray;
    }

    public void save(User user) {
        open();
        EntityManagerHandler.INSTANCE.getEntityManager().persist(user);
        EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
    }
}
