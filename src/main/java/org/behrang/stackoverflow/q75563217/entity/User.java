package org.behrang.stackoverflow.q75563217.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date createdAt;

    private String email;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Deletion> deletions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Deletion> getDeletions() {
        return deletions;
    }

    public void setDeletions(List<Deletion> deletions) {
        this.deletions = deletions;
    }

    public void addDeletion(Deletion deletion) {
        this.deletions.add(deletion);
    }
}
