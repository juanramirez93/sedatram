package com.sedatram.entityManager;
public class EM {
    public void open() {
        EntityManagerHandler.INSTANCE.open();
    }

    public void shutdown() {
        EntityManagerHandler.INSTANCE.shutdown();
    }
}