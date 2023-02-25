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

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Instant i1 = Instant.now().minus(Duration.ofHours(25));
        User u1 = new User();
        u1.setEmail("1@example.com");
        u1.setCreatedAt(Date.from(i1));

        Deletion d01 = new Deletion();
        d01.setDate(Date.from(Instant.now()));
        d01.setUser(u1);
        u1.addDeletion(d01);

        entityManager.persist(u1);

        tx.commit();
        entityManager.close();

        entityManager = factory.createEntityManager();
        tx = entityManager.getTransaction();
        tx.begin();

        Deletion d11 = entityManager.find(Deletion.class, 1L);
        entityManager.remove(d11);

        tx.commit();
        entityManager.close();

        factory.close();
    }
}
