package org.behrang.stackoverflow.q75563217;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.behrang.stackoverflow.q75563217.entity.Deletion;
import org.behrang.stackoverflow.q75563217.entity.User;

import java.sql.Date;
import java.time.Duration;
import java.time.Instant;

public class DeleteExample {
    public static void main(String[] args) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        final EntityManager entityManager = factory.createEntityManager();
        final EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Deletion d1 = entityManager.find(Deletion.class, 1L);
        entityManager.remove(d1);

        tx.commit();
        entityManager.close();
        factory.close();
    }
}
