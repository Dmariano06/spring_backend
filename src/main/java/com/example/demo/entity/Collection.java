package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="collections")
public class Collection
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "nom")
    private String nom;

}
